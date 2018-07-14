package Leetcode;

public class ThreeOneZero {

}
//1, no good. HashMap to store point and List of immediate neighbors. then find the deepest leaf of each
//bfs
class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      TreeMap<Integer, HashSet<Integer>> tmap=new TreeMap<>();
      //treemap, to store direct neighbors of each node
      for(int i=0; i<n; i++){
          tmap.put(i, new HashSet<Integer>());
          for(int j=0; j<edges.length; j++){
              if(edges[j][0]==i) tmap.get(i).add(edges[j][1]);
              if(edges[j][1]==i) tmap.get(i).add(edges[j][0]);
          }
      }
      //bfs each node to the end, record longest path
      int min=Integer.MAX_VALUE;
      int[] minarray=new int[n];
      for(int i=0; i<n; i++){
          HashSet<Integer> vis=new HashSet<Integer>();
          for(int j=0; j<n; j++)  vis.add(j);
          LinkedList<Integer> que=new LinkedList<Integer>();
          que.add(i);
          int len=0;
          while(que.size()!=0){
              len++;
              if(len>min) break;
              int qsize=que.size();
              for(int k=0; k<qsize; k++){
                  int cur=que.poll();
                  vis.remove(cur);
                  Set<Integer> curlist=tmap.get(cur);
                  for(int x: curlist){
                      if(vis.contains(x)) que.add(x);
                  }
               }
           }
          minarray[i]=len;
          min=Math.min(len, min);
      }
      List<Integer> reslist=new ArrayList<Integer>();
      for(int i=0; i<minarray.length; i++) if(min==minarray[i]) reslist.add(i);
      return reslist;
  }
}

//longest path
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> que=new LinkedList<Integer>(); 
        HashSet<Integer> vis=new HashSet<Integer>();
        for(int i=0; i<n; i++) vis.add(i);
        que.add(0);
        int finalint=-1;
        while(que.size()!=0){
            int len=que.size();
            for(int i=0; i<len; i++){
                int cur=que.poll();
                vis.remove(cur);
                for(int j=0; j<edges.length; j++){
                    if(edges[j][0]==cur) if(vis.contains(edges[j][1])) que.add(edges[j][1]);
                    if(edges[j][1]==cur) if(vis.contains(edges[j][0])) que.add(edges[j][0]);
                }
                if(que.size()==0) finalint=cur;
            }
        }
        
        int[] pre=new int[n];
        boolean[] visi=new boolean[n];
        que.add(finalint);
        pre[finalint]=-1;
        while(que.size()!=0){
            int len=que.size();
            for(int i=0; i<len; i++){
                int cur2=que.poll();
                visi[cur2]=true;
                for(int j=0; j<edges.length; j++){
                    if(edges[j][0]==cur2) {
                        if(!visi[edges[j][1]]) {
                            que.add(edges[j][1]);
                            pre[edges[j][1]]=cur2;
                            }
                        }
                    if(edges[j][1]==cur2) {
                        if(!visi[edges[j][0]]) {
                            que.add(edges[j][0]);
                            pre[edges[j][0]]=cur2;
                            }
                        }
                }
                if(que.size()==0) finalint=cur2;
            }
        }
        
        List<Integer> finallist=new ArrayList<Integer>();
        while(finalint!=-1){
            finallist.add(finalint);
            finalint=pre[finalint];
        }
        
        if (finallist.size() % 2 == 1) return Arrays.asList(finallist.get(finallist.size() / 2));
        else return Arrays.asList(finallist.get(finallist.size() / 2 - 1), finallist.get(finallist.size() / 2));
    }
}

//3, dp zhongdian: use height1, to store height, and use height2, to store height from other branch
class Solution {
  List<Integer>[] alledge;
  int n; 
  int[] height1;//the height of the node
  int[] height2;//the height of the node from other under-route
  int[] dp;
  
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (n <= 0) return new ArrayList<Integer>();
      if (n == 1) return Arrays.asList(0);
      
      this.n=n;
      alledge=new ArrayList[n];
      for(int i=0; i<n; i++) alledge[i]=new ArrayList<Integer>();     
      for(int[] pair: edges){
          int u=pair[0];
          int v=pair[1];
          alledge[u].add(v);
          alledge[v].add(u);
      }
      
      dp=new int[n];
      height1 = new int[n];
      height2 = new int[n];
      
      dfs(0,-1);
      dfs(0,-1,0);
      
      int min=dp[0];
      for(int i=1; i<dp.length; i++) if(dp[i]<min) min=dp[i];
      List<Integer> ans = new ArrayList<>();
      for (int i = 0; i < n; i++)
          if (dp[i] == min) ans.add(i);
      return ans;
      
  }
  private void dfs(int u, int parent) {
      height1[u] = height2[u] = -Integer.MIN_VALUE / 10;
      for (int v : alledge[u])
          if (v != parent) {
              dfs(v, u);
              int tmp = height1[v] + 1;
              if (tmp > height1[u]) {
                  height2[u] = height1[u];
                  height1[u] = tmp;
              } else if (tmp > height2[u]) {
                  height2[u] = tmp;
              }
          }
      height1[u] = Math.max(height1[u], 0); // in case u is a leaf.
  }
  
  private void dfs(int u, int parent, int acc) {
      dp[u]=Math.max(height1[u], acc);
      for (int v : alledge[u]){
          if(v!=parent){
              int newAcc=Math.max(acc+1, (height1[v]+1==height1[u]?height2[u]:height1[u]) + 1);
              dfs(v, u, newAcc);
          }
      }
  }
}