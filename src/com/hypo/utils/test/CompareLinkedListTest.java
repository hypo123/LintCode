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
		ListNode m1 = CreateLinkedList.create(n1);
		ListNode m2 = CreateLinkedList.create(n2);
		boolean expt1 = true;
		org.junit.Assert.assertEquals("wrong1", expt1, CompareLinkedList.compare(m1,m2));
	}
	
	@Test
	public void testCompare2()
	{
		int[] n3 = {1};
		int[] n4 = {};
		ListNode m3 = CreateLinkedList.create(n3);
		ListNode m4 = CreateLinkedList.create(n4);
		boolean expt2 = false;
		org.junit.Assert.assertEquals("wrong2", expt2, CompareLinkedList.compare(m3,m4));		
	}

	@Test
	public void testCompare3()
	{
		int[] n5 = {1,2,4,5,6};
		int[] n6 = {1,2,4,5};
		ListNode m5 = CreateLinkedList.create(n5);
		ListNode m6 = CreateLinkedList.create(n6);
		boolean expt3 = false;
		org.junit.Assert.assertEquals("wrong3", expt3, CompareLinkedList.compare(m5,m6));		
	}
	@Test
	public void testCompare4()
	{
		int[] n7 = {1,4,5,-1,3,0};
		int[] n8 = {1,4,5,-1,3,0};
		ListNode m7 = CreateLinkedList.create(n7);
		ListNode m8 = CreateLinkedList.create(n8);
		boolean expt4 = true;
		org.junit.Assert.assertEquals("wrong4", expt4, CompareLinkedList.compare(m7,m8));		
	}
	@Test
	public void testCompare5()
	{
		int[] k1 = {1,3,2};
		int[] k11 = {1,2,3};
		ListNode s1 = CreateLinkedList.create(k1);
		SortList_98 t98 = new SortList_98();
		ListNode s111 = t98.sortList1(s1);
		ListNode s11 = CreateLinkedList.create(k11);
		boolean expt5 = true;
		org.junit.Assert.assertEquals("wrong5", expt5, CompareLinkedList.compare(s1,s111));		
	}
}
