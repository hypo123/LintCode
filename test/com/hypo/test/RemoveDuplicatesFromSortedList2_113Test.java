package com.hypo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.LinkedList.RemoveDuplicatesFromSortedList2_113;
import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

public class RemoveDuplicatesFromSortedList2_113Test
{
	RemoveDuplicatesFromSortedList2_113 t113;
	CreateLinkedList cll;
	CompareLinkedList comll;
	@Before
	public void setUp() throws Exception
	{
		t113 = new RemoveDuplicatesFromSortedList2_113();
		cll = new CreateLinkedList();
		comll = new CompareLinkedList();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testDeleteDuplicates1()
	{
		int[] A = {0,1,1,2,3};
		int[] B = {0,2,3};
		ListNode input = cll.create(A);
		ListNode a = t113.deleteDuplicates(input);
		ListNode b = cll.create(B);
		
		boolean expt1 = true;
		org.junit.Assert.assertEquals("wrong1", expt1, comll.compare(a, b));
	}

}
