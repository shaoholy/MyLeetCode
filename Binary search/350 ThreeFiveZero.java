package Leetcode;

public class ThreeFiveZero {

}
//1, HashMap for base condition O(M+N)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1=new HashMap<>();
        for(int x: nums1) map1.put(x, map1.getOrDefault(x, 0)+1);
        List<Integer> res=new LinkedList<Integer>();
        for(int y:nums2){
            if(map1.containsKey(y)){
                res.add(y);
                if(map1.get(y)==1) map1.remove(y);
                else map1.put(y, map1.get(y)-1);
            }
        }
        int[] resarray=new int[res.size()];
        int i=0;
        for(int z: res) resarray[i++]=z;
        return resarray;
    }
}
//What if sorted? worst case still o(m+n), best case n or m. better than 1st. 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int idx1=0, idx2=0,i=0;
        List<Integer> res=new ArrayList<Integer>();
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) return new int[0];
        while(idx1<nums1.length & idx2<nums2.length){
            if(nums1[idx1]==nums2[idx2]){
                res.add(nums1[idx1]);
                idx1++;
                ++idx2;
            }else if(nums1[idx1]<nums2[idx2]) ++idx1;
            else ++idx2;
        }
        int[] resa=new int[res.size()];
        for(int x: res){
            res[i]=x;
            ++i;
        }
        return resa;
    }
}
//what if nums1's size is small compared to nums2's size? use shorter as HashMap, break when map is empty. 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1=new HashMap<>();
        for(int x: nums1) map1.put(x, map1.getOrDefault(x, 0)+1);
        List<Integer> res=new LinkedList<Integer>();
        for(int y:nums2){
            if(map1.containsKey(y)){
                res.add(y);
                if(map1.get(y)==1) {
                    map1.remove(y);
                    if(map1.size()==0) break;
                }
                else map1.put(y, map1.get(y)-1);
            }
        }
        int[] resarray=new int[res.size()];
        int i=0;
        for(int z: res) resarray[i++]=z;
        return resarray;
    }
}
//
