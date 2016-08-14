package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	交换链表当中两个节点	[middle] 
 *	问题:给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点.
 *	          保证链表中节点权值各不相同,如果没有找到对应节点，那么什么也不用做
 *	注意事项:你需要交换两个节点而不是改变节点的权值
 *
 *	样例
	给出链表 1->2->3->4->null ,以及 v1 = 2 ， v2 = 4
	返回结果 1->4->3->2->null。
 */
public class SwapTwoNodesInLinkedList_511
{
    public ListNode swapNodes(ListNode head, int v1, int v2) 
    {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	if(head == null || head.next == null) return head;
    	
    	ListNode curr = head;
    	ListNode prev = dummy;
    	ListNode node1 = null;
    	ListNode node2 =  null;
    	ListNode prev1 = dummy;
    	ListNode prev2 = dummy;
    	ListNode next1 = null;
    	ListNode next2 = null;
    	
    	while(curr != null)
    	{
    		//找到v1值的结点
    		if(curr.val == v1)
    		{
    			prev1 = prev;
    			node1 = curr;
    			next1 = curr.next;
    		}
    		
    		//找到v2值的结点
    		if(curr.val == v2)
    		{
    			prev2 = prev;
    			node2 = curr;
    			next2 = curr.next;
    		}
    		
    		prev = curr;
    		curr = curr.next;
    		
    		//两个结点已找到,退出循环
    		if(node1 != null && node2 != null)
    		{
    			break;
    		}
    	}
    	
    	//两个结点只找到一个或都没找到,找到的两个结点指向同一结点,则不用处理
    	if(node1 == null || node2 == null || node1 == node2)
    	{
    		return dummy.next;
    	}
    	
    	//node1和node2为前后两个相连的结点
    	if(node1 == prev2 || node2 == prev1)
    	{
    		//node1是node2前一个结点
    		if(node1 == prev2)
    		{
    			prev1.next = node2;
    			node2.next = node1;
    			node1.next = next2;
    		}
    		else//node2是node1前一个结点
    		{
    			prev2.next = node1;
    			node1.next = node2;
    			node2.next = next1;
    		}
    	}
    	else//node1和node2不是两个紧挨着的结点
    	{
        	prev1.next = node2;
        	node2.next = next1;
        	prev2.next = node1;
        	node1.next = next2;
    	}
    	
    	return dummy.next;
    }
}
