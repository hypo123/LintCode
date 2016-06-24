package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	翻转链表 [easy] 
 *  样例:给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 */
public class ReverseLinkedList_35
{
    public ListNode reverse(ListNode head) 
    {
    	if(head == null || head.next == null) return head;
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode curr = head.next;
    	ListNode first = head;
    	ListNode last = head;
    	
    	while(curr != null)
    	{
    		last.next = curr.next;
    		
    		dummy.next = curr;
    		
    		curr.next = first;
    		
    		first = curr;
    				
    		curr = last.next;
    	}
    	
    	return dummy.next;
    }
}
