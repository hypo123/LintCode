package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 * 	删除链表中倒数第n个节点 [easy]
 *	描述:给定一个链表，删除链表中倒数第n个节点，返回链表的头节点
 *		链表中的节点个数大于等于n
 *	分析:先让fast指针先走n步,再开始让slow指针走;
 *		当fast指针走到最后的结点时,slow指针走到倒数第n个结点
 */
public class RemoveNthNodeFromEndOfList_174
{
    ListNode removeNthFromEnd(ListNode head, int n) 
    {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode slow = dummy;
    	ListNode fast = dummy;
    	
    	while(--n >= 0)
    	{
    		fast = fast.next;
    	}
    	
		fast = fast.next;
		
    	while(fast != null)
    	{
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	slow.next = slow.next.next;
    	
    	return dummy.next;
    }
}
