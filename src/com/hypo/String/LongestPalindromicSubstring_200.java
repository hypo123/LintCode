package com.hypo.String;

/**
 *	最长回文子串	[middle] 
 *	问题:给出一个字符串（假设长度最长为1000),求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 *
 *	样例
	给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc";
 *
 */
public class LongestPalindromicSubstring_200
{
   /***************************************************************************
    *方法一:暴力枚举法 时间复杂度O(n^2)
    ***************************************************************************/	
    public String longestPalindrome(String s) 
    {
    	if(s == null || s.length() < 1) return null;
    	
    	int maxlen = 0;//最长回文字符串长度
    	int endindex = 0;//终点
    	
    	for(int i = 0 ; i < s.length() ; ++i)
    	{
    		if(isPalindrome(s, i - maxlen, i))//判断以i为结束下标,长度为maxlen+1的字符串是否是回文字符串
    		{
    			endindex = i;//更新终点下标
    			maxlen++;//更新当前最长回文字符串的长度
    		}
    		//判断以i为结束下标,长度为maxlen+2的字符串是否是回文字符串
    		else if(i - maxlen - 1 >= 0 && isPalindrome(s, i - maxlen - 1, i))
    		{
    			endindex = i;
    			maxlen += 2;
    		}
    	}
    	
    	return s.substring(endindex - maxlen + 1, endindex + 1);
    }
    
    private boolean isPalindrome(String t , int start , int end)
    {
    	for(int i = start , j = end ; i <= j ; ++i , --j)
    	{
    		if(t.charAt(i) != t.charAt(j))
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    /***************************************************************************
     *方法二:动态规划	时间复杂度O(n^2)
     *
     *设状态f(i,j),表示区间[i,j]是否为回文串,则状态转移方程为:
     *	
     *f(i,j) = true , i=j
     *         S[i]=S[j] , j=i+1
     *		   S[i]=S[j] and f(i+1,j-1), j>i+1	
     *
     ***************************************************************************/
    public String longestPalindrome2(String s)
    {
    	int len = s.length();
    	boolean[][] f = new boolean[len][len];
    	
    	int max_len = 1;//最长回文字符串长度
    	int start = 0;//起点
    	
    	for(int i = 0 ; i < len ; ++i)
    	{
    		f[i][i] = true;
    		
    		for(int j = 0 ; j < i ; ++j)
    		{
    			f[j][i] = (s.charAt(j) == s.charAt(i)) && (i - j < 2 || f[j+1][i-1]);
    			
    			if(f[j][i] && i - j + 1 > max_len)
    			{
    				max_len = i - j + 1;
    				
    				start = j;
    			}
    		}
    	}
    	
    	
    	return s.substring(start, start + max_len);
    }
    
    /***************************************************************************
     *方法三:manacher算法	时间复杂度O(n^2)
     *  以aba 和 abba为例先做preProcess字符串预处理
     *	aba  ———>  ^#a#b#a#$
     *	abba ———>  ^#a#b#b#a#$
     *
     *		# a # b # a #
	 *回文半径	1 2 1 4 1 2 1
  	  	  i:0 1 2 3 4 5 6
     *
     *	manacher算法参见 https://segmentfault.com/a/1190000003914228
     ***************************************************************************/
    public String longestPalindrome3(String s)
    {
    	String T = preProcess(s);
    	
    	//以T.charAt(i)为中心向左右扩张,不包含T.charAt(i)自己
    	final int n = T.length();
    	
    	//P[i]是以i为对称轴的回文字符串的回文半径
    	int[] P = new int[n];
    	
    	//R对应的回文串的对称轴所在的位置,记为C
    	int C = 0 ;
    	//R表示当前访问到的所有回文子串，所能触及的最右一个字符的位置
    	int R = 0;
    	
    	for(int i = 1 ; i < n - 1; ++i)
    	{
    		int i_mirror = 2 * C - i;//i关于C对称轴的字符下标
    		
    		//以i为对称轴的回文字符串的长度
    		//如果i比R大,则初始P[i]为0;如果i比R小,则初始P[i]的值要看i的位置决定
    		P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;
    		
    		//以i所在字符为中心,向左右扩张.
    		while(T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
    		{
    			P[i]++;
    		}
    		
    		//当前以i为对称轴的回文字符串的最右边界是否比原来的R大
    		if(i + P[i] > R)
    		{
    			C = i;  //更新最右边界回文字符串的对称轴
    			R = i + P[i];//更新最右边界
    		}
    	}

    	int max_len = 0;
    	int center_index = 0;
    	
    	//找到数组P中最大值
    	for(int i = 1 ; i < n - 1; ++i)
    	{
    		if(P[i] > max_len)
    		{
    			max_len = P[i];
    			center_index = i;
    		}
    	}
    	
    	int start = (center_index - 1 - max_len) / 2;
    	
    	
    	return s.substring(start , start + max_len);
    }
    
    //字符串预处理
    //'^','$'分别为左右两边的哨兵
    private String preProcess(String s)
    {
    	int len = s.length();
    	
    	if(len == 0) return "^$";
    	
    	StringBuffer ret = new StringBuffer();
    	
    	ret.append('^');
    	
    	for(int i = 0 ; i < len ; ++i)
    	{
    		ret.append('#');
    		ret.append(s.charAt(i));
    	}
    	
    	ret.append('#');
    	ret.append('$');
    	
    	return ret.toString();
    }
}
