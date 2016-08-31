package com.hypo.dp;

/**
 *	不同的子序列	[middle] 
 *
 *	给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
	子序列字符串是原始字符串通过删除一些(或零个)产生的一个新的字符串，并且对剩下的字符的相对位置没有影响。
	(比如，“ACE”是“ABCDE”的子序列字符串,而“AEC”不是)。
	
	样例:
	给出S = "rabbbit", T = "rabbit"
	返回 3
	
	动态规划
	设状态为f(i,j)表示T[0,j]在S[0,i]里出现的次数
	首先,无论S[i]和T[j]是否相等,若不使用S[i],则f(i,j)=f(i-1,j);
	若S[i]==T[j],则可以使用S[i],此时f(i,j)=f(i-1,j)+f(i-1,j-1);
 *
 */
public class DistinctSubsequences_118
{
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) 
    {
    	int lens = S.length();
    	int lent = T.length();
    	
    	int[][] f = new int[lens+1][lent+1];//状态数组
    	
    	//对于T串为""时,不管S串是什么都包含空字符串""一次
    	for(int i = 0 ; i <= lens ; ++i)
    	{
    		f[i][0] = 1;
    	}
    	
    	for(int i = 1 ; i <= lens; ++i)//S
    	{
    		for(int j = 1; j <= lent ; ++j)//T
    		{
    			if(S.charAt(i-1) == T.charAt(j-1))
    			{
    				//状态转移方程1
    				f[i][j] = f[i-1][j] + f[i-1][j-1];
    			}
    			else
    			{
    				//状态转移方程2
    				f[i][j] = f[i-1][j];
    			}
    		}
    	}
    	
    	return f[lens][lent];
    }
    
//  空间优化	使用滚动数组
    public int numDistinct2(String S, String T)
    {
    	int lens = S.length();
    	int lent = T.length();
    	
    	int[] f = new int[lent+1];//一维状态数组
    	f[0] = 1;
    	
    	for(int i = 0 ; i < lens ; ++i)//S
    	{
    		for(int j = lent-1 ; j >= 0 ; --j)//T
    		{
    			f[j+1] += S.charAt(i) == T.charAt(j) ? f[j] : 0;
    		}
    	}
    	
    	return f[lent];
    }
    
}
