package Leetcode2;

public class ThreeEightSix {

}
// o(n) solution
public List<Integer> lexicalOrder(int n) {
    List<Integer> res=new ArrayList<Integer>();
    if(n<1) return res;
    res.add(1);
    int pre=1;
    while(res.size()<n){
        if(pre*10<=n){
            pre*=10;
            res.add(pre);
        }else if(pre+1<=n && pre/10==(pre+1)/10){
            pre+=1;
            res.add(pre);
        }else if(pre/10!=(pre+1)/10){
            pre+=1;
            while(pre%10==0)
                pre/=10;
            res.add(pre);
        }else{
            pre=pre/10+1;
            while(pre%10==0)
                pre/=10;
            res.add(pre);
        }
    }
    return res;
}