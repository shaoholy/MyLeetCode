package Leetcode;

public class TwoSixZero {

}
//zhongdian:get a as the num1^num2,  use a & (-a) as 最后一个位数区别 of num1 and num2
//然后，让跟这个有区别的数一直^，得出一个结果res1，然后  a^res1=res2
public int[] singleNumber(int[] nums) {
	int a = 0, b = 0;
	for (int n : nums) a ^= n;
	for (int n : nums)  if ((n & a & -a) > 0) b ^= n;
	return new int[] {a^b, b};
}