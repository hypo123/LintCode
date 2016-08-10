package com.hypo.String;

/**
 *	给定一个字符串，逐个翻转字符串中的每个单词 
 *	说明:
 *	1.单词的构成：无空格字母构成一个单词
 *	2.输入字符串是否包括前导或者尾随空格？可以包括，但是反转后的字符不能包括
 *	3.如何处理两个单词间的多个空格？在反转字符串中间空格减少到只含一个	
 */
public class ReverseWordsInString_53
{
    public String reverseWords(String s) 
    {
    	int start = -1;//单词起始下标
    	int end = -1;//单词结束下标
    	
    	StringBuffer result = new StringBuffer();
    	
    	for(int i = 0 ; i < s.length() ; ++i)
    	{
    		if(s.charAt(i) == ' ')
    		{
    	   		if(end > start)
        		{
    	   			//将新单词插入到StringBuffer的头部
    	   			result.insert(0, s.substring(start + 1,  end + 1) + " ");
        			
        			if(result.length() > 0)
        			{
        				result.append(' ');
        			}
        		}
    	   		
    	   		start = i;
    		}
    		else
    		{
    			end = i;
    		}
    	}
    	
    	//最后一个单词可能没有处理,需先判断再处理
    	if(end > start )
    	{
    		result.insert(0, s.substring(start + 1)+" ");
    	}
    	
    	return result.toString().trim();
    }
}
