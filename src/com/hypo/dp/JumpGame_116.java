package com.hypo.dp;

/**
 *	跳跃游戏	[middle] 
 *	给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
	数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
	判断你是否能到达数组的最后一个位置。
	
	样例
	A = [2,3,1,1,4]，返回 true.
	A = [3,2,1,0,4]，返回 false.
 *
 */
public class JumpGame_116
{
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A)
    {
    	int start = 0 ; //当前步骤可跳的最近位置
    	int end = 0;    //当前步骤可跳的最远位置
    	int nextend = 0;//下一步骤可跳的最远位置
    	boolean flag = false;//是否可达数组的最后一个位置
    	
    	while(true)
    	{
    		//寻找下一步骤可跳的最远位置
    		for(int i = start ; i <= end ; ++i)
    		{
    			nextend = Math.max(nextend, A[i]+i);
    		}
    		
    		start = end + 1; //下一步骤可跳的最近位置
    		end = nextend;//下一步骤可跳的最远位置
    		
    		//可跳的最远位置大于等于数组最大下标,表示可以抵达数组的最后一个位置,返回true
    		if(end >= A.length - 1)
    		{
    			flag = true;
    			break;
    		}
    		
    		//下一步骤的最远位置与上一步骤的最远位置一样,表示下一步骤的跳远距离为0;即不能再往后跳了,返回false
    		if(nextend == start - 1)
    		{
    			break;
    		}
    	}
    	
    	return flag;
    }
}
