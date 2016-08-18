package com.hypo.utils.search;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin-Karp字符串查找算法
 * 
 * 思想:对于长度为M的模式串,需要先使用散列函数计算模式串的hash值,然后用相同的散列函数计算文本中所有可能的M个字符的子字符串
 * 	       的hash值并寻找匹配;如果找到了一个散列值和模式字符串相同的子字符串,那么再继续验证两者是否匹配.
 * 
 * 使用蒙特卡洛算法的Rabin-Karp子字符串查找算法的运行时间是线性级别的且出错的概率极小;
 * 使用拉斯维加斯算法的Rabin-Karp子字符串查找算法能够保证正确性且性能极其接近线性级别.
 * 
 *
 */
public class RabinKarp
{
	private String pat; // 模式字符串
	private long patHash; // 模式字符串的散列值
	private int m; // 模式字符串的长度
	private long q; // 一个很大的素数
	private int R; // 字母表的大小
	private long RM; // R^(M-1) % Q

	/**
	 * 预处理模式串
	 */
	public RabinKarp(char[] pattern, int R)
	{
		throw new UnsupportedOperationException("Operation not supported yet");
	}

	/**
	 * 预处理模式串
	 */
	public RabinKarp(String pat)
	{
		this.pat = pat; //模式串
		
		R = 256;//字母表大小为256
		
		m = pat.length();//模式串长度
		
		q = longRandomPrime();//随机生成一个31位的大素数

		RM = 1;
		
		//预先计算
		for (int i = 1; i <= m - 1; i++)
		{
			RM = (R * RM) % q;
		}
		
		//计算模式串的hash值
		patHash = hash(pat, m);
	}

	// 计算hash值 horner方法
	// [0,m-1]上字串的hash值
	private long hash(String key, int m)
	{
		long h = 0;
		
		for (int j = 0; j < m; j++)
		{
			h = (R * h + key.charAt(j)) % q;
		}
	
		return h;
	}

	//拉斯维加斯算法,在两个字符串的hash值相等之后,进一步验证
	//继续一个字符一个字符的比较
	private boolean check(String txt, int i)
	{
		for (int j = 0; j < m; j++)
		{
			if (pat.charAt(j) != txt.charAt(i + j))
			{
				return false;
			}
		}
		
		return true;
	}

	// 蒙特卡罗算法
	private boolean check(int i)
	{
		return true;
	}

	public int search(String txt)
	{
		int n = txt.length();//文本串的长度
		
		//文本串长度小于模式串长度
		if (n < m)
		{
			//未找到匹配
			return n;
		}
		
		//计算文本串前m个字符组成的子字符串的的hash值
		long txtHash = hash(txt, m);

		//文本串hash值与模式串hash值相等
		if ((patHash == txtHash) && check(txt, 0))
		{
			//找到匹配,起始下标为0
			return 0;
		}

		//i从m开始
		for (int i = m; i < n; i++)
		{
			//以先减去第一个字符再添加后一个字符的形式来计算不断一格一格的移动
			
			//减去第一个字符,去掉一个字符,剩余长度为m-1的字符串的hash值,这儿不好理解(horner法则)
			txtHash = (txtHash + q - RM * txt.charAt(i - m) % q) % q;
			
			//添加后一个字符,字符串长度重新变为m,并且向后移动了一位
			txtHash = (txtHash * R + txt.charAt(i)) % q;

			// match
			int offset = i - m + 1;

			//字串hash值与模式串hash值相同,并调用check方法进一步检查字串是否与模式串一样
			if ((patHash == txtHash) && check(txt, offset))
			{
				//找到匹配,返回字串起始字符下标
				return offset;
			}
		}

		//未找到匹配
		return n;
	}

	// 产生随机31位素数
	private static long longRandomPrime()
	{
		//返回有可能是素数的、具有指定长度的正 BigInteger。此方法返回的 BigInteger是合数的概率不超出 2-100
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		
		//将 BigInteger转换为 long
		return prime.longValue();
	}
	
    public static void main(String[] args)
    {
        String pat = args[0];
        String txt = args[1];

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

    }
}
