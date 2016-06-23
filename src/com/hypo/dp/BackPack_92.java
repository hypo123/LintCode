package com.hypo.dp;

/**
 *  背包问题 [middle]
 *  0-1背包
 *	描述:在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 *
 *	样例
 *	如果有4个物品[2, 3, 5, 7]
 *	如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
 *	如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
 *	函数需要返回最多能装满的空间大小。
 *
 *	分析:
 */
public class BackPack_92
{
    public int backPack(int m, int[] A) 
    {
    	int[] f = new int[m+1];
    	int N = A.length;
    	
    	for(int i = 1 ; i <= N ; ++i)
    	{
    		for(int v = m ; v >= A[i-1] ; --v)
    		{
    			f[v] = Math.max(f[v], f[v-A[i-1]]+A[i-1]);
    		}
    	}
    	return f[m];
    }
    
    public static void main(String[] args)
	{
    	BackPack_92  t92 = new BackPack_92();
    	
		int[] A1 = {2, 3, 5, 7};
		int m1 =11 ;
		
		System.out.println(t92.backPack(m1, A1));
	}
}
