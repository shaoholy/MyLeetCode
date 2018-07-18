package Leetcode2;

import java.util.Arrays;
import java.util.LinkedList;

public class TwoSixOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSixOne TSO=new TwoSixOne();
		int[][] edges= {{0, 1}, {0, 2}, {0, 3}, {1, 3}};
		System.out.println(TSO.validTree(5, edges));

	}
	private int findroot(int[] roots, int a) {
		if(roots[a]==-1) return a;
		return findroot(roots, roots[a]);
	}
	public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
		
		//method2: union find; 
		if(n-edges.length!=1) return false;
		int[] roots=new int[n];
		Arrays.fill(roots, -1);
		for(int i=0; i<edges.length; i++) {
			int root1=findroot(roots, edges[i][0]);
			int root2=findroot(roots, edges[i][1]);
			if(root1==root2) return false;
			roots[root1]=root2;
			
		}
		return true;
//method1: bfs with linkedlist and boolean check
//		if(n-edges.length!=1) return false;
//		boolean[] visn=new boolean[n];
//		visn[0]=true;
//		boolean[] vise=new boolean[edges.length];
//		LinkedList<Integer> q=new LinkedList<Integer>();
//		q.add(0);
//		while(q.size()!=0) {
//			int len=q.size();
//			for(int i=0; i<len; i++) {
//				int cur=q.poll();
//				visn[cur]=true;
//				for(int j=0; j<edges.length; j++) {
//					if(!vise[j]) {
//						if(cur==edges[j][0] || cur==edges[j][1]) {
//							q.add(cur==edges[j][0]? edges[j][1]:edges[j][0]);
//							if(visn[cur==edges[j][0]? edges[j][1]:edges[j][0]]) return false;
//							vise[j]=true;
//						}
//					}
//				}
//			}
//		}
//		for(boolean vn: visn) if(!vn) return false;
//		
//		return true;
    }
	

}
