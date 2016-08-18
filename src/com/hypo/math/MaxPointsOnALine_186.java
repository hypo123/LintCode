package com.hypo.math;

import com.hypo.utils.Point;

/**
 * 最多有多少个点在一条直线上	[middle]
 *
 * 问题:给出二维平面上的n个点，求最多有多少点在同一条直线上
 * 
 * 给出4个点:(1, 2), (3, 6), (0, 0), (1, 3);一条直线上的点最多有3个。
 */

public class MaxPointsOnALine_186
{

	/**
	 *  以边为中心
	 *	暴力枚举法。两点决定一条直线， n 个点两两组合，可以得到 1/2(n(n + 1)) 条直线，对每一条直
		线，判断 n 个点是否在该直线上，从而可以得到这条直线上的点的个数，选择最大的那条直线返回。
		复杂度 O(n3)。 
	 */
    public int maxPoints1(Point[] points) 
    {
    	if(points == null) return 0;
    	int len = points.length;
    	
    	if(len < 3) return len;
    	
    	int result = 0;//最大共线点数
    	
    	for(int i = 0 ; i < len - 1; ++i)
    	{
    		for(int j = i + 1 ; j < len ; ++j)//两两组合
    		{
    			int sign = 0;
    			int a = 0;
    			int b = 0;
    			int c = 0;
    			
    			//1.直线垂直于x轴
    			if(points[i].x == points[j].x)
    			{
    				sign = 1;
    			}
    			else
    			{
    				a = points[j].x - points[i].x;//横坐标相减
    				b = points[j].y - points[i].y;//纵坐标相减
    				
    				//y = kx + b
    				//(x2-x1)y1 = (y2-y1)x1 + C
    				c = a * points[i].y - b * points[i].x;
    			}
    			
    			int count = 0;
    			
    			for(int k = 0 ; k < len ; ++k)
    			{
    				if((sign == 0 && c + b * points[k].x == a * points[k].y) ||
    						sign == 1 && points[k].x == points[j].x)
    				{
    					count++;
    				}
    			}
    			
    			if(count > result)
    			{
    				result = count;
    			}
    			
    		}
    	}
    	return result;
    }
}
