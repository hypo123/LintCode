package com.hypo.binarysearch;

public class BinarySearch_T14
{
    public static int binarySearch(int[] nums, int target) 
    {
        int start = 0 ;
        int end = nums.length - 1;
        
        int result = -1;
        
        //标准二分查找,找到一个立刻返回;不一定是目标第一次出现的位置.
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if(target < nums[mid])
            {
                end = mid - 1;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                result = mid;
                break;
            }
        }
        
        //继续向前找的第一次出现的下标
        if(result != -1)
        {
            boolean flag = false;
            
            for(int i = result ; i >= 0;)
            {
                if(nums[i] == target)
                {
                    i--;
                }
                else
                {
                    result = i;
                    flag = true;
                    break;
                }
            }
            
            if(flag)
            {
                return result+1;
            }
            else
            {
                return 0;
            }
            
        }
        else
        {
            return -1;            
        }
    }
}
