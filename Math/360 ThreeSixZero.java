package Leetcode2;

public class ThreeSixZero {

}
//
class solution{
	public int[] sortTransformedArray(int[] input, int a, int b, int c) {
		int[] res=new int[input.length];
		if(a==0) {
			for(int i=0; i<input.length; i++) {
				res[i]=input[i]*b+c;
			}
			if(b<0) reverse(res);
			return res; 
		}else {
			
			double mid=b/a*(-0.5);
			
			int left=0,right=input.length-1;
			while(left+1<input.length && input[left+1]<mid) left++;
			while(right-1>=0 && input[right-1]>=mid) right--;	
			if(left==right) {
				if (right<mid) right++;
				else if(left>=mid) left--;
			}
			
			
			for(int i=0; i<res.length; i++) {
				if(left<0) {
					res[i]=input[right]*input[right]*a+input[right]*b+c;
					right++;
				}else if(right>=input.length) {
					res[i]=input[left]*input[left]*a+input[left]*b+c;
					left--;
				}else {
					if((double)input[right]-mid<mid-(double)input[left]) {
						res[i]=input[right]*input[right]*a+input[right]*b+c;
						right++;
					}else {
						res[i]=input[left]*input[left]*a+input[left]*b+c;
						left--;
					}
				}
			}
			
			if(a<0) reverse(res);
			return res;
		}
	}
	private void reverse(int[] input) {
		int left=0, right=input.length-1;
		while(left<right) {
			int temp=input[left];
			input[left++]=input[right];
			input[right--]=temp;
		}
	}
}
