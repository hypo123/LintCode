package com.hypo.utils;

/**
 *	比较两个单链表是否节点个数,个节点值都是一样的 
 *
 */
public class CompareLinkedList
{
	public boolean compare(ListNode m , ListNode n)
	{
		if(m == null && n == null) return true;
		if(m == null && n != null) return false;
		if(n == null && m != null) return false;
		
		while(m != null)
		{
			if(n == null)
			{
				return false;
			}
			
			if(m.val != n.val)
			{
				return false;
			}
			
			m = m.next;
			n = n.next;
		}
		
		if(n != null) return false;
		
		return true;
	}
}
