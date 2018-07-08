package Leetcode;

public class ThreeFourNine {

}
//Array.sorts. O(mlogn+nlogn) time. 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0|| nums2.length==0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> res=new HashSet<Integer>();
        int idx1=0, idx2=0;
        while(idx1<nums1.length && idx2<nums2.length){
            if(nums1[idx1]==nums2[idx2]){
                res.add(nums1[idx1]);
                idx1++;
                idx2++;
            }else if(nums1[idx1]>nums2[idx2]) idx2++;
            else idx1++;
        }
        int[] resarray=new int[res.size()];
        int i=0;
        for(int x: res){
            resarray[i]=x;
            i++;
        }
        return resarray;
    }
}
//HashSet O(M+N)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res=new HashSet<Integer>();
        List<Integer> reslist=new ArrayList<> ();
        for(int x:nums1) res.add(x); 
        for(int y:nums2){
            if(res.contains(y)) {
                reslist.add(y);
                res.remove(y);
            }
        }
        int[] resarray=new int[reslist.size()];
        int i=0;
        for(int x: reslist) resarray[i++]=x;
        return resarray;
    }
}