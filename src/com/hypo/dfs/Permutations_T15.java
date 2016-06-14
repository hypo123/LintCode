package com.hypo.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *	全排列	[middle]
 */
public class Permutations_T15
{
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) 
    {
    	ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();//结果
    	
    	if(nums == null || nums.size() == 0) return permutations; 
    	
    	List<Integer> path = new ArrayList<Integer>();//一种排列
    	
    	dfs(permutations , path , nums);
    	
    	return permutations;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> permutations , List<Integer> path,
    		ArrayList<Integer> nums)
    {
    	if(path.size() == nums.size())//收敛条件
    	{
    		permutations.add(new ArrayList<Integer>(path));
    	}
    	
    	for(Integer n : nums)
    	{
    		if(!path.contains(n))
    		{
    			path.add(n);
    			dfs(permutations , path , nums);
    			path.remove(path.size()-1);//回溯
    		}
    	}
    }
    
    
    //test
    public static void main(String[] args)
	{
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	nums.add(1);
    	nums.add(2);
    	nums.add(3);
    	
    	Permutations_T15 t15 = new Permutations_T15();
    	
    	ArrayList<ArrayList<Integer>> permutations = t15.permute(nums);
    	
    	for(int i = 0 ; i < permutations.size(); i++)
    	{
    		ArrayList<Integer> mid = permutations.get(i);
    		
    		for(Integer m : mid)
    		{
    			System.out.print(m + " ");
    		}
    		System.out.println();
    	}
	}
}
