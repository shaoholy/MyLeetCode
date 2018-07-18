package Leetcode2;

import java.util.Arrays;

public class ThreeTwoThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeTwoThree TTT=new ThreeTwoThree();
		int[][] edges= {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(TTT.countComponents(5, edges));
	}

    public int countComponents(int n, int[][] edges) {
         // initialize n isolated islands
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        //or initialize count as n, -- when root1!=root2; 
        for(int i=0;i<edges.length; i++) {
        		int root1=findSet(roots, edges[i][0]);
        		int root2=findSet(roots, edges[i][1]);
        		roots[root1]=root2;
        }
        int count=0;
        for(int x: roots) if(x==-1) count++;
        return count;
    }
    public int findSet(int[] roots,int i){
        if(roots[i]==-1) return i;
        roots[i] = findSet(roots,roots[i]);//path compression(optional)
        return roots[i];
    }


}
