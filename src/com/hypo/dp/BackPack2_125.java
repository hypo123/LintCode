package com.hypo.dp;

import java.util.Arrays;

/**
 * 背包问题II [middle]
 * 0-1背包
 * 描述:
 * 	 有N件物品和一个容量为V的背包.放入第i件物品耗费的费用是C[i],得到的价值是W[i].求解将那些物品装入背包
 * 	 可使价值总和最大.
 * 样例:
 *	   对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9
 * 	
 * 分析:这是最基本的背包问题,特点是:每种物品仅有一件,可以选择放或不放.
 * 	   用子问题定义状态:即F[i,v]表示前i件物品恰好放入一个容量为v的背包可以获得的最大价值.
 * 	   则其状态转移方程为: F[i,v] = max{F[i-1,v] , F[i-1,v-C[i]]+W[i]}
 * 	   解释一下"将前i件物品放入容量为v的背包中"这个子问题,若只考虑第i件物品的策略(放或不放),那么就可以转化为
 * 	   一个只和前i-1件物品相关的问题.
 * 	   如果不放第i件物品,那么问题转化为"前i-1件物品放入容量为v的背包",价值为F[i-1,v];
 * 	   如果放入第i件物品,那么问题转化为"前i-1件物品放入剩下的容量为v-C[i]的背包中",此时能获得的
 *   最大价值就是F[i-1,v-C[i]]再加上通过放入第i件物品获得的价值W[i];
 *   
 *   伪代码:
 *   F[0,0..V] <—— 0
 *   for i <—— 1 to N
 *   	for v <—— C[i] to V
 *   		F[i,v] <—— max{F[i-1,v] , F[i-1,v-C[i]] + W[i]}
 *   
 *   时间复杂度O(VN),空间复杂度O(VN)
 *
 */
public class BackPack2_125
{
	//m背包大小,A体积,V价值
    public int backPackII(int m, int[] A, int V[]) 
    {
    	int len = A.length;
    	
    	//f[i][m]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
    	int[][] f = new int[len+1][m+1];
    	
//    	Arrays.fill(f[0], 0);
    	
    	for(int i = 1 ; i <= len ; ++i)//前i件物品 第i件物品对应的体积和价值为A[i-1]和V[i-1]
    	{
    		for(int v = m ; v >= 0 ; --v)//体积
    		{
    			if(v >= A[i-1])
    			{
    				f[i][v] = Math.max(f[i-1][v-A[i-1]]+V[i-1], f[i-1][v]);
    			}
    			else
    			{
    				//注意在0~A[i-1]-1的范围上不能是0,要做一下处理
    				//意义是体积v下不能同时放i件物品,即体积为v时同时放i件物品的价值为0;
    				//但是体积为v时不能同时放i件物品,也是可以放下i-1件,i-2件...,它的价值可能比0大
    				f[i][v] = f[i-1][v];
    			}
    		}
    	}
    	
    	return f[len][m];
    }
    
    public static void main(String[] args)
	{
    	BackPack2_125 t125 = new BackPack2_125();
		int[] A1 = {2, 3, 5, 7};//体积
		int[] V1 = {1, 5, 2, 4};//价值
		int m1 = 10;
		int[] A2 = {3,4,5};//体积
		int[] V2 = {4,5,6};//价值
		int m2 = 10;
		t125.backPackII(m1, A1, V1);
		
		System.out.println();
		t125.backPackII(m2, A2, V2);
	}
    
}
