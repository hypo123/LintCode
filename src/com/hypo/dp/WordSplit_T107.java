package com.hypo.dp;

import java.util.Set;

/**
 *	在LintCode下超时,在LeetCode下没有超时. 
 *
 *	动态规划
 */

public class WordSplit_T107
{
    public static boolean wordBreak(String s, Set<String> dict) 
    {
    	//长度为n的字符串有n+1个隔板
    	boolean f[] = new boolean[s.length()+1];
    	
    	//空字符串
    	f[0] = true;
    	
    	for(int i = 1 ; i <= s.length(); ++i)
    	{
    		for(int j = i - 1 ; j >= 0 ; --j)
    		{
    			if(f[j] && dict.contains(s.substring(j, i)))
    			{
    				f[i] = true;
    				break;
    			}
    		}
    	}
    	return f[s.length()];
    }
}
