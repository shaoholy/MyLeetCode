class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length; 
        int cols = image[0].length;
        
        int uplimit = findLimit(image, 0, x, true, false); 
        int downlimit = findLimit(image, x, rows - 1, true, true); 
        int leftlimit = findLimit(image, 0, y,  false, false); 
        int rightlimit = findLimit(image, y, cols - 1, false, true); 
        System.out.println(uplimit);
        System.out.println(downlimit);
        System.out.println(leftlimit);
        System.out.println(rightlimit);
        return (downlimit - uplimit) * (rightlimit - leftlimit);
    }
    
    private int findLimit(char[][] image, int start, int end, boolean horizontal, boolean forward) {
        while (start <= end) {
            int mid = start + (end - start) / 2; 
            if (!forward && hasBlack(image, mid, horizontal) 
                || forward && !hasBlack(image, mid, horizontal)) {
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }
        return start; 
    }
    
    private boolean hasBlack(char[][] image, int num, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < image[0].length; i++) {
                if (image[num][i] == '1'){
                    return true; 
                }
            }
            return false; 
        } else {
            for (int i = 0; i < image.length; i++) {
                if (image[i][num] == '1') {
                    return true; 
                }
            }
            return false; 
        }
    }
}