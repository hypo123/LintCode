package com.hypo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数字组合 [middle]
 * 深搜
 */
public class CombinationSum_T135
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
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
        
        for(int i = index ; i < candidates.length; ++i)
        {
        	//剪枝
            if(gap < candidates[i]) break;
            
            path.add(candidates[i]);
            
            //数组中元素可以重复使用,这儿传入的下一次的开始下标还是i,而不是i+1;
            dfs(gap - candidates[i] , i , res , path , candidates);
            
            path.remove(path.size()-1);//回溯
        }
    }
}
