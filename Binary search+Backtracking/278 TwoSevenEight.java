package Leetcode;

public class TwoSevenEight {

}
//loop N(logN) time. zhongdian: use start+(end-start)/2 to avoid int overflow! 
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=1, end=n;
        while(start<end){
            int mid = start + (end-start) / 2;
            if(!isBadVersion(mid)){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }

}
//recursion: same as one
public int firstBadVersion(int n) {
    return dfs278(1, n);
}
private int dfs278(int start, int end){
    if(start==end) return start;
    int mid=start + (end-start) / 2;
    if(end-start==1) return isBadVersion(mid)? start:end;
    if(end-start==2) return isBadVersion(mid)? dfs278(start,mid):end;
    else return isBadVersion(mid)? dfs278(start, mid):dfs278(mid+1, end);
}