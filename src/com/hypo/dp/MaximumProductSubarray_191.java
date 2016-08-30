package com.hypo.dp;

import java.util.Arrays;

/**
 *	乘积最大子序列	[middle] //最大连续子序列乘积
 *
 *	找出一个序列中乘积最大的连续子序列(至少包含一个数) 
 *
 *	样例
	比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3],其乘积为6。
 *
 */
public class MaximumProductSubarray_191
{
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) 
    {
    	int n = nums.length;
    	
    	//dpmax[i]以nums[i]结尾的乘积最大的连续子序列的值
    	int[] dpmax = new int[n+1];
    	
    	//dpmin[i]以nums[i]结尾的乘积最小的连续子序列的值
    	int[] dpmin = new int[n+1];
    	
    	Arrays.fill(dpmax, Integer.MIN_VALUE);
    	Arrays.fill(dpmin, Integer.MAX_VALUE);
    	
    	dpmax[0] = nums[0];
    	dpmin[0] = nums[0];
    	
    	for(int i =  1 ; i < n ; ++i)
    	{
    		dpmax[i] = Math.max(nums[i] , Math.max(dpmax[i-1]*nums[i], dpmin[i-1]*nums[i]));
    		
    		dpmin[i] = Math.min(nums[i] , Math.min(dpmax[i-1]*nums[i], dpmin[i-1]*nums[i]));
    	}
    	
    	int maxProduct = Integer.MIN_VALUE;
    	
    	for(int s : dpmax)
    	{
    		if(s > maxProduct) maxProduct = s;
    	}
    	
    	return maxProduct;
    }
    
//    空间优化
    public int maxProduct2(int[] nums) 
    {
    	int n = nums.length;
    	
    	int dpmax = nums[0];//以当前元素为结尾的乘积最大的连续子序列的值
    	
    	int dpmin = nums[0];//以当前元素为结尾的乘积最小的连续子序列的值
    	
    	int maxProduct = nums[0];
    	
    	for(int i =  1 ; i < n ; ++i)
    	{
    		int temp = dpmax;
    		dpmax = Math.max(nums[i], Math.max(dpmax*nums[i], dpmin*nums[i]));
    		
    		dpmin = Math.min(nums[i], Math.min(temp*nums[i], dpmin*nums[i]));
    		
    		maxProduct = Math.max(maxProduct, dpmax);
    	}
    	
    	return maxProduct;
    }
}
