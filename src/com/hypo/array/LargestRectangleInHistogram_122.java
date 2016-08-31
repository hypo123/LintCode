package com.hypo.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 *	直方图最大矩形覆盖	[hard]
 *
 *	给出的n个非负整数表示每个直方图的高度，每个直方图的宽均为1，在直方图中找到最大的矩形面积。

	样例:
	给出 height = [2,1,5,6,2,3]，返回 10 
	      i   =  0,1,2,3,4,5
	分析:
		从左到右处理直方，当 i = 4 时，小于当前栈顶（即直方 3），对于直方 3，无
		论后面还是前面的直方，都不可能得到比目前栈顶元素更高的高度了，处理掉直方 3（计算从直方 3
		到直方 4 之间的矩形的面积，然后从栈里弹出）；对于直方 2 也是如此；直到碰到比直方 4 更矮的直
		方 1.
	
		可以维护一个递增的栈,每次比较栈顶与当前元素;如果当前元素大于栈顶元素,则入栈;
		否则合并现有栈,直到栈顶元素小于当前元素.
		结尾时入栈元素0,重复合并一次;
 *
 */
public class LargestRectangleInHistogram_122
{
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) 
    {
    	//栈,存储height数组下标
    	Deque<Integer> stack = new LinkedList<Integer>();
    	
    	int maxArea = 0;//最大矩形面积
    	
    	for(int i = 0 ; i <= height.length ; )
    	{
    		//如果当前元素大于栈顶元素,则入栈
    		if(stack.isEmpty() || (i != height.length &&  height[stack.peek()] < height[i]) )
			{
    			stack.push(i++);
			}
    		else
    		{
    			//不断从栈中弹出元素,直到栈顶元素小于当前元素.
    			
    			int index = stack.pop();
    			
    			//注意宽度的计算是以i为最右边界的.
    			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
    			
    			maxArea = Math.max(maxArea, height[index]*width);
    		}
    	}
    	
    	return maxArea;
    }
}
