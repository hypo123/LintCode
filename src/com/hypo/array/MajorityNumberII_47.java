package com.hypo.array;

import java.util.ArrayList;

/**
 *	主元素II [middle]
 *	描述:给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一,且
 *		数组中只有唯一的主元素;
 *	分析:多投票算法 
 *	
 */
public class MajorityNumberII_47
{
    public int majorityNumber(ArrayList<Integer> nums) 
    {
//      步骤一:	选出列表中出现次数最多的两个数
    	int n1 = 0;//候选众数n1
    	int c1 = 0;//候选众数n1出现次数
    	
    	int n2 = 0;//候选众数n2
    	int c2 = 0;//候选众数n2出现次数
    	
    	for(int num : nums)
    	{
    		if(n1 == num)
    		{
    			++c1;
    		}
    		else if(n2 == num)
    		{
    			++c2;
    		}
    		else if(c1 == 0)
    		{
    			n1 = num;
    			c1 = 1;
    		}
    		else if(c2 == 0)
    		{
    			n2 = num;
    			c2 = 1;
    		}
    		else
    		{
    			--c1;
    			--c2;
    		}
    	}
    	
//    步骤二:	判断两个众数出现的次数是否符合要求
    	int times = nums.size() / 3;
    	
    	int count1 = 0;
    	int count2 = 0;
    	
    	for(int n : nums)
    	{
    		if(n == n1)
    		{
    			++count1;
    		}
    		else if(n == n2)
    		{
    			++count2;
    		}
    	}
    
    	if(count1 > times)
    	{
    		return n1;
    	}
    	else
    	{
    		return n2;
    	}
    }
}
