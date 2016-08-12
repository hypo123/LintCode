package com.hypo.dp;

import java.util.ArrayList;

/**
 *	交叉字符串	[middle] 
 *	问题描述:给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成.
 *
 *	样例
 *	比如 s1 = "aabcc" s2 = "dbbca"
 *   - 当 s3 = "aadbbcbcac"，返回  true.
 *   - 当 s3 = "aadbbbaccc"， 返回 false.
 *   
 *   分析:动态规划
 *   	设状态f[i][j],表示s1[0,i]和s2[0,j],匹配s3[0,i+j].
 *   	如果s1的最后一个字符等于s3的最后一个字符,则 f[i][j]= f[i-1][j];
 *   	如果s2的最后一个字符等于s3的最后一个字符,则 f[i][j]= f[i][j-1].因此有如下状态转移方程:
 *   	f[i][j] = (s1[i-1] == s3[i+j-1] && f[i-1][j]) 
 *   			||(s2[j-1] == s3[i+j-1] && f[i][j-1]);
 *
 */
public class InterleavingString_29
{
    public boolean isInterleave(String s1, String s2, String s3) 
    {
    	//s3的长度不等于s1和s2长度之和
    	if(s1.length() + s2.length() != s3.length()) return false;
    	
    	boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
    	
    	f[0][0] = true;
    	
    	for(int i = 1 ; i <= s1.length() ; ++i)	
    	{
    		//不用s2,只用s1做匹配
    		f[i][0] = s1.charAt(i - 1 ) == s3.charAt(i - 1) && f[i-1][0];
    	}
    	
    	for(int i = 1 ; i <= s2.length() ; ++i)
    	{
    		//不用s1,只用s2做匹配
    		f[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && f[0][i-1];
    	}
    	
    	//用s1,s2一起做匹配
    	for(int i = 1 ; i <= s1.length() ; ++i)
    	{
    		for(int j = 1 ; j <= s2.length() ; ++j)
    		{
    			//状态转移方程
    			f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i-1][j])
    					|| (s2.charAt(j - 1) == s3.charAt(i + j -1) && f[i][j-1]);
    		}
    	}
    	
        return f[s1.length()][s2.length()];
    }

/*    //A为短字符串,B为长字符串
    public boolean lcs(String A , String B , int[][] f)
    {
    	if(A == null || B == null || A.length() == 0 || B.length() == 0) return false;

    	int lenA = A.length();
    	int lenB = B.length();

    	int maxlen = -1;//最长公共字串长度
    	
    	for(int i = 1 ; i <= lenA ; ++i)
    	{
    		for(int j = 1 ; j <= lenB ; ++j)
    		{
    			if(A.charAt(i - 1) == B.charAt(j - i))//两个字符相等,由上斜对角f[i-1][j-1]决定
    			{
    				f[i][j] = f[i - 1][j - 1] + 1;
    			}
    			else if(f[i - 1][j] > f[i][j - 1])//上大于左
    			{
    				f[i][j] = f[i - 1][j];
    			}
    			else//左大于等于上
    			{
    				f[i][j] = f[i][j - 1];
    			}
    			
    			if(f[i][j] > maxlen) maxlen = f[i][j];
    		}
    	}
    	
    	return maxlen == lenA;
    }*/
}
