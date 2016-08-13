package com.hypo.String;

/**
 *	字符串查找 
 *	问题:对于一个给定的 source字符串和一个 target字符串，你应该在source字符串中找出 target字符串出现的第一个位置(从0开始).
 *		如果不存在,则返回 -1
 *
 *	分析:采用KMP算法
 */
public class Strstr_13
{
    public int strStr(String source, String target) 
    {
    	return kmp(source,target);
    }
    
    /**
     * @param source 文本串
     * @param target 模式串
     */
    private int kmp(String T , String P)
    {
    	if(T == null || P == null) return -1;
    	
    	int n = T.length();
    	int m = P.length();
    	
    	if(m == 0) return 0;
    	
    	//计算模式串的前缀数组
    	int[] next = computePrefix(P);
    	
    	//q为匹配字符个数,i为字符串T的下标
    	for(int i = 0 , q = 0 ; i < n ; ++i)
    	{
    		//已经匹配成功q个字符,这里处理第q+1个字符P.charAt(q)与T.charAt(i)不匹配的问题.
    		//循环,q = next[q],获得新的q值,再将P.chatAt(q)与T.chatAt(i)匹配;
    		//直到匹配成功 或 q为0 才跳出循环.
    		while(q > 0 && P.charAt(q) != T.charAt(i))//下个字符不匹配
    		{
    			q = next[q-1];
    		}
    		
    		//上面跳出循环有两个原因:一是第q+1个字符匹配成功,二是q为0;
    		//这里是判断是否是第q+1个字符匹配成功,如果是q的值要加1.
    		if(P.charAt(q) == T.charAt(i))//下个字符匹配
    		{
    			q++;
    		}
    		
    		if(q == m)//匹配字符个数q等于P字符串的长度,即找到匹配
    		{
    			return i - m + 1;//返回T中匹配开始的第一个字符的下标
    		}
    	}
    	
    	//未匹配成功返回-1
    	return -1;
    }
    
    //模式串计算前缀数组
    //下标q,k要小心处理
    private int[] computePrefix(String s)
    {
    	int len = s.length();
    	
    	int[] next = new int[len];
    	
    	//k为匹配字符个数,q为为数组next的下标
    	for(int q = 1, k = 0 ; q < len ; ++q)
    	{
    		//对原先已经匹配的k的字符要添加新的字符s.charAt(k),尝试是匹配字符达到k+1个,
    		//首先要将第k+1个字符和数组中下标为q的字符s.chatAt(q)比较,如果相同,则匹配字符增加到k+1;
    		//如果 不相同,则要将已匹配的k个字符从后往前再做匹配比较,因为可能本来匹配了k个,新添加字符后变为匹配0个到k了都有可能.
    		while(k > 0 && s.charAt(k) != s.charAt(q))
    		{
    			k = next[k-1];
    		}
    		
    		//已经有k个字符匹配,那么将前缀部分第第k+1个字符,即s.charAt(k)与当前q下标的字符比较
    		if(s.charAt(k) == s.charAt(q))
    		{
    			++k;
    		}
    		
    		//前q+1个个字符有k个匹配
    		next[q] = k;
    	}
    	return next;
    }
}
