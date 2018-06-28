package Leetcode;

public class ThreeEightFour {

}
class Solution {
    int[] obj;

    public Solution(int[] nums) {
        this.obj=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.obj;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int thesize=this.obj.length;
        HashSet<Integer> theset=new HashSet<Integer>();
        int[] res=new int[thesize];
        Random r=new Random();
        for(int i=0; i<thesize; i++){
            int j=r.nextInt(thesize);
            if(theset.add(j)) {
                res[i]=obj[j];
            }else i--;
        }
        return res;
    }
}
