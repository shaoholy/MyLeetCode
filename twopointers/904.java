class Solution {
    public int totalFruit(int[] tree) {
        int cur = 0, res = 0, count_b = 0, b = 0, a = 0; 
        for (int c: tree) {
            cur = (c == a || c == b)? cur + 1 : count_b + 1; 
            count_b = (c == b)? count_b + 1 : 1;
            if (c != b) {
                a = b; 
                b = c; 
            }
            res = Math.max(cur, res);
        }
        
        return res;  
    }
}


class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        if (tree.length < 3) {
            return tree.length; 
        }
        
        //define 2 pointer A, B
        
        int pointerA = 0, pointerB = 0;
        int max = 1; 
        Set<Integer> fruitSet = new HashSet<>(); 
        Map<Integer, Integer> map = new HashMap<>(); 
        
        while (pointerA < tree.length) {
            while (fruitSet.size() < 3 && pointerA < tree.length) {
                int cur = tree[pointerA]; 
                fruitSet.add(cur); 
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                pointerA++; 
            }
            max = Math.max(pointerA - pointerB - 1, max);
            //System.out.println(max + " max " + pointerA + " A " + pointerB + " B");
            while (fruitSet.size() == 3 && pointerB < pointerA) {
                int cur = tree[pointerB]; 
                if (map.get(cur) > 1) {
                    map.put(cur, map.get(cur) - 1); 
                } else {
                    fruitSet.remove(cur); 
                    map.remove(cur); 
                }
                pointerB++;
            }
        }
        max = Math.max(pointerA - pointerB, max);
        return max;  
    }
}