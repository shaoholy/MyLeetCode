package Leetcode2;

public class OneEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//faster if not recursion used and condition added
List<List<Integer>> res;
public List<List<Integer>> fourSum(int[] nums, int target) {
    res=new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    List<Integer> cur=new ArrayList<Integer>();
    for(int i=0; i<nums.length-3; i++){
        if(i>0 && nums[i]==nums[i-1]) continue;
        cur.add(nums[i]);
        threeSum(nums, target-nums[i], i, cur);
        cur.remove(0);
    }
    return res;
}
private void threeSum(int[] nums, int target, int posi, List<Integer> curlist){
    for(int i=posi+1; i<nums.length-2; i++){
        if(i>posi+1 && nums[i]==nums[i-1]) continue;
        curlist.add(nums[i]);
        twoSum(nums, target-nums[i], i, curlist);
        curlist.remove(1);
    }
}
private void twoSum(int[] nums, int target, int posi, List<Integer> curlist){
    int left=posi+1, right=nums.length-1;
    while(left<right){
        if(nums[left]+nums[right]>target){
            right--;
        }else if(nums[left]+nums[right]<target){
            left++;
        }else{
            res.add(Arrays.asList(curlist.get(0), curlist.get(1), nums[left], nums[right]));
            do{
                left++;
            }while(left<right && nums[left]==nums[left-1]);
            while(left<right){
                right--;
                if(nums[right]!=nums[right+1]) break;
            }
        }
    }
}
