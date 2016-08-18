package com.hypo.utils.search;

/**
 *	暴力子字符串查找算法 
 *
 */
public class FindSubStr
{
	//txt为文本串,pat为模式串
	public static int search(String pat , String txt)
	{
		int M = pat.length();//模式串长度
		int N = txt.length();//文本串长度
		
		for(int i = 0 ; i <= N - M ; ++i)
		{
			int j;
			
			for(j = 0 ; j < M ; ++j)
			{
				if(txt.charAt(i+j) != pat.charAt(i+j))
				{
					break;
				}
			}
		
			//找到匹配
			if(j == M) 
			{
				return i;
			}
		}
		
		return N;//未找到匹配
	}
}
