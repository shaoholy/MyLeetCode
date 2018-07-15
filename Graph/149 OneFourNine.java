package Leetcode;

public class OneFourNine {

}
//zhongdian: ratiao of (y-y)/(x-x) for GCD 用欧几里何算法算最大公约数！
//    private int findGCD(int a, int b) {
//if (b == 0) return a;
//return findGCD(b, a % b);
//}

class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        // double for loop to try all points. O(n^2)
        for (int i = 0; i < points.length; i++) {
            int max = 0, overlap = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = findGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                String key = x + "@" + y;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}