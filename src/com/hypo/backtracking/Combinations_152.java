package com.hypo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  组合 [middle]
 *	问题:组给出两个整数n和k，返回从1......n中选出的k个数的组合 
 *	样例
	例如 n = 4 且 k = 2
	返回的解为：
	[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 */
public class Combinations_152
{
    public List<List<Integer>> combine(int n, int k) 
    {
    	if(n < k) return null;
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	List<Integer> path = new ArrayList<Integer>();
    	
    	dfs(n , 1 , k , 1 , result , path);
    	
    	return result;
    }

    /**
     * @param n		参数n
     * @param index 当前需要处理1到n中的第index个数
     * @param k		参数k
     * @param step  当前需要处理1到k个步骤中的第step步
     * @param result
     * @param path	
     */
    private void dfs(int n , int index ,int k , int step , List<List<Integer>> result , List<Integer> path)
    {
    	if(step == k + 1)//找到正确解
    	{
    		result.add(new ArrayList<Integer>(path));
    	}
    	
    	if(step > k + 1)//剪枝,步骤超过了
    	{
    		return;
    	}
    	
    	if((k - step) > (n - index))//剪枝,n中剩余数不够完成步骤
    	{
    		return;
    	}
    	
    	for(int i = index ; i <= n ; ++i)
    	{
    		path.add(i);
    		
    		//递归处理
    		dfs(n , i + 1, k , step + 1 , result , path);
    		
    		//回溯
    		path.remove(path.size() - 1);
    	}
    }
    
//    test
//    public static void main(String[] args)
//	{
//    	Combinations_152 t152 = new Combinations_152();
//    	
//    	int n = 3;
//    	int k = 2;
//    	
//    	List<List<Integer>> result = t152.combine(n, k);
//    	
//    	for(List<Integer> mid : result)
//    	{
//    		System.out.print("[");
//    		for(int num : mid)
//    		{
//    			System.out.print(num + " ");
//    		}
//    		System.out.print("]");
//    	}
//	}
}
