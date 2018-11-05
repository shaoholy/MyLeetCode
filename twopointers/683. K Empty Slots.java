class Solution {
    public int kEmptySlots(int[] flowers, int k) {
//         TreeSet<Integer> interval = new TreeSet<>(); 
//         int left = 0, right = 1; 
//         for (int i = 0; i < k; i++) {
//             interval.add(flowers[i]); 
//         }
//         while (Math.max(flowers[left], flowers[right]) > interval.first() && right < flowers.length) {
//             interval.remove(flowers[++left]); 
//             if (right + 1 < flowers.length) {
//                 interval.add(flowers[++right]); 
//             }
            
//         }
//         return Math.max(flowers[left], flowers[right]);
        int[] positions = new int[flowers.length]; 
        for (int i = 0; i < flowers.length; i++) {
            positions[flowers[i] - 1] = i + 1; //meaning the flower-posi blooms at day val
        }
        int left = 0, right = k + 1, res = Integer.MAX_VALUE; 
        for (int i = 1; right < flowers.length; i++) {
            if (positions[i] > positions[left] && positions[i] >positions[right]) {
                continue; 
            }
            if (i == right) {
                res = Math.min(res, Math.max(positions[left], positions[right])); 
            }
            left = i; 
            right = i + k + 1; 
        }
        return res == Integer.MAX_VALUE ? -1 : res; 
    }
}