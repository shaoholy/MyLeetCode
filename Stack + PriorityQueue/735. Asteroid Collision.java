class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids; 
        }
        
        Deque<Integer> stack = new ArrayDeque<>(); 
        int idx = 0; 
        
        while (idx < asteroids.length) {
            int cur = asteroids[idx]; 
            if (stack.isEmpty()) {
                stack.offerFirst(cur); 
            } else {
                int last = stack.peekFirst();
                if (cur * last > 0 || (cur > 0 && last < 0)) {
                    stack.offerFirst(cur); 
                } else {
                    if (cur + last > 0) {

                    } else if (cur + last < 0) {
                        stack.pollFirst(); 
                        idx--; 
                    } else {
                        stack.pollFirst(); 
                    }
                }
            }
            idx++; 
        }
        int[] res = new int[stack.size()]; 
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast(); 
        }
        return res; 
    }
}