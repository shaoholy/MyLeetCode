package Leetcode;

public class NineThree {

}
//backtracking with string.substring
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        bt93(res, s, 0, new StringBuilder(),0);
        return res;
    }
    private void bt93(List<String> res, String s, int startidx,StringBuilder cur,int curlen){
        if((4-curlen)*3<s.length()-startidx) return;
        if(curlen==3){
            if(startidx>=s.length()) return;
            else if(s.charAt(startidx)=='0'){
                if(startidx==s.length()-1){
                    cur.append('0');
                    res.add(new String(cur));
                    cur.deleteCharAt(cur.length()-1);
                    return;
                }else return;
            }else{
                int lastint=Integer.parseInt(s.substring(startidx, s.length()));
                if(lastint>0 && lastint<=255){
                    int thislen=cur.length();
                    cur.append(lastint);
                    res.add(new String(cur));
                    cur.delete(thislen, cur.length());
                    return;
                }else return; 
            }
        }
        for(int i=startidx; i<s.length(); i++){
            int newint=Integer.parseInt(s.substring(startidx, i+1));
            int thislen2=cur.length();
            cur.append(newint).append('.');
            bt93(res,s,i+1,cur,curlen+1);
            cur.delete(thislen2, cur.length());
            if(s.charAt(startidx)=='0' || i<s.length()-1&&Integer.parseInt(s.substring(startidx, i+2))>255) break;
        }
    }
}
//2, faster with cha[] and int caozuo, instead of substring caozuo. 
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        bt93(res, s.toCharArray(), 0, new StringBuilder(), 0);
        return res;
    }
    private void bt93(List<String> res, char[] s, int startidx,StringBuilder cur,int curlen){
        if((4-curlen)*3<s.length-startidx) return;
        if(startidx==s.length && curlen<4 || curlen==4 && startidx!=s.length) return;
        if(startidx==s.length && curlen==4){
            res.add(cur.substring(0, cur.length()-1));
            return;
        }
        int thisnum=0;
        for(int i=startidx; i<s.length; i++){
            thisnum=thisnum*10+(s[i]-'0');
            if(thisnum>255) break;
            int curlen2=cur.length();
            cur.append(thisnum).append('.');
            bt93(res, s, i+1,cur, curlen+1);
            cur.delete(curlen2, cur.length());
            if(thisnum==0) break;
        }
    }
}

//3, direct 4-loop iteration
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}