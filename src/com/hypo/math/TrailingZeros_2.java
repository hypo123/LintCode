package com.hypo.math;

/**
 * 	尾部的零 [easy]
 * 	设计一个算法，计算出n阶乘中尾部零的个数
 *	
 *  样例
	11! = 39916800，因此应该返回 2

	挑战 
	O(logN)的时间复杂度
	
	分析:10是2和5的乘积, n!中我们需要知道有多少个2和5,2的数量和5的数量中较少的一个便是0的数量;
	而2的数量总是大于5的数量,所以的0的数量由5的个数决定.
	
	如:1024!
	= 2*3*...*5...*10...*15...*20...*25...*30.....*125.......*1020...
	
	其中              5 , 10 , 15  ,20 各提供了一个5;
	       25提供了2个5;
	       125提供了3个5;
	       625提供了4个5;
	       
	count = 0;
	left = 0;
	
	1024 / 5 = 204;  left = 204; //一共有204个5的倍数
	204 / 5 = 40 ;   left = 244; //204个倍数中有40个倍数对25求余为0;
	40 / 5 = 8 ;     left = 252; //40个倍数中有8个倍数对125求余为0;
	8 / 5 = 1 ;      left = 253; //8个倍数中有1个倍数对625求余为0;
	1 / 5 = 0;       left = 253;
 */
public class TrailingZeros_2
{
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) 
    {
    	long countZero = 0;
    	
    	long left = n / 5;
    	
    	while(left != 0)
    	{
    		countZero += left;
    		
    		left /= 5;
    	}
    	
    	return countZero;
    }	
}
