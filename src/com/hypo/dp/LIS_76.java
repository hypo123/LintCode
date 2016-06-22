package com.hypo.dp;

import java.util.Arrays;

/**
 *	最大上升子序列 	[middle]
 *	描述:最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，
 *		这种子序列不一定是连续的或者唯一的.
 *		可包含相等的情况.
 * 	
 * 	分析一:动态规划
 * 		 第i个元素之前的最长递增子序列的长度要么是1（单独成一个序列），要么就是第i-1个元素之前的最长递增子序列加1，可以有状态方程
 * 		LIS[i] = max{1 , LIS[k]+1} , 其中对任意0<k<i, 有nums[i]>=nums[k],那么可原本的递增序列加长1;
 * 
 * 	分析二:排序+LCS
 * 		先将复制数组A,得到数组B;再将数组B排序
 * 		再求数组A和数组B的最长公共子序列长度,该长度就是A的最长增长子序列长度.
 * 		因为LIS是单调递增的性质，所以任意一个LIS一定跟排序后的序列有LCS,并且就是LIS本身.
 * 
 * 	分析三:动态规划+二分查找   时间O(NlogN)
 * 		 假设有序列N[2 1 5 3 6 4 8 9 7]一共9个元素;从下标1到9做个分析;
 * 		保存LIS最小末尾数的数组为T
 * 		第1个,N[1]=2 , T[1]=2; T的长度len=1
 * 		第2个,N[2]=1 , T[1]=1; 长度为1的LIS最小末尾变为1,T[1]=2无效已被替换,T的长度len=1;
 * 		第3个,N[3]=5 , T[2]=5; 长度为2的LIS最小末尾置为2,T[1,2]=[1,5],T的长度len=2;
 * 		第4个,N[4]=3 , T[2]=3; 长度为2的LIS最小末尾变为2,T[1,2]=[1,3],T的长度len=2;
 * 		第5个,N[5]=6 , T[3]=6; 长度为3的LIS最小末尾置为6,T[1,2,3]=[1,3,6],T的长度len=3;
 * 		第6个,N[6]=4 , T[3]=4; 长度为3的LIS最小末尾变为4,T[1,2,3]=[1,3,4],T的长度len=3;
 * 		第7个,N[7]=8 , T[4]=8; 长度为4的LIS最小末尾置为8,T[1,2,3,4]=[1,3,4,8],T的长度len=4;
 * 		第8个,N[8]=9 , T[5]=9; 长度为5的LIS最小末尾置为9,T[1,2,3,4,5]=[1,3,4,8,9],T的长度len=5;
 * 		第9个,N[9]=7 , T[4]=7; 长度为4的LIS最小末尾置为7,T[1,2,3,4,5]=[1,3,4,7,9],T的长度len=5;
 * 		得到LIS的长度为5;
 * 		注意:最后求得的T=[1,3,4,7,9]不是LIS,只是LIS对应长度上的最小末尾.
 * 
 * 		因为在T中插入数据是有序的,而且是进行替换不需要挪动;所以可以是由二分查找,插入的时间优化为O(logN)
 * 		总的时间为O(NlogN);
 */
public class LIS_76
{
//	---------分析一实现------------
    public int longestIncreasingSubsequence(int[] nums) 
    {
    	int[] dp = new int[nums.length];//dp[i]的值是数组从0到i的最长增长子序列长度.
    	
    	int maxLen = 0;
    	
    	for(int i = 0 ; i < nums.length ; ++i)
    	{
    		dp[i] = 1;
    		
    		for(int j = 0 ; j < i ; ++j)
    		{
    			if(nums[i] >= nums[j] && dp[i] < dp[j] + 1)
    			{
    				dp[i] = dp[j] + 1;
    				
    				maxLen = Math.max(maxLen, dp[i]);
    			}
    		}
    	}
    	
    	return maxLen;
    }
//    ---------分析二实现--------
    public int longestIncreasingSubsequence2(int[] nums)    
    {
    	int[] A = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(A);//排序
    	return LCS(A,nums);
    }
    
    //求最长公共子序列
    private static int LCS(int[] A , int[] B)
    {
    	int len = A.length;
    	
    	int maxLen = -1;
    	
    	int[][] f = new int[len+1][len+1];
    	
    	for(int i = 1 ; i <= len ; ++i)
    	{
    		for(int j = 1 ; j <= len ; ++j)
    		{
    			if(A[i-1] == B[j-1])
    			{
    				f[i][j] = f[i-1][j-1] + 1;
    			}
    			else if(f[i-1][j] > f[i][j-1])
    			{
    				f[i][j] = f[i-1][j];//上
    			}
    			else
    			{
    				f[i][j] = f[i][j-1];//左
    			}
    			
    			if(f[i][j] > maxLen) maxLen = f[i][j];
    		}
    	}
    	return maxLen;
    }
    
//    ---------分析三实现--------
    public int longestIncreasingSubsequence3(int[] nums) 
    {
    	if(nums.length < 1) return 0;
    	
    	int[] tail = new int[nums.length];
    	tail[0] = nums[0];
    	int	len = 1;
    	
    	for(int i = 1; i < nums.length ; ++i)
    	{
    		int pos = binarySearch(tail , len , nums[i]);
    		
    		tail[pos] = nums[i];
    		
    		if(len <= pos)
    		{
    			len = pos + 1;
    		}
    	}
    	
    	return len;
    }
    
    //在非递减数列a的[0,len-1]的闭区间上查找第一个大于等于key的位置,如果都小于key,则返回len
    private static int binarySearch(int[] a , int len , int key)
    {
    	if(key >= a[len-1])
    	{
    		return len;
    	}
    	
        int low = 0;
        int high = len - 1;

        //查找第一个大于等于key的位置
        while (low < high) 
        {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal <= key)
            {
            	low = mid + 1;
            }
            else
            {
            	high = mid;
            }
        }
        return low;
    }
}
