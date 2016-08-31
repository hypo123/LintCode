package com.hypo.dp;

/**
 *	栅栏染色	[easy]
 *
 *	我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
	至多有两根相邻的柱子具有相同的颜色，求有多少种染色方案。

 	注意事项:
	n和k都是非负整数 
	
	样例:
		n = 3, k = 2, return 6
		
		      post 1,   post 2, post 3
		way1    0         0       1 
		way2    0         1       0
		way3    0         1       1
		way4    1         0       0
		way5    1         0       1
		way6    1         1       0
	
	分析:至多有两根相邻的柱子具有相同的颜色,即第i根柱子的颜色只与第i-1根和第i-2根柱子的颜色有关.
		前i-2根柱子有f[i-2]种方案;
		前i-1根柱子有f[i-1]种方案;
		如果第i根柱子的颜色与第i-1根柱子的颜色一样,那么它们的颜色必须与第i-2根柱子的颜色不一样,前i根柱子的染色方案有f[i-2]*(k-1)种;
		如果第i根柱子的颜色与第i-1根柱子的颜色不一样,那么第i根柱子的颜色就与第i-2根柱子的颜色没关系,前i根柱子的染色方案有f[i-1]*(k-1)种;
		
		状态转移方程:
		f[i] = f[i-1]*(k-1) + f[i-2]*(k-1);
		
 *
 */
public class PaintFence_514
{
    /**
     * @param n non-negative integer, n posts  n个柱子
     * @param k non-negative integer, k colors k种颜色
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) 
    {
    	if(n == 1) return k;
    	if(n == 2) return k*k;
    	
    	if(k <= 1) return 0;
    	
    	//f[i]表示前i个柱子的染色方案个数
    	int[] f = new int[n+1];
    	
    	f[1] = k;
    	f[2] = k * k;
    	
    	for(int i = 3 ; i <= n ; ++i)
    	{
    		f[i] = f[i-1]*(k-1) + f[i-2]*(k-1) ;
    	}
    	
    	return f[n];
    }
}
