package com.hypo.array;

import java.util.ArrayList;

/**
 *  主元素 [easy]
 *	描述:给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 *	分析：多投票算法
 *	时间复杂度O(n) , 空间复杂度O(1)
 */

public class MajorityNumber_46
{
    public int majorityNumber(ArrayList<Integer> nums)
    {
        int n = 0;//候选众数
        int c = 0;//候选众数出现次数
        
        for(int num : nums)
        {
            if(n == num)
            {
                ++c;
            }
            else if(c == 0)
            {
                n = num;
                c = 1;
            }
            else
            {
                --c;
            }
        }
        
        return n;
    }
}
