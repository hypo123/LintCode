package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.LinkedList.SortList_98;
import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

public class SortList_98Test
{
	SortList_98 t98;
	CompareLinkedList comparelinkedlist;
	CreateLinkedList creatlinkedlist;
	@Before
	public void setUp() throws Exception
	{
		t98 = new SortList_98();
		comparelinkedlist = new CompareLinkedList();
		creatlinkedlist = new CreateLinkedList();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSortList1()
	{
		int[] head1 = {2,-1,0};
		ListNode input1 = creatlinkedlist.create(head1);
		ListNode result1 = t98.sortList1(input1);
		int[] num1 = {-1,0,2};
		ListNode correct1 = creatlinkedlist.create(num1);
		boolean expt1 = true;
		org.junit.Assert.assertEquals("wrong1", expt1, comparelinkedlist.compare(result1, correct1));
	}
	
	@Test
	public void testSortList2()
	{
		int[] head2 = {1,-1};
		ListNode input2 = creatlinkedlist.create(head2);
		ListNode result2 = t98.sortList1(input2);
		int[] num2 = {-1,1};
		ListNode correct2 = creatlinkedlist.create(num2);
		boolean expt2 = true;
		org.junit.Assert.assertEquals("wrong2", expt2, comparelinkedlist.compare(result2, correct2));		
	}
	@Test
	public void testSortList3()
	{
		int[] head3 = {1,3,2};
		ListNode input3 = creatlinkedlist.create(head3);
		ListNode result3 = t98.sortList1(input3);
		int[] num3 = {1,2,3};
		ListNode correct3 = creatlinkedlist.create(num3);
		boolean expt3 = true;
		org.junit.Assert.assertEquals("wrong3", expt3, comparelinkedlist.compare(result3, correct3));		
	}
}
