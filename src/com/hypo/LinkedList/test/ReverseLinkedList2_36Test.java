package com.hypo.LinkedList.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.LinkedList.ReverseLinkedList2_36;
import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

public class ReverseLinkedList2_36Test
{
	ReverseLinkedList2_36 t36;
	CreateLinkedList cll; //数组建链表
	CompareLinkedList comll;//链表比较
	
	@Before
	public void setUp() throws Exception
	{
		t36 = new ReverseLinkedList2_36();
		cll = new CreateLinkedList();
		comll = new CompareLinkedList();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testReverseBetween1()
	{
		int[] num1 = {1,2,3,4,5};
		int[] num2 = {1,4,3,2,5};
		
		ListNode root1 = cll.create(num1);
		ListNode root2 = cll.create(num2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, comll.compare(root2 , t36.reverseBetween(root1, 2, 4)));
		
	}
	@Test
	public void testReverseBetween2()
	{
		int[] num1 = {1,2,3,4,5};
		int[] num2 = {1,3,2,4,5};
		
		ListNode root1 = cll.create(num1);
		ListNode root2 = cll.create(num2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, comll.compare(root2 , t36.reverseBetween(root1, 2, 3)));
		
	}
	
	@Test
	public void testReverseBetween3()
	{
		int[] num1 = {1,2};
		int[] num2 = {2,1};
		
		ListNode root1 = cll.create(num1);
		ListNode root2 = cll.create(num2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, comll.compare(root2 , t36.reverseBetween(root1, 1 , 2)));
		
	}
	
	@Test
	public void testReverseBetween4()
	{
		int[] num1 = {1,2,3,4,5};
		int[] num2 = {5,4,3,2,1};
		
		ListNode root1 = cll.create(num1);
		ListNode root2 = cll.create(num2);
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, comll.compare(root2 , t36.reverseBetween(root1, 1 , 5)));
		
	}

}
