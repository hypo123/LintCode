package com.hypo.array;

/**
 *	买卖股票 [middle]
 *	假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。
 *  设计一个算法来找到最大的利润。你可以完成尽可能多的交易(多次买卖股票)。
 *  然而,你不能同时参与多个交易(你必须在再次购买前出售股票) 
 *
 *	分析:贪心法。从前向后遍历数组，只要当天的价格高于前一天的价格，就算入收益。
 */
public class BestTimeBuySellStockII_150
{
	public int maxProfit(int[] prices)
	{
		if(prices.length < 2) return 0;
		
		int maxprofit = 0;
		
		for(int i = 1 ; i < prices.length ; i++)
		{
			int diff = prices[i] - prices[i-1];
			
			if(diff > 0)
			{
				maxprofit += diff;
			}
		}
		
		return maxprofit;
	}
}
