package Leetcode2;

public class Five {

}
//1, mid-out enumeration O(N^2)
public String longestPalindrome(String s) {
    String res="";
	if(s.length()==0) return res;
	if(s.length()==1) return s;
	for(int mid=0; mid<s.length()-1;mid++) {
        if(s.length()-mid<res.length()/2) break;
		int left=mid-1,right=mid+1;
		while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		res=s.substring(left+1, right).length()>res.length()? s.substring(left+1, right):res;
		
		left=mid;
		right=mid+1;
		while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		res=s.substring(left+1, right).length()>res.length()? s.substring(left+1, right):res;
	}
	
	return res;
}

//2, 2D DP
public String longestPalindrome(String s) {
    String res="";
	if(s.length() == 0) return res;
	if(s.length() == 1) return s;
	
    int n = s.length();
    boolean[][] dp = new boolean[n+1][n+1]; 
    /*dp[i][j] as isPalindrome of s.substring(i, j)
    dp[i][j] isPalindrome, when 
    1, dp[i+1][j-1] && s.charAt(j-1) == s.charAt(i) || dp[][j-1]
    2, if(j-i == 1) dp[i][j] = true;
    3, if(j - i ==2) dp[i][j] = s.charAt(j-1) == s.charAt(i)*/
    
    for(int j = 1; j <= n; j++){
        for(int i = 0; i < j; i++){
            if(j - i == 1){
                dp[i][j] = true; 
            }else if(j - i ==2){
                dp[i][j] = (s.charAt(j-1) == s.charAt(i));
            }else{
                dp[i][j] = (s.charAt(j-1) == s.charAt(i) && dp[i+1][j-1]);
            }
            
            if(dp[i][j] && j-i > res.length()){
                res = s.substring(i, j); 
            }
        }
    }
    
    return res; 
}

//3 manache
public String longestPalindrome(String s) {
    String res="";
	if(s.length() == 0) return res;
	if(s.length() == 1) return s;
    
    //1, step1, make aba  ———>  #a#b#a#
    StringBuilder nsb = new StringBuilder(s);
    for(int i = 0; i <= s.length(); i++ ){
        nsb.insert(i*2, '#'); 
    }
    
    //step2, manache iteration
    int MaxRight = 0, pos = 0;
    int[] RL = new int[nsb.length()];
    
    for(int i = 0; i<nsb.length(); i++){
        RL[i] = MaxRight <= i?  1 : Math.min(RL[2 * pos - i] , MaxRight - i + 1);
        while(i - RL[i] >= 0 && i + RL[i] < nsb.length() && 
             nsb.charAt(i - RL[i]) == nsb.charAt(i + RL[i])){
            RL[i]++;
        }
        
        //update pos and MaxRight
        if(i + RL[i] -1 > MaxRight){
            pos = i; 
            MaxRight = i + RL[i] -1;
        }
        //update res
        if(RL[i] > (res.length()+1)/2){
            res = nsb.substring(i - RL[i] + 1, i + RL[i]);
        }
        
        if(MaxRight == nsb.length()-1 || (res.length()+1)/2 >= nsb.length()-i){
            break;}
    }
    return res.replaceAll("#", ""); 
}