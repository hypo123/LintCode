package com.hypo.LinkedList;

import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

/**
 * 翻转链表 II	[middle]
 *	翻转链表中第m个节点到第n个节点的部分 
 *	m，n满足1 ≤ m ≤ n ≤ 链表长度
 *
 */
public class ReverseLinkedList2_36
{
    public ListNode reverseBetween(ListNode head, int m , int n) 
    {
    	if(head == null || head.next == null || m == n) return head;
    	
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	int countnode = -1;
    	
    	ListNode curr = dummy;
    	
    	ListNode prevM = null;
    	ListNode first = null;
    	ListNode last = null;
    	
    	
    	while(curr != null)
    	{
    		++countnode;
    		
    		ListNode now = curr;
    		curr = curr.next;
    		
    		if(countnode == m - 1)
    		{
    			prevM = now;
    			first = now.next;
    			last = now.next;
    		}
    		
    		if(countnode > m && countnode <= n)
    		{
    			last.next = now.next;
    			prevM.next = now;
    			now.next = first;
    			first = now;
    		}
    		
    	}
    	
    	return dummy.next;
    }
    
//    public static void main(String[] args)
//	{
//    	ReverseLinkedList2_36 t36 = new ReverseLinkedList2_36();
//    	CreateLinkedList cll = new CreateLinkedList();
//    	CompareLinkedList comll = new CompareLinkedList();
//    	
//		int[] num1 = {1,2,3,4,5};
//		ListNode root1 = cll.create(num1);
//		
//		cll.print(t36.reverseBetween(root1, 2, 4));
//	}
}
