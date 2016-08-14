package com.hypo.utils;

//由给定的一维数组建链表
public class CreateLinkedList
{
	public static ListNode create(int[] nums)
	{
		if(nums.length < 1) return null;
		
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		
		for(int i = 0 ; i < nums.length ; ++i)
		{
			ListNode newnode = new ListNode(nums[i]);
			prev.next = newnode;
			
			prev = newnode;
		}
		return dummy.next;
	}
	
	public static void print(ListNode node)
	{
		while(node != null)
		{
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	//test
//	public static void main(String[] args)
//	{
//		CreateLinkedList cll = new CreateLinkedList();
//		
//		int[] nums1 = {};
//		int[] nums2 = {1};
//		int[] nums3 = {1,2};
//		int[] nums4 = {0,1,3,4,4,5,6};
//		int[] nums5 = {1,2,3,4,5};
//		
//		ListNode n1 = cll.create(nums1);
//		ListNode n2 = cll.create(nums2);
//		ListNode n3 = cll.create(nums3);
//		ListNode n4 = cll.create(nums4);
//		ListNode n5 = cll.create(nums5);
//		
//		cll.print(n1);
//		cll.print(n2);
//		cll.print(n3);
//		cll.print(n4);
//		cll.print(n5);
//	}
}
