package com.hypo.unionfind;

import java.util.HashMap;

/**
 *	lintcode124 最长连续数列
 */
public class LCS_124
{
    private static int longestConsecutive(int[] num)
    {
    	int result = 0;
    	
    	//<键值,连续序列长度>
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int n : num)
    	{
    		if(!map.containsKey(n))
    		{
    			//由连续序列的最左边和最右边记录当前连续序列的长度.
    			int left = map.containsKey(n-1) ? map.get(n-1) : 0;
    			int right = map.containsKey(n+1) ? map.get(n+1) : 0;
    			
    			//四种情况
    			//A.   左:234  右:678  插5   max=3+3+1
    			//B.   左:234 右:    插5   max=3+1
    			//C.   左：         右:678    插5   max=3+1
    			//D.   左:   右:     插5   max=1
    			int max = left + right + 1;
    			
    			map.put(n, max);
    			
    			result = Math.max(result, max);
    			
    			map.put(n - left, max);
    			map.put(n + right , max);
    		}
    	}
    	
    	return result;
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		
		System.out.println(LCS_124.longestConsecutive(num));
	}

}
