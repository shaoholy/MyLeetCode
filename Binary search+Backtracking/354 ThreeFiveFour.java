package Leetcode;

public class ThreeFiveFour {

}
//1, Arrays.binarySearch 找目标idx或插入点，O(logN)， 
//2， 354第一步是对其一个维度，在对其他维度进行300操作；
//overall O(NlogN) time
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0 || envelopes[0]==null || envelopes[0].length!=2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0]==b[0]){
                   return b[1]-a[1];
               }else return a[0]-b[0];
           } 
        });
        
        int[] tails=new int[envelopes.length];
        int max=0;
        for(int i=0; i<envelopes.length; i++){
            int newidx=Arrays.binarySearch(tails,0,max,envelopes[i][1]);
            if(newidx<0) newidx=-(newidx+1); 
            if(newidx==max) max++;
            tails[newidx]=envelopes[i][1];
        }
        return max;
    }
}