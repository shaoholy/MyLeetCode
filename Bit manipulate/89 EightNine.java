package Leetcode;

public class EightNine {

}
//bit mani + iteration with stack
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(0);
        for(int i=0; i<n; i++){
            int len=res.size();
            for(int j=len-1; j>=0; j--){
                res.add(res.get(j)|1<<i);
            }
        }
        return res;
    }
}

//yuanli : https://leetcode.com/problems/gray-code/discuss/29881/An-accepted-three-line-solution-in-JAVA
public List<Integer> grayCode(int n) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
    return result;
}