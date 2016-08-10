package com.hypo.utils.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.LinkedList.SortList_98;
import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

public class CompareLinkedListTest
{
	CompareLinkedList comparelinkedlist;
	CreateLinkedList createlinkedlist;
	@Before
	public void setUp() throws Exception
	{
		comparelinkedlist = new CompareLinkedList();
		createlinkedlist = new CreateLinkedList();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCompare1()
	{
		int[] n1 = {};
		int[] n2 = {};
		ListNode m1 = createlinkedlist.create(n1);
		ListNode m2 = createlinkedlist.create(n2);
		boolean expt1 = true;
		org.junit.Assert.assertEquals("wrong1", expt1, comparelinkedlist.compare(m1,m2));
	}
	
	@Test
	public void testCompare2()
	{
		int[] n3 = {1};
		int[] n4 = {};
		ListNode m3 = createlinkedlist.create(n3);
		ListNode m4 = createlinkedlist.create(n4);
		boolean expt2 = false;
		org.junit.Assert.assertEquals("wrong2", expt2, comparelinkedlist.compare(m3,m4));		
	}

	@Test
	public void testCompare3()
	{
		int[] n5 = {1,2,4,5,6};
		int[] n6 = {1,2,4,5};
		ListNode m5 = createlinkedlist.create(n5);
		ListNode m6 = createlinkedlist.create(n6);
		boolean expt3 = false;
		org.junit.Assert.assertEquals("wrong3", expt3, comparelinkedlist.compare(m5,m6));		
	}
	@Test
	public void testCompare4()
	{
		int[] n7 = {1,4,5,-1,3,0};
		int[] n8 = {1,4,5,-1,3,0};
		ListNode m7 = createlinkedlist.create(n7);
		ListNode m8 = createlinkedlist.create(n8);
		boolean expt4 = true;
		org.junit.Assert.assertEquals("wrong4", expt4, comparelinkedlist.compare(m7,m8));		
	}
	@Test
	public void testCompare5()
	{
		int[] k1 = {1,3,2};
		int[] k11 = {1,2,3};
		ListNode s1 = createlinkedlist.create(k1);
		SortList_98 t98 = new SortList_98();
		ListNode s111 = t98.sortList1(s1);
		ListNode s11 = createlinkedlist.create(k11);
		boolean expt5 = true;
		org.junit.Assert.assertEquals("wrong5", expt5, comparelinkedlist.compare(s1,s111));		
	}
}
