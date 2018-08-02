package Leetcode2;

public class TwoSixThree {

}
//1 normal iter
public boolean isUgly(int num) {
    if(num<=0) return false;
    while(num!=1){
        if(num%2==0){
            num/=2;
            continue;
        }else if(num%3==0){
            num/=3;
            continue;
        }else if(num%5==0){
            num/=5;
            continue;
        }else return false;
    }
    return true;
}
//2, simple and decent

public boolean isUgly(int num) {
        for(int i = 2; i<6 && num > 1; i++){
            while(num %i == 0){
                num = num /i;
            }
        }
        return num == 1;
    }