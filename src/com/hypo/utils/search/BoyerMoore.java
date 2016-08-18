package com.hypo.utils.search;

/**
 * Boyer-Moore字符串查找算法
 * [这里只实现Boyer-Moore算法的一部分想法]
 * 
 * Boyer-Moore算法的性能在一般情况下都是亚线性级别的(可能是线性级别的M倍).
 * 
 * 参考http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
 */
public class BoyerMoore
{
	private final int R; //字符个数(ASCII中字符个数为256个)
	
	private int[] right; //字母表中每个字符在模式串中出现的最靠右的地方,如果字符在模式串中不存在则为-1;

	private char[] pattern; //模式串的字符数组形式
	private String pat; // 模式串

	/**
	 * 预处理模式串
	 * 形式1:模式串以字符串形式传入
	 */
	public BoyerMoore(String pat)
	{
		this.R = 256;
		this.pat = pat;

		right = new int[R];
		
		//right数组初值全部赋为-1
		for (int c = 0; c < R; c++)
		{
			right[c] = -1;
		}

		//字母表中字符在模式串中出现的最右的位置
		for (int j = 0; j < pat.length(); j++)
		{
			right[pat.charAt(j)] = j;
		}
	}

	/**
	 * 预处理模式串
	 * 形式2:模式串以字符数组形式传入
	 * 		并出入字母表大小
	 */
	public BoyerMoore(char[] pattern, int R)
	{
		this.R = R;
		this.pattern = new char[pattern.length];
		
		for (int j = 0; j < pattern.length; j++)
		{
			this.pattern[j] = pattern[j];
		}

		right = new int[R];
		
		for (int c = 0; c < R; c++)
		{
			right[c] = -1;
		}

		for (int j = 0; j < pattern.length; j++)
		{
			right[pattern[j]] = j;
		}
	}

	/**
	 *  文本串以字符串形式传入
	 */
	public int search(String txt)
	{
		int m = pat.length();//模式串长度
		int n = txt.length();//文本串长度
		
		int skip;
		
		for (int i = 0; i <= n - m; i += skip)
		{
			skip = 0;//后移位数
			
			//从后往前比对
			for (int j = m - 1; j >= 0; j--)
			{
				//找到不匹配的坏字符P = txt.charAt(i+j)
				//查right数组找到P在模式串中出现的最右的位置,即right[P]
				if (pat.charAt(j) != txt.charAt(i + j))
				{
					//后移位数
					skip = Math.max(1, j - right[txt.charAt(i + j)]);
					
					break;
				}
			}
			
			//后移位数一直为0,说明都匹配
			if (skip == 0)
			{
				//找到匹配
				return i;
			}
		}
		
		//未找到匹配
		return n; 
	}

	/**
	 * 文本串以字符数组形式传入
	 */
	public int search(char[] text)
	{
		int m = pattern.length;
		int n = text.length;
		int skip;
		for (int i = 0; i <= n - m; i += skip)
		{
			skip = 0;
			for (int j = m - 1; j >= 0; j--)
			{
				if (pattern[j] != text[i + j])
				{
					skip = Math.max(1, j - right[text[i + j]]);
					break;
				}
			}
			if (skip == 0)
				return i; // found
		}
		return n; // not found
	}
}
