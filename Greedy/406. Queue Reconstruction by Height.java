class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //step 1 : sort by 1) tall to short; 2) front to end
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int[][] res = new int[people.length][2];
        
        //always fill the front, shift and insert shorter ones
        for (int i = 0; i < people.length; i++) {
            //step2: shift all taller guys before cur one one back to make one slot for cur,
            // until pos - 1 left, meaning 
            int pos = people[i][1]; 
            for (int j = i; j > pos; j--) {
                res[j] = res[j - 1];
            }
            //step3: put cur person in the position
            res[pos] = people[i];
        }
        
        return res;
    }
}