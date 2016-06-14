package com.hypo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定数组中可能有相同值的元素，因此该题主要是考虑怎样去重
 * 
 *  深搜 ， 回溯
 */
public class CombinationSum2_T153
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(candidates == null || candidates.length == 0) return res;
        
        List<Integer> path = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        dfs(target , 0 , res , path , candidates);
        
        return res;
    }
    
    private void dfs(int gap , int index ,List<List<Integer>> res , List<Integer> path ,
    int[] candidates)
    {
        if(gap == 0)//收敛条件
        {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        int previous = -1;//前一轮使用的值.
        
        for(int i = index ; i < candidates.length; ++i)
        {
        	//剪枝
            if(gap < candidates[i]) break;
            
            //去重;如果上一轮循环中已经使用candidates[i]的值，则这一轮不能重复使用
            if(previous == candidates[i]) continue;
            
            //更新previous的值
            previous = candidates[i];
            
            path.add(candidates[i]);
            
            //数组中元素不能重复使用,这儿传入的下一次的开始下标还是i+1,而不是i;
            dfs(gap - candidates[i] , i+1 , res , path , candidates);
            
            path.remove(path.size()-1);//回溯
        }
    }
}
