package Leetcode2;

public class ThreeSixEight {

}
//1, use LinkedHashSet to store unused idx, linkedlist to try possible combinations
//time: o(n^2) space: O(n)
class Solution {
    int maxlen;
    LinkedHashSet<Integer> vis;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        
        if(nums==null || nums.length==0) return res;
        if(nums.length==1) {
            res.add(nums[0]);
            return res;
        }
        vis=new LinkedHashSet<Integer>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) 
            vis.add(i);
        while(vis.size()!=0){
            LinkedList<Integer> cur=new LinkedList<Integer>();
            int curp=-1;
            for(int x: vis){
                curp=x;
                break;
            }
            vis.remove(curp);
            cur.add(nums[curp]);
            int pre=1;
            for(int i=0; i<curp; i++){
                if(nums[curp]%nums[i]==0 && nums[i]%pre==0){
                    pre=nums[i];
                    cur.add(cur.size()-1, nums[i]);
                }
            }
            for(int i=curp+1; i<nums.length; i++){
                if(nums[i]%cur.getLast()==0){
                    cur.add(nums[i]);
                    if(vis.contains(i)) vis.remove(i);
                }
            }
            if(cur.size()>maxlen){
                res=new ArrayList<Integer>(cur);
                maxlen=cur.size();
            }
        }
        return res;
    }
}

//2, better dp solution. use parent[] to track route of max subset.
// O(n^2) time, o(n) space
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        
        if(nums==null || nums.length==0) return res;
        if(nums.length==1) {
            res.add(nums[0]);
            return res;
        }
        
        int max=0, idx=0;
        
        Arrays.sort(nums);
        int[] parent=new int[nums.length];
        int[] dp=new int[parent.length];
        Arrays.fill(parent, -1);
        dp[0]=1;
        for(int i=1; i<nums.length; i++){
            dp[i]=1;
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                idx=i;
            }
        }
        while(idx!=-1){
            res.add(nums[idx]);
            idx=parent[idx];
        }
        return res;
    }
}