package com.hypo.array;

/**
 *  买卖股票1 [middle]
 *	假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格.
 *  如果你最多只允许完成一次交易(例如,一次买卖股票),也可以不交易
 *  
 */
public class BestTimeBuySellStock_149
{
    public int maxProfit(int[] prices) 
    {
        int maxprofit = 0;//最大利润
        
        int lowbuy = Integer.MAX_VALUE;//股票最低买入价格
        
        for(int i = 0 ; i < prices.length ; i++)
        {
            maxprofit = Math.max(prices[i] - lowbuy , maxprofit);

            lowbuy = Math.min(prices[i] , lowbuy);            
        }
        
        return maxprofit;
    }
}
