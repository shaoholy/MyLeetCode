package Leetcode;

public class ThreeNineNine {

}
//DFS, considering multi/divi with different if.
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res=new double[queries.length];
      for(int i=0; i<res.length; i++){
        if(queries[i][0].equals(queries[i][1])){
            for(int j=0; j<equations.length; j++){
                if(equations[j][0].equals(queries[i][0]) || equations[j][1].equals(queries[i][0]))
                    res[i]=1.0;
            }
            if(res[i]!=1.0) res[i]=-1.0;
        }
        else{ 
        double res1=dfs(equations,values,new boolean[values.length],queries[i][0],queries[i][1],0,1);
        double res2=dfs(equations,values,new boolean[values.length],queries[i][0],queries[i][1],1,1);
        res[i]=Math.max(res1, res2);}
      }
        return res;
    }

    private double dfs(String[][] equations,double[] values,
                     boolean[] visited, String target, String fina, int posi, double cur){
        if(target.equals(fina)){
            return posi==0? cur:1/cur;
        }
        for(int i=0; i<equations.length; i++){
            if(!visited[i] && target.equals(equations[i][posi])){
                visited[i]=true;
                double nres=dfs(equations,values,visited,equations[i][posi^1],fina,posi,cur*values[i]);
                if(nres!=-1.0) return nres;
                visited[i]=false;
            }
            if(!visited[i] && target.equals(equations[i][posi^1])){
                visited[i]=true;
                double nres=dfs(equations,values,visited,equations[i][posi],fina,posi^1,1/cur*values[i]);
                if(nres!=-1.0) return nres;
                visited[i]=false;
            }
        }
        return -1.0;
    }
}

//2. use all string as vertice value & 1/value as the edge value. then use dfs to find each a->b, multi up the edge values
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      Map<String, List<Edge>> map = new HashMap();
      int i = 0;
      for(String[] e: equations){
        List<Edge> edges0 = map.getOrDefault(e[0], new ArrayList());  
        List<Edge> edges1 = map.getOrDefault(e[1], new ArrayList());   
        Edge e0 = new Edge(e[1], values[i]);
        Edge e1 = new Edge(e[0], 1 / values[i]);
        edges0.add(e0);
        edges1.add(e1);
        map.put(e[0], edges0);
        map.put(e[1], edges1);
        i++;
      }
      
      double[] res = new double[queries.length];
      for(i = 0; i < queries.length; i++){
        String s = queries[i][0];
        String t = queries[i][1];
        Set<String> visited = new HashSet();
        visited.add(s);
        res[i] = helper(map, visited, s, t, 1.0);
      } 
      return res; 
    }
    
    double helper(Map<String, List<Edge>> map, Set<String> visited, String s, String t, double dis){
       
       if(!map.containsKey(s)){
         return -1.0;
       }
       if(s.equals(t)){
         return dis;
       }
       
       List<Edge> edges = map.get(s);
       for(Edge e: edges){
         if(!visited.contains(e.to)){
           visited.add(e.to);
           double res = helper(map, visited, e.to, t, dis * e.weight);
           if(res != -1.0){
             return res;
           }
         }
       }
       return -1.0;
    }
    
    class Edge{
      double weight;
      String to;
      Edge(String t, double w){
        weight = w;
        to = t;  
      }  
    }
}