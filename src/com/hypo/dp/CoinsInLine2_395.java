package com.hypo.dp;

/**
 *	硬币排成线2	[middle] 
 *
 *	有 n 个不同价值的硬币排成一条线。
 *	两个参赛者轮流从左边依次拿走 1 或 2 个硬币，直到没有硬币为止。
 *	计算两个人分别拿到的硬币总价值，价值高的人获胜。请判定 第一个玩家 是输还是赢？
	
	先玩游戏的我们叫做先手，后玩游戏的叫做后手
	
	注意：对方所选取的结果一定是使得我们以后选取的值最小
 */
public class CoinsInLine2_395
{
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) 
    {
    	int len = values.length;
    	
    	if(len < 2) return true;
    	
    	//f[i]表示到第i个硬币时使得先手数量最大的状态
    	int[] f = new int[len+1];
    	f[len] = 0;
    	
    	f[len-1] = values[len-1];
    	f[len-2] = values[len-2]+values[len-1];
    	f[len-3] = values[len-3]+values[len-2];
    	
    	//sum为总的价值
    	int sum = values[len-1]+values[len-2]+values[len-3];
    	
    	for(int i = len-4 ; i >= 0 ; --i)
    	{
    		//取法一:取一个的价值+上一步对手的最优解
    		//如取values[i],对方可以取values[i+1]或者values[i+1]和values[i+2]
    		//当对方取values[i+1]后,先手只能从i+2到end内取,最大值为f[i+2]
    		//当对方取values[i+1]+values[i+2]后,先手只能从i+3到end内取,最大值为f[i+3]
    		//min(f[i+2],f[i+3])是因为对方所选取的结果一定是使得先手选取的值最小.
    		int first = values[i] + Math.min(f[i+2], f[i+3]);
    		
    		//取法二:取两个的价值+上两步对手的最优解
    		//若取values[i]+values[i+1],对方可取values[i+2]或者values[i+2]+values[i+3]
    		//当对方取values[i+2]后,先手只能从i+3到end内取,最大值为f[i+3]
    		//当对方取values[i+2]+values[i+3]后,先手只能从i+4到end内取,最大值为f[i+4]
    		int second = values[i]+values[i+1]+Math.min(f[i+3], f[i+4]);
    		
    		//在两种取法中选取对先手最有利的一种
    		f[i] = Math.max(first, second);
    		
    		sum += values[i];
    	}

    	return f[0] > sum - f[0];
    }
}
