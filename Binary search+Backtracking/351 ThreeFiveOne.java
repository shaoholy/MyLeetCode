package Leetcode;

import java.util.ArrayList;

public class ThreeFiveOne {
	int sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeFiveOne TFO=new ThreeFiveOne();
		System.out.println(TFO.numberOfPatterns(2, 4));

	}
	
	public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];
        sum=0;
        for(int i=m; i<=n; i++) {
        		for(int j=1; j<10;j++) {
        			visited[j]=true;
        			bt351(new ArrayList<Integer>(), visited, j, i);
        			visited[j]=false;
        		}
        }
        return sum;
    }
	private void bt351(ArrayList<Integer> cur, boolean[] visited, int lastposi, int limit) {
		if(cur.size()==limit) {
			sum++;
			return;
		}
		for(int i=1; i<=9; i++) {
			if(!visited[i]) {
				if( ((lastposi==1 && i==7 || lastposi==7 && i==1 ) && !visited[4]) ||
					((lastposi==1 && i==3 || lastposi==3 && i==1 ) && !visited[2]) ||
					((lastposi==2 && i==8 || lastposi==8 && i==2 ) && !visited[5]) ||
					((lastposi==3 && i==9 || lastposi==9 && i==3 ) && !visited[6]) ||
					((lastposi==3 && i==7 || lastposi==7 && i==3 ) && !visited[5]) ||
					((lastposi==1 && i==9 || lastposi==9 && i==1 ) && !visited[5]) ||
					((lastposi==4 && i==6 || lastposi==6 && i==4 ) && !visited[5]) ||
					((lastposi==7 && i==9 || lastposi==9 && i==7 ) && !visited[8])     ) continue;
				else {
					visited[i]=true;
					cur.add(i);
					bt351(cur, visited, i, limit);
					cur.remove(cur.size()-1);
					visited[i]=false;
				}
			}
		}
		
	}

}
