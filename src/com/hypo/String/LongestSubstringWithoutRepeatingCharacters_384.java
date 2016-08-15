package com.hypo.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *	最长无重复字符的子串	[middle]
 *	给定一个字符串，请找出其中无重复字符的最长子字符串. 
 *	
 *	样例
	例如，在"abcabcbb"中，其无重复字符的最长子字符串是"abc"，其长度为 3。
	对于，"bbbbb"，其无重复字符的最长子字符串为"b"，长度为1。
 */
public class LongestSubstringWithoutRepeatingCharacters_384
{

   /***************************************************************************
    *方法一:空间复杂度O(n),时间复杂度O(n)
    ***************************************************************************/
    public int lengthOfLongestSubstring2(String s) 
    {
    	if(s == null || s.length() < 1) return 0;
    	
    	int len = s.length();
    	
    	int left = 0;//左边界
    	
    	int maxLen = 0;//最长无重复字符串的最大长度
    	
    	Set<Character> hash = new HashSet<Character>();//判重
    	
    	for(int i = 0 ; i < len ; ++i)
    	{
    		if(hash.contains(s.charAt(i)))
    		{
    			//将重复字符前所有加入到了HashSet中的字符删除.
    			while(left < i && s.charAt(left) != s.charAt(i))
    			{
    				hash.remove(s.charAt(left));
    				
    				left++;
    			}
    			
    			left++;
    		}
    		else
    		{
    			maxLen = Math.max(maxLen, i - left + 1);
    			
    			hash.add(s.charAt(i));
    		}
    	}
    	
    	return maxLen;
    }
    
    /***************************************************************************
     *方法二:空间复杂度O(1),时间复杂度O(n)
     ***************************************************************************/
    public int lengthOfLongestSubstring1(String s) 
    {
    	if(s == null || s.length() < 1) return 0;
    	int len = s.length();
    	
    	//字符出现在字符串中的下标,如果出现多次则更新为最后一次.
    	//一共有256个字符,每个字符以ASCII值为它的数组下标
    	int[] lastindex = new int[256];
    	
    	Arrays.fill(lastindex, -1);
    	
    	int maxLen = 0;
    	int currLen = 0;
    	
    	int start = 0;//未发现重复字符字符串的起点下标
    	
//    	int maxstart = 0;//最终找到的无重复字符字符串的起始下标
//    	int maxend = 0;//最终找到的无重复字符字符串的结束下标
    	
    	for(int i = 0 ; i < len ; ++i)
    	{
    		char curr = s.charAt(i);
    		
    		//在新开始的一段字符串中未发现与curr重复的字符.
    		if(lastindex[curr] < start)
    		{
    			lastindex[curr] = i;
    			currLen++;
    		}
    		//在新开始的一段字符串中发现重复字符
    		else
    		{
    			start = lastindex[curr] + 1;//新的无重复字符字符串的起始字符下标
    			
    			currLen = i - start + 1;//新的无重复字符字符串的长度
    			
    			lastindex[curr] = i;//更新字符curr最新出现在字符串中的下标
    		}
    		
    		if(currLen > maxLen)
    		{
    			maxLen = currLen;
    			
//    			maxstart = start;
//    			maxend = i;
    		}
    	}
    	
//    	System.out.println("["+s.substring(maxstart, maxend + 1)+"]");
    	
    	return maxLen;
    }
}
