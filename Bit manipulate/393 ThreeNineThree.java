package Leetcode;

public class ThreeNineThree {

}
//not elegant version o(n)
class Solution {
    public boolean validUtf8(int[] data) {
        for(int i=0; i<data.length; i++){
            if((data[i]&(1<<7))==0) continue;
            else if((data[i]&(1<<7))==1<<7 && (data[i]&(1<<6))==1<<6 && (data[i]&(1<<5))==0){
                int next1=i+1;
                if(next1>=data.length || (data[next1]&(1<<7))!=1<<7 || (data[next1]&(1<<6))!=0) return false;
                i+=1;
            }else if((data[i]&(1<<7))==1<<7 && (data[i]&(1<<6))==1<<6 && (data[i]&(1<<5))==1<<5  && (data[i]&(1<<4))==0){
                int next1=i+1;
                if(next1>=data.length || (data[next1]&(1<<7))!=1<<7 || (data[next1]&(1<<6))!=0) return false;
                int next2=i+2;
                if(next2>=data.length || (data[next2]&(1<<7))!=1<<7 || (data[next2]&(1<<6))!=0) return false;
                i+=2;
            }else if((data[i]&(1<<7))==1<<7 && (data[i]&(1<<6))==1<<6 && (data[i]&(1<<5))==1<<5  && (data[i]&(1<<4))==1<<4 && (data[i]&(1<<3))==0){
                int next1=i+1;
                if(next1>=data.length || (data[next1]&(1<<7))!=1<<7 || (data[next1]&(1<<6))!=0) return false;
                int next2=i+2;
                if(next2>=data.length || (data[next2]&(1<<7))!=1<<7 || (data[next2]&(1<<6))!=0) return false;
                int next3=i+3;
                if(next3>=data.length || (data[next3]&(1<<7))!=1<<7 || (data[next3]&(1<<6))!=0) return false;
                i+=3;
            }else return false;
        }
        return true;
    }
}
//simplified
class Solution {
    public boolean validUtf8(int[] data) {
        for(int i=0; i<data.length; i++){
            int follower=countbit(data[i])-1;
            if(follower==0 || follower>=4) return false;
            if(follower>=1 && follower<=3){
                for(int j=1;j<=follower; j++){
                    if(i+j==data.length || countbit(data[i+j])!=1) return false;
                }
                i+=follower;
            }
        }
        return true;
    }
    private int countbit(int n){
        int res=0; 
        for(int idx=7; idx>0; idx--){
            if((n>>idx&1)==0) break;
            res++;
        }
        return res;
    }
}