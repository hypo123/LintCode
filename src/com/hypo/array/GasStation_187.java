package com.hypo.array;


/**
 *	加油站 [middle]
 *	只要加油站的油量总和大于总的油量消耗,则总可以找到一个起始点,
 *	从该起始点首发可完成环路绕行一周.
 */
public class GasStation_187
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
    	int total = 0;//跑一圈剩余油量
    	int sum = 0;
    	int start = -1;
    	
    	for(int i = 0 ; i < gas.length ; i++)
    	{
    		total += gas[i] - cost[i];
    		
    		sum += gas[i] - cost[i];
    		
    		//sum<0说明要重新寻找起始点
    		if(sum < 0)
    		{
    			start = i;
    			sum = 0;//sum清0,重新开始计算
    		}
    	}
    	
    	//只要总的剩余油量>0则可以总可以完成环路上绕一圈
    	return total >= 0 ? start + 1 : -1;
    }
}
