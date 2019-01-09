class Solution {
    int islands = 0; 
    Map<Integer, Integer> parentMap = new HashMap<>(); 
    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]); 
        }
        return stones.length - islands; 
    }
    
    private int find(int x) {
        if (!parentMap.containsKey(x)) {
            parentMap.put(x, x); 
            islands++; 
        }//same result if (parentMap.putIfAbsent(x, x) == null) islands++;
        if (x != parentMap.get(x)) {
            parentMap.put(x, find(parentMap.get(x)));
        }
        return parentMap.get(x); 
    }
    
    private void union(int x, int y) {
        x = find(x); 
        y = find(y); 
        if (x == y) {
            return; 
        } else {
            parentMap.put(x, y); 
            islands--;
        }
    }
}