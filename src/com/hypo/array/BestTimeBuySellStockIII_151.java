package com.hypo.array;

/**
 *  买卖股票3 [middle]
 *	假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格.
 *  设计一个算法来找到最大的利润。你最多可以完成两笔交易
 *  
 *  不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
 *  注意可以在同一天中,先卖出,再买入
 *  
 *  动态规划
 *  分析:以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i],
 *  和第i天之后进行一次交易的最大收益postProfit[i],
 *  最后遍历一遍，max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益
 */
public class BestTimeBuySellStockIII_151
{
	public int maxProfit(int[] prices)
	{
        if(prices.length < 2) return 0;
        
        int len = prices.length;
        
        int[] prevprofit = new int[len];//第i天之前的最大利润
        int[] postprofit = new int[len];//第i天之后的最大利润
        
        
        int lowbuy = prices[0];//最低买入价
        
        //第i天前
        for(int i = 1; i < len ; i++)
        {
            prevprofit[i] = Math.max(prices[i] - lowbuy , prevprofit[i-1]);
            
            lowbuy = Math.min(prices[i] , lowbuy);
        }
        
        int highsell = prices[len-1];//最高卖出价
        //第i天后
        for(int i = len - 2;  i >= 0; --i)
        {
            postprofit[i] = Math.max(highsell - prices[i] , postprofit[i+1]);
            
            highsell = Math.max(prices[i] , highsell);
        }

        
        int maxprofit = 0;
        for(int i = 0 ; i < len ; i++)
        {
            maxprofit = Math.max(prevprofit[i]+postprofit[i] , maxprofit);
        }
        
        return maxprofit;
	}
	
//	---------------------改进代码-----------------------------
    public int maxProfit2(int[] prices)
    {
        if(prices.length < 2) return 0;
        
        int len = prices.length;
        
        int maxprofit = 0;
        
        for(int i = 1 ; i < len ; i++)
        {
            maxprofit = Math.max(maxProfit(prices,0,i+1)+maxProfit(prices,i,len) , maxprofit);
        }
        
        return maxprofit;
    }
    
    private int maxProfit(int[] prices , int start , int end)
    {
        int lowbuy = prices[start];
        
        int maxprofit = 0;
        
        for(int i = start; i < end ; i++)
        {
            maxprofit = Math.max(prices[i] - lowbuy , maxprofit);
            
            lowbuy = Math.min(prices[i] , lowbuy);
        }
        return maxprofit;
    }
}
