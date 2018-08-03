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
///2, tree application, O(nlogN) time
ublic class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNode root, int val) {
        int thisCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;
                if(root.left == null) {
                    root.left = new TreeNode(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }
}

class TreeNode {
    TreeNode left; 
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}

//3, arraylist binary search, O(N logN N)
public List<Integer> countSmaller(int[] nums) {
    ArrayList<Integer> sort=new ArrayList<Integer>();
    LinkedList<Integer> res=new LinkedList<Integer>();
    if(nums==null || nums.length==0) return res;
    res.addFirst(0);
    if(nums.length==1) return res;
    sort.add(nums[nums.length-1]);
    for(int i=nums.length-2; i>=0; i--){
        int cur=nums[i];
        int left=0, right=sort.size();
        while(left<right){
            int mid=left+(right-left)/2;
            if(sort.get(mid)<cur){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        sort.add(left, cur);
        res.addFirst(left);
    }
    return res;
}