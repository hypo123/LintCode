package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

/**
 *	链表排序 [middle] 
 *	分析一:插入排序 时间复杂度O(n*n)
 *	分析二:归并排序 时间复杂度O(NlogN)
 */
public class SortList_98
{
//	------------插入排序 超时---------------------------
    public ListNode sortList1(ListNode head)
    {  
        if(head == null || head.next == null) return head;
        
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode cusor = head.next;
    	ListNode prevcusor = head;
    	
    	while(cusor != null)
    	{
//    		ListNode curr = head;//BUG,curr应该为dummy.next;因为head可能会变
    		ListNode curr = dummy.next;
    		ListNode prev = dummy;

    		ListNode insert = cusor;
    		
    		cusor = cusor.next;
    		
    		prevcusor.next = cusor;
    		
    		while(curr != cusor && insert.val >= curr.val)
    		{
    			prev = curr;
    			curr = curr.next;
    		}
    		
    		prev.next = insert;
    		insert.next = curr;
    		
    		if(curr == cusor)
    		{
    			prevcusor = insert;
    		}
    	}
    	return dummy.next;        
    }
//    -----------------归并排序-O(NlogN)------------------------
    public ListNode sortList2(ListNode head)
    {  
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //断开链表
        fast = slow;
        slow = slow.next;
        fast.next = null;
        
        //递归分解链表
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(slow);
        
        return merge(l1,l2);
        
    }
    
    public ListNode merge(ListNode l1 , ListNode l2)
    {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null)
        {
            curr.next = l1;
        }
        
        if(l2 != null)
        {
            curr.next = l2;
        }
        
        return dummy.next;
    }
}
