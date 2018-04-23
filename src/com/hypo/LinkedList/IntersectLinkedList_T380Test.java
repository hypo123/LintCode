package com.hypo.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.utils.ListNode;

public class IntersectLinkedList_T380Test
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testGetIntersectionNode()
	{
		ListNode headA = new ListNode(6);
		ListNode a2 = new ListNode(7);
		headA.next = a2;
		
		ListNode headB = new ListNode(1);
		ListNode b2 = new ListNode(2);
		headB.next = b2;
		ListNode b3 = new ListNode(3);
		b2.next = b3;
		b3.next = a2;
		
		ListNode expt1 = a2;
		org.junit.Assert.assertEquals("Wrong1", expt1, IntersectLinkedList_T380.getIntersectionNode(headA,headB));
	}

}
