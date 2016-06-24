package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	删除排序链表中的重复数字II [middle]
 *	描述: 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素.
 *
 */
public class RemoveDuplicatesFromSortedList2_113
{
    public static ListNode deleteDuplicates(ListNode head) 
    {
    	if(head == null || head.next == null) return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode prev = dummy;//上一个不是重复元素的结点
    	ListNode curr = head;//游标
    	int count = 0;//记录相连的结点值相同的有几个
    	
    	while(curr != null)
    	{
    		if(curr.val == prev.next.val)
    		{
    			count++;
    		}
    		else
    		{
    			if(count > 1)//是重复元素
    			{
    				prev.next = curr;//删除重复元素
    			}
    			else//不是重复元素
    			{
    				prev = prev.next;//更新上一个不是重复元素的结点
    			}
    			
    			count = 1;
    		}
    		
    		curr = curr.next;
    	}
    	
    	if(count > 1)
    	{
    		prev.next = null;
    	}
    	
    	return dummy.next;
    }
}
