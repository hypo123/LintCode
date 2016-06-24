package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	合并两个排序链表 [easy] 
 *	描述:将两个排序链表合并为一个新的排序链表
 */
public class MergeTwoSortedLists_165
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
    	ListNode dummy = new ListNode(-1);
    	ListNode curr = dummy;
    	
    	while(l1 != null && l2 != null)
    	{
    		if(l1.val <= l2.val)
    		{
    			curr.next = l1;
    			l1 = l1.next;
    		}
    		else
    		{
    			curr.next = l2;
    			l2 = l2.next;
    		}
    		curr = curr.next;
    	}
    	
    	if(l1 != null)
    	{
    		curr.next = l1;
    	}
    	
    	if(l2 != null) 
    	{
    		curr.next = l2;
    	}
    	
    	return dummy.next;
    	
    }
}
