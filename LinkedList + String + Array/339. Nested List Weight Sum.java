class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int level = 1; 
        return helper(nestedList, level); 
    }
    
    private int helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level; 
            } else {
                sum += helper(ni.getList(), level + 1); 
            }
        }
        return sum; 
    }
}