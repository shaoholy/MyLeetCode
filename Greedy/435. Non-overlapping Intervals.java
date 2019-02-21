class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        int res = 1; 
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int lastEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < lastEnd) {
                continue;
            }
            res++;
            lastEnd = intervals[i].end;
        }
        
        return intervals.length - res;
    }
}