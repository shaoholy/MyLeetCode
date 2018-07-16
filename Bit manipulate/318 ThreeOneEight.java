package Leetcode;

public class ThreeOneEight {

}
//TreeSet to order pre, contains to check dupli
class Solution {
    public int maxProduct(String[] words) {
        int res=0;
        if(words==null || words.length==0 || words.length==1) return res;
        TreeSet<String> lenq=new TreeSet<String>(new Comparator<String>(){
            public int compare(String a, String b){
                return (b.length()-a.length())==0? a.hashCode()-b.hashCode(): (b.length()-a.length());
            }
        });
        lenq.add(words[0]);
        boolean feasi;
        for(int i=1; i<words.length; i++){
            for(String com: lenq){
                feasi=true;
                for(int j=0; j<words[i].length(); j++){
                    if(com.contains(String.valueOf(words[i].charAt(j)))){
                        feasi=false;
                        break;
                    }
                }
                if(feasi) {
                    res=Math.max(res, com.length()*words[i].length());
                    break;
                }
            }
            lenq.add(words[i]);
        }
        return res;
    }
}
//bit manipulation
class Solution {
    public int maxProduct(String[] words) {
        int res=0;
        if(words==null || words.length==0 || words.length==1) return res;
        int[] values=new int[words.length];
        for(int i=0; i<words.length; i++){
            values[i]=0;
            for(int j=0; j<words[i].length(); j++){
                values[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        
        for(int i=1; i<words.length; i++){
            for(int j=i-1; j>=0; j--){
                if((values[j]&values[i])==0) res=Math.max(res, words[j].length()*words[i].length());
            }
        }
        return res;
    }
}
