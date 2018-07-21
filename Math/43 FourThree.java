package Leetcode2;

public class FourThree {

}
//each degree iteration
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0) return "0";
        int[] res=new int[num1.length()+num2.length()];
        int carry=0;
        char[] n1array=num1.toCharArray();
        char[] n2array=num2.toCharArray();
        reverse(n1array);
        reverse(n2array);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<n1array.length && j<=i ; j++){
                if((i-j)>=n2array.length) continue;
                res[i]+=(n1array[j]-'0')*(n2array[i-j]-'0');
            }
            int temp=res[i]%10;
            if(i<res.length-1) res[i+1]+=res[i]/10;
            res[i]=temp;
            //System.out.println(res[i]+" : "+i);
        }
        //for(int i=0; i<res.length;i++) System.out.println(res[i]);
        StringBuilder resstr=new StringBuilder();
        int start=res.length-1;
        while(start>=0 && res[start]==0) start--;
        if(start<0) return "0";
        for(int i=start; i>=0; i--) 
            resstr.append(res[i]);
        return resstr.toString();
    }
    private void reverse(char[] input){
        int left=0, right=input.length-1;
        while(left<right){
            char temp=input[left];
            input[left++]=input[right];
            input[right--]=temp;
        }
    }
}

//simpify o(mn)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0) return "0";
        int[] res=new int[num1.length()+num2.length()];
        
        for(int i=num1.length()-1; i>=0; i-- ){
            for(int j=num2.length()-1; j>=0; j--){
                int posi=i+j+1;
                int nextp=i+j;
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=mul+res[posi];
                res[posi]=sum%10;
                res[nextp]+=sum/10;
            }
        }
        //for(int i=0; i<res.length;i++) System.out.println(res[i]);
        StringBuilder resstr=new StringBuilder();
        int start=0;
        while(start<res.length && res[start]==0) start++;
        if(start==res.length) return "0";
        for(int i=start; i<res.length; i++) 
            resstr.append(res[i]);
        return resstr.toString();
    }
}