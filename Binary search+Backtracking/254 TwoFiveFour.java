package Leetcode;

import java.awt.List;
import java.util.ArrayList;

public class TwoFiveFour {
	public static void main(String[] args) {
		TwoFiveFour TFF=new TwoFiveFour();
		System.out.println(TFF.factorsum(32));

	}
    public ArrayList<ArrayList<Integer>> factorsum(int target) {
    		
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        bt254(target,target, 2, new ArrayList<Integer>(), res);
        return res;
        
    }
    private void bt254(int target, int lefttarget, int start, ArrayList<Integer> cur, ArrayList<List<Integer>> res){

        for(int i=start; i<=(int)Math.pow(lefttarget, 0.5); i++) {
        		if(lefttarget%i==0) {
        			cur.add(i);
        			cur.add(lefttarget/i);
        			res.add(new ArrayList<Integer>(cur));
        			cur.remove(cur.size()-1);
        			bt254(target, lefttarget/i, i, cur, res);
        			cur.remove(cur.size()-1);
        		}
        }
    }
}

//if(lefttarget==1) {
//res.add(new ArrayList<Integer>(cur));
//return;
//}