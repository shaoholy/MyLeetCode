package Leetcode2;

public class TwoSixFour {

}
//1, TreeSet, O(n*logN)
    public int nthUglyNumber(int n) {
        TreeSet<Integer> set=new TreeSet<Integer>();
        set.add(1);
        //Arrays.fill(dp,0);
        for(int i=1; i<n; i++){
            int cur=set.pollFirst();
            if(cur<=Integer.MAX_VALUE/2) set.add(cur*2);
            if(cur<=Integer.MAX_VALUE/3) set.add(cur*3);
            if(cur<=Integer.MAX_VALUE/5) set.add(cur*5);
        }
        return set.first();
    }
    
   //2, 3 idx
        public int nthUglyNumber(int n) {
            
            int[] res=new int[n];
            res[0]=1;
            int idx2=0, idx3=0, idx5=0;
            for(int i=1; i<n; i++){
                res[i]=Math.min(res[idx2]*2, Math.min(res[idx3]*3, res[idx5]*5));
                if(res[i]==res[idx2]*2) idx2++;
                if(res[i]==res[idx3]*3) idx3++;
                if(res[i]==res[idx5]*5) idx5++;
            }
            
            return res[n-1];
        }
