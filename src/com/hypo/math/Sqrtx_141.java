package com.hypo.math;

/**
 *	问题描述:实现 int sqrt(int x) 函数，计算并返回 x 的平方根
 *
 * 	分析:这个问题用数学的表达方式就是：对于非负整数x，找出另一个非负整数n，其中n满足 n^2 <= x < (n+1)^2。
		所以最直接的方法就是从0到x遍历过去直到找到满足上述条件的n。这个算法的复杂度自然是O(n);
		
		其实要找的数是在0和x之间，而他正巧可以视为一个有序的数组。似乎有可以运用二分查找法的可能。
		再回想二分查找法是要找到满足“与目标数相等”这一条件的数，而这里同样也是要找满足一定条件的数。
		所以就可以用二分法来解这个问题了，让复杂度降为O(logn);
		
		二分查找求平方根
 *
 */
public class Sqrtx_141
{
    public int sqrt(int x)
    {
    	
    	//max的平方应该要小于Integer.MAX_VALUE,不然会溢出
    	//Integer.MAX_VALUE = 2^31-1 = 2147483648 - 1
//    	int max = Integer.MAX_VALUE >> 1 - 1;
    	
//    	int max = (1 << 16) - 1;
    	int max = 46340;
    	
    	if(max * max <= x) return max;
    	
    	int low = 0;
    	int high = max - 1;
    	int mid = 0;
    	
    	while(true)
    	{
    		mid = low + (high - low)/2;
    		
    		if(x < mid * mid)
    		{
    			high = mid - 1;
    		}
    		else if(x >= (mid + 1) * (mid + 1))
    		{
    			low = mid + 1;
    		}
    		else// (mid*mid) <= x < (mid+1)*(mid+1) 找到解
    		{
    			return mid;
    		}
    	}
    }
}
