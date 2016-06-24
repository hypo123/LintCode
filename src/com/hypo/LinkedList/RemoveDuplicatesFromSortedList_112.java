package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 * 删除排序链表中的重复元素 [easy]
 * 描述:给定一个排序链表，删除所有重复的元素每个元素只留下一个
 * 分析:start指针总是指向链表中相连的相同值的结点的第一个
 * 	       一旦遍历到与当前start结点不同值的新结点,则将当前start结点
 * 	        直接指向该新结点,并将新结点设置为新的start结点.
 */
public class RemoveDuplicatesFromSortedList_112
{
    public static ListNode deleteDuplicates(ListNode head)
    { 
    	if(head == null || head.next == null) return head;
    	ListNode start = head;
    	ListNode curr = head.next;
    	
    	while(curr != null)
    	{
    		if(curr.val != start.val)
    		{
    			start.next = curr;
    			start = curr;
    		}
    		
    		curr = curr.next;
    	}
    	
    	start.next = null;
    	
    	return head;
    }  
}
