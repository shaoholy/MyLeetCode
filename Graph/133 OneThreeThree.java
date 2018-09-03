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
          if(node == null){
              return null; 
          }
          HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
          Deque<UndirectedGraphNode> deq = new ArrayDeque<UndirectedGraphNode>();
          deq.offer(node); 
          UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
          
          oldToNew.put(node, newRoot);
          while(!deq.isEmpty()){
              UndirectedGraphNode oldCur = deq.pollFirst(); 
              UndirectedGraphNode newCur = oldToNew.get(oldCur); 
              for(UndirectedGraphNode neighbor : oldCur.neighbors){
                  if(oldToNew.containsKey(neighbor)){
                      newCur.neighbors.add(oldToNew.get(neighbor));
                  }else{
                      UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                      newCur.neighbors.add(newNeighbor);
                      oldToNew.put(neighbor, newNeighbor);
                      deq.offerLast(neighbor);
                  }
              }
          }
          return newRoot;
      }
  }
