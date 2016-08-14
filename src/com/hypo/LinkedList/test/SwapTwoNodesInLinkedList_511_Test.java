package com.hypo.LinkedList.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hypo.LinkedList.SwapTwoNodesInLinkedList_511;
import com.hypo.utils.CompareLinkedList;
import com.hypo.utils.CreateLinkedList;
import com.hypo.utils.ListNode;

public class SwapTwoNodesInLinkedList_511_Test
{
	SwapTwoNodesInLinkedList_511 t511;
	@Before
	public void setUp() throws Exception
	{
		t511 = new SwapTwoNodesInLinkedList_511();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSwapNodes1()
	{
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {1,4,3,2};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 2, 4); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes2()
	{
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {1,2,3,4};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 2, 5); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes3()
	{
		int[] nums1 = {1,2};
		int[] nums2 = {2,1};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 1, 2); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes4()
	{
		int[] nums1 = {1,2};
		int[] nums2 = {2,1};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 2, 1); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes5()
	{
		int[] nums1 = {1,2};
		int[] nums2 = {1,2};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 5, 6); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes6()
	{
		int[] nums1 = {1};
		int[] nums2 = {1};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 1, 2); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}
	
	@Test
	public void testSwapNodes7()
	{
		int[] nums1 = {1,2,3,4,5,6,7};
		int[] nums2 = {1,2,3,4,5,6,7};
		ListNode root1 = CreateLinkedList.create(nums1);
		ListNode root2 = CreateLinkedList.create(nums2);
		
		ListNode result = t511.swapNodes(root1, 4, 4); 
		
		boolean expt = true;
		
		org.junit.Assert.assertEquals(expt, CompareLinkedList.compare(root2, result));
	}

}
