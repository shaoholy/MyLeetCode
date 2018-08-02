package Leetcode2;

public class ThreeNineZero {

}
//brutal force iteration, o(n*logn) time. time exceed when int big 
public int lastRemaining(int n) {
    int count=0;
    boolean[] vis=new boolean[n];
    boolean other=false;
    int dir=1,start=0;
    while(count<n-1){
        if(!vis[start] && other==true){
            other=false;
        }else if(!vis[start] && other==false){
            other=true;
            vis[start]=true;
            count++;
            //System.out.println(start+1);
        }
        start=start+dir;
        if(start==-1 || start==n){
            start=start-dir;
            dir*=-1;
            other=false;
        }
    }
    int i=0;
    for(; i<n; i++) if(!vis[i]) break;
    return i+1;
}
//2, O(logN)
public int lastRemaining(int n) {
    if(n==1) return 1;
    int gap=1, all=n, dir=1,first=1;
    while(all>3){
        if(dir==1){
            first=first+gap;
        }else{
            first= all%2==0? first:first+gap;
        }
        gap*=2;
        all/=2;
        dir*=-1;
    }
    if(all==2){
        return dir==1? first+gap: first;
    }
    else return first+gap;
}