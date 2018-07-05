package Leetcode;

public class NineSix {

}
//recur o(n) time. zhongdian: use hashmap to store calculated results. 
class Solution {
    public int numTrees(int n) {
        if(n<=0) return 1;
        HashMap<Integer, Integer> resmap=new HashMap<Integer, Integer>();
        resmap.put(0,1);
        resmap.put(1,1);
        return dfs96(n, resmap);
    }
    int dfs96(int n, HashMap<Integer, Integer> resmap){
        if(resmap.containsKey(n)) return resmap.get(n);
        int sum=0;
        for(int i=1; i<=n; i++){
            int leftsum=dfs96(i-1, resmap);
            int rightsum=dfs96(n-i, resmap);
            sum+=leftsum*rightsum;
        }
        resmap.put(n, sum);
        return sum;
    }
}


//better recursion method
public int numTrees(int n) {
    int [] G = new int[n+1];
    G[0] = G[1] = 1;
    
    for(int i=2; i<=n; ++i) {
	    	for(int j=1; j<=i; ++j) {
	    		G[i] += G[j-1] * G[i-j];
	    	}
    }

    return G[n];
}