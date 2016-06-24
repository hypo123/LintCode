package com.hypo.LinkedList;

import java.util.Stack;

import com.hypo.utils.ListNode;

/**
 * 回文链表 [middle]
 * 描述:检查一个链表是否为回文链表
 * 	例1 	1->2->1->null 是回文链表
 * 	例2 	1->2->3->9->3->2->1->null也是回文链表
 * 	例3	1->2->2->1->null也是回文链表
 * 分析:先使用快慢指针找到中间结点;对于总数奇数个结点的链表找到的是中间结点,如例2中的为9的结点
 * 						 对于总数偶数个结点的链表找到的是前半部分的最后一个结点,如例3中第一个为2的结点
 * 
 */
public class PalindromeLinkedList_223
{
	//时间复杂度O(n),空间复杂度O(n)
    public boolean isPalindrome(ListNode head) 
    {
    	if(head == null || head.next == null) return true;
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(head.val);
    	
    	while(fast.next != null && fast.next.next != null)
    	{
    		slow = slow.next;
    		stack.push(slow.val);
    		fast = fast.next.next;
    	}
    	
		if (fast.next != null) // 偶数个结点时,slow是左半边最后一个结点
		{
			slow = slow.next;//BUG
		}
    	while(!stack.isEmpty())
    	{
    		if(stack.pop() != slow.val)
    		{
    			return false;
    		}
    		slow = slow.next;
    	}
    	
    	return true;
    }
}
