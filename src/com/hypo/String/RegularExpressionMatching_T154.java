package com.hypo.String;

/**
 * 正则表达式
 * 1.连接操作     AB   {AB}
 * 2.或操作	A|B  {A,B}
 * 3.闭包操作: 模式的闭包是由将模式和自身连接任意多次(包括0次)而得到的所有字符串所组成的语言.
 * 			如:AB* 指定由一个A和0个或多个B组成的字符串;
 * 4.括号:	使用括号来改变默认的优先级顺序;
 * 
 * 优先级:括号 > 闭包 > 连接 > 或
 * 
 *	实现支持通配符('.')和闭包('*')的正则表达式.
 *  '.'	匹配任意单个字符 ;
 *  '*'	和自身连接的字符(或元字符)可出现任意多次(包括0次)
 */
public class RegularExpressionMatching_T154
{
	//s-模式串 ,p-匹配串
    public boolean isMatch(String s, String p) 
    {
    	
    	
    	return false;
    }
    
    private boolean match(String s , int indexs , String p , int indexp)
    {
    	// 匹配串和模式串都到达尾，说明成功匹配
    	if(indexs >= s.length() && indexp >= p.length())
    	{
    		return true;
    	}
    	
    	// 只有模式串到达结尾，说明匹配失败
    	if(indexs != s.length() && indexp >= p.length())
    	{
    		return false;
    	}
    	
    	
    	
    	return false;
    }
    
    
}



/*    
	public static boolean match(String input, String pattern)
	{
		if (input == null || pattern == null)
		{
			return false;
		}
		return matchCore(input, 0, pattern, 0);
	}

	private static boolean matchCore(String input, int i, String pattern, int p)
	{
		// 匹配串和模式串都到达尾，说明成功匹配
		if (i >= input.length() && p >= pattern.length())
		{
			return true;
		}
		// 只有模式串到达结尾，说明匹配失败
		if (i != input.length() && p >= pattern.length())
		{
			return false;
		}
		// 模式串未结束，匹配串有可能结束有可能未结束
		// p位置的下一个字符中为*号
		if (p + 1 < pattern.length() && pattern.charAt(p + 1) == '*')
		{
			// 匹配串已经结束
			if (i >= input.length())
			{
				return matchCore(input, i, pattern, p + 2);
			}
			// 匹配串还没有结束
			else
			{
				if (pattern.charAt(p) == input.charAt(i)
						|| pattern.charAt(p) == '.')
				{
					// 匹配串向后移动一个位置，模式串向后移动两个位置
					// 匹配串向后移动一个位置，模式串不移动
					// 匹配串不移动，模式串向后移动两个位置
					return	matchCore(input, i + 1, pattern, p + 2)		
							|| matchCore(input, i + 1, pattern, p)							
							|| matchCore(input, i, pattern, p + 2);
				}
				else
				{
					return matchCore(input, i, pattern, p + 2);
				}
			}
		}
		//
		// 匹配串已经结束
		if (i >= input.length())
		{
			return false;
		}
		// 匹配串还没有结束
		else
		{
			if (input.charAt(i) == pattern.charAt(p)
					|| pattern.charAt(p) == '.')
			{
				return matchCore(input, i + 1, pattern, p + 1);
			}
		}
		return false;
	}*/