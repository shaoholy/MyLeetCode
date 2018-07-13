package Leetcode;

public class OneThreeThree {

}
//dfs
public class Solution {
    HashMap<UndirectedGraphNode,UndirectedGraphNode> nodemap=new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        if(nodemap.containsKey(node)) return nodemap.get(node);
        
        UndirectedGraphNode res=new UndirectedGraphNode(node.label);
        res.neighbors=new ArrayList<UndirectedGraphNode>();
        
        for(UndirectedGraphNode x: node.neighbors){
            if(x==node) res.neighbors.add(res);
            else {
                // UndirectedGraphNode newnode=cloneGraph(x);
                res.neighbors.add(cloneGraph(x));
                // nodemap.put(x, newnode)
            }
        }
        nodemap.put(node, res);
        return res;
    }
}
//bfs
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if(node==null) return null;
      HashMap<UndirectedGraphNode,UndirectedGraphNode> nodemap=new HashMap<>();
      UndirectedGraphNode res=new UndirectedGraphNode(node.label);
      LinkedList<UndirectedGraphNode> oldstack=new LinkedList<>();
      LinkedList<UndirectedGraphNode> newstack=new LinkedList<>();
      oldstack.add(node);
      newstack.add(res);
      nodemap.put(node, res);
      while(oldstack.size()!=0){
          int len=oldstack.size();
          for(int i=0; i<len; i++){
              UndirectedGraphNode curnode=oldstack.poll();
              UndirectedGraphNode lastnode=newstack.poll();
              for(UndirectedGraphNode x: curnode.neighbors){
                  if(nodemap.containsKey(x)) {
                      lastnode.neighbors.add(nodemap.get(x));
                      continue;
                  }
                  oldstack.add(x);
                  UndirectedGraphNode newnode=new UndirectedGraphNode(x.label);
                  lastnode.neighbors.add(newnode); 
                  newstack.add(newnode);
                  nodemap.put(x, newnode);
              }
          }
      }
      return res;
  }
}