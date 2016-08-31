package com.hypo.dp;

/**
 *	硬币排成线	[middle] 
 *
 *	有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
	请判定 第一个玩家 是输还是赢？

	
	O(1) 时间复杂度且O(1) 存储
	
	分析:如果硬币的数目是3的倍数，那么不论第一个人每次拿的是1个还是2个,第二个人都可以保证使得每次两人拿的总数是3(第一个人拿一个,第二个人就拿两个;
	          第一个人拿两个，第二个人就拿一个).这样，到最后还剩三个的时候,第一个人输定了
 */
public class CoinsInLine_394
{
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) 
    {
    	return n % 3 != 0;
    }
}
