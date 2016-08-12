package com.hypo.dp;

/**
 * 最长公共子序列	[middle]
 * 动态规划
 * 
 * 
 * 分析见算法导论P224
 */
public class LCS_77
{
    public static  int longestCommonSubsequence(String A, String B) 
    {
    	if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
    	
    	int lenA = A.length();
    	int lenB = B.length();
    	
    	int[][] f = new int[lenA+1][lenB+1];
    	
    	int maxlen = -1;//最长公共字串长度
    	
    	//注意i,j的下标都是从1开始的
    	//第一行,第一列都为0
    	for(int i = 1 ; i <= lenA ; i++)
    	{
    		for(int j = 1 ; j <= lenB ; j++)
    		{
    			if(A.charAt(i - 1) == B.charAt(j - 1))
    			{
    				f[i][j] = f[i-1][j-1] + 1;
    			} 
    			else if(f[i-1][j] >= f[i][j-1])
    			{
    				f[i][j] = f[i-1][j];
    			}
    			else
    			{
    				f[i][j] = f[i][j-1];
    			}
    			
    			if(f[i][j] > maxlen) maxlen = f[i][j];
    		}
    	}
    	return maxlen;
    }
}
