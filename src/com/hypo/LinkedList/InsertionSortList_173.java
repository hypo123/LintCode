package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	链表插入排序 [easy] 
 *
 */
public class InsertionSortList_173
{
    public ListNode insertionSortList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode cusor = head.next;
    	ListNode prevcusor = head;
    	
    	while(cusor != null)
    	{
//    		ListNode curr = head;//BUG,curr应该为dummy.next;因为head可能会变
    		ListNode curr = dummy.next;
    		ListNode prev = dummy;

    		ListNode insert = cusor;
    		
    		cusor = cusor.next;
    		
    		prevcusor.next = cusor;
    		
    		while(curr != cusor && insert.val >= curr.val)
    		{
    			prev = curr;
    			curr = curr.next;
    		}
    		
    		prev.next = insert;
    		insert.next = curr;
    		
    		if(curr == cusor)
    		{
    			prevcusor = insert;
    		}
    	}
    	return dummy.next;        
    }
}
