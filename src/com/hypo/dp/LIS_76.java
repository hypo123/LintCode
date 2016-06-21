package com.hypo.dp;

/**
 *	最大上升子序列 [middle]
 *	最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，
 *	这种子序列不一定是连续的或者唯一的
 *	可包含相等的情况
 * 	
 * 	分析:动态规划
 */
public class LIS_76
{
    public int longestIncreasingSubsequence(int[] nums) 
    {
    	int[] f = new int[nums.length];
    	f[0] = nums[0];
    	
    	for(int i = 0 ; i < nums.length ; i++)
    	{
    		f[i] = 1;
    		
    		for(int j = 0 ; j <= i ;j++)
    		{
    			if(nums[i] >= nums[j])
    			{
    				f[i] = Math.max(f[j] + 1, f[i]);
    			}
    		}
    	}
    	
    	return f[nums.length];
    }
}
