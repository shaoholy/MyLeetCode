package Leetcode;

public class TwoEightTwo {

}
// Backtracking without considering int overflow
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<String>();
        if(num==null || num.length()==0) return res;
        bt282(res, new StringBuilder(), num, target, 0);
        // System.out.println(getint("32"));
        return res;
    }
    private void bt282(List<String> res, StringBuilder cur, String num, int target, int posi){
        if(posi==num.length()){
            if(getint(new String(cur))==target){
                res.add(new String(cur));
                return; 
            }else return; 
        }
        if(num.charAt(posi)!='0' || posi==num.length()-1){
            int curlen=cur.length();
            //System.out.println(num.substring(posi, num.length()));
            cur.append(num.substring(posi, num.length()));
            bt282(res, cur, num, target, num.length());
            cur.delete(curlen, cur.length());
        }
        for(int i=posi; i<num.length()-1; i++){
            int prevlen=cur.length();
            char[] addi={'+','-','*'};
            for(int j=0; j<3; j++){
                cur.append(num.substring(posi,i+1)).append(addi[j]);
                bt282(res, cur, num, target, i+1);
                cur.delete(prevlen, cur.length());
            }
            if(num.charAt(posi)=='0') break;
        }
    }
    private int getint(String s){
        LinkedList<Integer> intstack=new LinkedList<Integer>();
        LinkedList<Character> charstack=new LinkedList<Character>();
        for(int i=0; i<s.length(); i++){
            char x=s.charAt(i);
            if(x=='+' || x=='-') 
                charstack.add(x);
            else if(x=='*'){
                int f1=intstack.pollLast();
                i++;
                int f2=s.charAt(i)-'0';
                
                while(i+1<s.length() && s.charAt(i+1)!='+' && s.charAt(i+1)!='-'&& s.charAt(i+1)!='*'){
                    f2=f2*10+(s.charAt(i+1)-'0');
                    i++;
                }
                intstack.add(f1*f2);
                        
            }else{
                int curint=x-'0';
                while(i+1<s.length() && s.charAt(i+1)!='+' && s.charAt(i+1)!='-'&& s.charAt(i+1)!='*'){
                    curint=curint*10+(s.charAt(i+1)-'0');
                    i++;
                }
                intstack.add(curint);
            }
        }
        int res=intstack.poll();
        while(intstack.size()!=0){
            int nextint=intstack.poll();
            if(charstack.poll()=='+') res+=nextint;
            else res-=nextint;
        }
        return res;
     }
}

//improve: 1, use long instead of int to avoid int overflow. 2, record prev val to directly get current value. 3, use string to reduce stringbuilder caozuo
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<String>();
        if(num==null || num.length()==0) return res;
        bt282(res, new String(), num, target, 0,0,0);
        return res;
    }
    private void bt282(List<String> res, String cur, String num, int target, int posi, long val, long prev){
        if(posi==num.length()){
            if(target==val)
                res.add(new String(cur));
             return; 
        }

        for(int i=posi; i<num.length(); i++){
            if(i!=posi && num.charAt(posi)=='0') break;
            long curval=Long.parseLong(num.substring(posi,i+1));
            if(posi==0)
                bt282(res, cur+curval, num, target, i+1, curval,curval);
            else{
                bt282(res, cur+"+"+curval, num, target, i+1, val+curval, curval);
                bt282(res, cur+"-"+curval, num, target, i+1, val-curval, -curval);
                bt282(res, cur+"*"+curval, num, target, i+1, val-prev+prev*curval, prev*curval);//record prev val to directly get current value
            }
        }
    }
}