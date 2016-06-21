package com.hypo.String;

/**
 * 最长公共前缀
 */
public class LCP_78
{
    private static String longestCommonPrefix(String[] strs) 
    {
    	if(strs.length == 0) return "";
    	
    	String start = strs[0];
    	
    	if(start == null || start.length() < 1) return "";
    	
    	int minlen = start.length();
    	
    	for(int i = 1 ; i < strs.length ; i++)
    	{
    		if(strs[i] == null) return null;
    		
    		if(strs[i].length() < minlen) minlen = strs[i].length();
    		
    		for(int j = 0 ; j < minlen ; j++)
    		{
    			if(strs[i].charAt(j) != start.charAt(j))
    			{
    				minlen = j;
    				break;
    			}
    		}
    	}
    	
    	if(minlen <= 0)
    	{
    		return "";
    	}
    	else
    	{
    		return start.substring(0, minlen);
    	}
    }
	public static void main(String[] args)
	{
		
		String[] strs = {"" , "ABCEFG" , "ABCEFA"};
		
		System.out.println(LCP_78.longestCommonPrefix(strs));
	}
}
