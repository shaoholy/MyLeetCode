package Leetcode;

public class Four {

}
//O(log(M+N)), zhongdian k/2+k/2 未必等于k。应该用k/2+(k-k/2)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1==null || nums1.length==0) &&(nums2==null || nums2.length==0) ) return 0;
        int m=nums1.length, n=nums2.length;
        int lpoint=(m+n+1)/2,rpoint=(m+n+2)/2;
        return (getkfromtwo(nums1,0,nums2, 0, lpoint)+getkfromtwo(nums1,0,nums2,0,rpoint))/2.0;
        }
    private int getkfromtwo(int[] nums1, int astart, int[] nums2,int bstart,int k){
        if(astart>nums1.length-1) return nums2[bstart+k-1];
        if(bstart>nums2.length-1) return nums1[astart+k-1];
        if(k==1) return Math.min(nums1[astart], nums2[bstart]);
        
        int mida=Integer.MAX_VALUE, midb=Integer.MIN_VALUE;
        if(astart+k/2-1<nums1.length) mida=nums1[astart+k/2-1];
        if(bstart+k/2-1<nums2.length) midb=nums2[bstart+k/2-1];
        
        if(mida<midb) return getkfromtwo(nums1, astart+k/2, nums2, bstart, k-k/2);
        else return getkfromtwo(nums1, astart, nums2, bstart+k/2, k-k/2);
    }
}