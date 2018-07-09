package Leetcode;

public class ThreeOneFive {

}
//merge sort o(NlogN). First mergesort, using rightcount to write count[], as counting every smaller elements from right into count[left]
//zuihou, return count[]
class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        int[] index=new int[nums.length];
        count=new int[nums.length];
        Arrays.fill(count, 0);
        for(int i=0; i<nums.length; i++) index[i]=i;
        mergesort(nums, index, 0, nums.length-1);
        for(int i=0; i<nums.length; i++) res.add(count[i]);
        return res;
    }
    
    private void mergesort(int[] nums, int[] index, int start, int end){
        if(start>=end ) return; 
        
        int mid=start+(end-start)/2;
        mergesort(nums, index, start, mid);
        mergesort(nums, index, mid+1, end);
        
        int leftidx=start, rightidx=mid+1;
        int[] newidx=new int[end-start+1];
        
        
        int idx1=start, idx2=mid+1, idxtemp=0, rightcount=0;
        
        while(idx1<=mid || idx2<=end){
            if(idx1>mid){
                newidx[idxtemp]=index[idx2];
                idx2++;
            }else if(idx2>end){
                newidx[idxtemp]=index[idx1];
                count[index[idx1]]+=rightcount;
                idx1++;
            }else if(nums[index[idx1]]>nums[index[idx2]]){
                newidx[idxtemp]=index[idx2];
                idx2++;
                rightcount++;
            }else{
                newidx[idxtemp]=index[idx1];
                count[index[idx1]]+=rightcount;
                idx1++;
            }
            idxtemp++;
        }
        for(int i=start; i<=end; i++){
            index[i]=newidx[i-start];
        }
    }
}