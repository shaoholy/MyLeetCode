package Leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private int[] islands;
		private int getroot(int i) {
			while(islands[i]!=i) {
				islands[i]=islands[islands[i]];
				i=islands[i];
			}
			return i;
		}
    private int[] yo = {-1, 1, 0, 0};
    private int[] xo = {0, 0, -1, 1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        islands = new int[m*n];
        Arrays.fill(islands, -1);
        int island = 0;
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<positions.length; i++) {
            int y =positions[i][0];
            int x = positions[i][1];
            int id=y*n+x;
            islands[id] = id;//关键：root上id和idx是相等的
            island ++;
            for(int j=0; j<4; j++) {
                int ny = y+yo[j];
                int nx = x+xo[j];
                int nid=ny*n+nx;
                if (ny>=0 && ny<m && nx>=0 && nx<n && islands[nid] != -1) {
                    int root = getroot(nid);
                    if (root != id) {
                        islands[root] = id;
                        island --;//只有找到root后，root不等于当前点，才减1.
                    }
                }
            }
            nums.add(island);
        }
        return nums;
    }
}


public class ThreeZeroFive {
	final int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	int[] islands;
	int count; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TwoSixOne TSO=new TwoSixOne();
//		int[][] edges= {{0, 1}, {0, 2}, {0, 3}, {1, 3}};
//		System.out.println(TSO.validTree(5, edges));

	}
	public ArrayList<Integer> numIslands2(int m, int n, int[][] positions) {
		count=0;
		ArrayList<Integer> res = new ArrayList<>();
		if(m < 0 || n < 0 || positions == null || positions.length==0) {
		    return res;
			}

		for(int i=0; i<positions.length; i++) {
				
		}
		return res;
	}
	private int getroot(int[] islands, int i) {
		if(islands[i]==-1) re
	}

}
//public ArrayList<Integer> numIslands2(int m, int n, int[][] positions) {
//	count=0;
//ArrayList<Integer> res = new ArrayList<>();
//if(m < 0 || n < 0 || positions == null || positions.length==0) {
//    return res;
//}
//int[][][] roots=new int[m][n][2]; 
//for(int i=0; i<m; i++) {
//		for(int j=0; j<n; j++) {
//			roots[i][j][0]=Integer.MAX_VALUE;
//			roots[i][j][1]=Integer.MAX_VALUE;
//		}
//}
//for(int i=0; i<positions.length; i++) {
//		int[] x=dfsroot(roots, positions[i][0], positions[i][1]);
//		if(x[0]==-1) count++;
//		roots[positions[i][0]][positions[i][1]][0]=x[0];
//		roots[positions[i][0]][positions[i][1]][1]=x[1];
//		int temp=count;
//		res.add(temp);
//}
//
//return res;
//}
//
//private int[] dfsroot(int[][][] roots, int ax, int ay) {
//	
//	int[] res=new int[2];
//	int[] newres;
//	Arrays.fill(res, Integer.MIN_VALUE);
//	for(int i=0; i<4; i++) {
//		if(ax+dir[i][0]>=0 && ax+dir[i][0]<roots.length && ay+dir[i][1]>=0 &&  ay+dir[i][1]<roots[0].length) {
//			newres = getroot(roots, ax, ay, ax+dir[i][0], ay+dir[i][1]);
//			if(res[0]==-1 || res[0]==Integer.MIN_VALUE) {
//				res[0]=newres[0];
//				res[1]=newres[1];
//			}else if(newres[0]!=res[0] && newres[1]!=res[1]) {
//				count--;
//				dfsfresh(roots,  ax+dir[i][0],  ay+dir[i][1], res[0],  res[1]);
//			}
//		}
//	}
//	return res;
//}
//
//private int[] getroot(int[][][] roots, int ax,int ay, int bx, int by){
//	if(roots[bx][by][0]==Integer.MAX_VALUE && roots[bx][by][1]==Integer.MAX_VALUE) {
//		roots[ax][ay][0]=-1;
//		roots[ax][ay][1]=-1;
//	}
//	else if(roots[bx][by][0]==-1 && roots[bx][by][1]==-1){
//		roots[ax][ay][0]=bx;
//		roots[ax][ay][1]=by;
//	}else {
//		roots[ax][ay][0]=roots[bx][by][0];
//		roots[ax][ay][1]=roots[bx][by][1];
//	}
//	return roots[ax][ay];
//}
//private void dfsfresh(int[][][] roots, int ax, int ay, int targetx, int targety) {
//	roots[ax][ay][0]=targetx;
//	roots[ax][ay][1]=targety;
//	for(int i=0; i<4; i++) {
//		if(ax+dir[i][0]>=0 && ax+dir[i][0]<roots.length && ay+dir[i][1]>=0 &&  ay+dir[i][1]<roots[0].length) {
//			if(roots[ax+dir[i][0]][ay+dir[i][1]][0]!=Integer.MAX_VALUE && roots[ax+dir[i][0]][ay+dir[i][1]][0]!=targetx
//					&& roots[ax+dir[i][0]][ay+dir[i][1]][1]!=targety) {
//				dfsfresh(roots, ax+dir[i][0], ay+dir[i][1], targetx, targety);
//			}
//			
//		}
//	}
//}