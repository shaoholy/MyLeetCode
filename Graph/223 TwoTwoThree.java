package Leetcode;

public class TwoTwoThree {

}
//Arrays.sort  o(1)
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(E>=C || A>=G || B>=H || F>=D) return (C-A)*(D-B)+(G-E)*(H-F);
        else{
            int[] h={A,C,E,G};
            int[] v={B,D,F,H};
            Arrays.sort(h);
            Arrays.sort(v);
            return (C-A)*(D-B)+(G-E)*(H-F)-(h[2]-h[1])*(v[2]-v[1]);
        }
    }
}

//shorten version
int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int left = max(A,E), right = max(min(C,G), left);
    int bottom = max(B,F), top = max(min(D,H), bottom);
    return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
}