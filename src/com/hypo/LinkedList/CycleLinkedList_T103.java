package com.hypo.LinkedList;

import java.util.HashMap;

/**
 *	探测链表是否有环，如果有环输出该环的起始结点. 
 */
class ListNode 
{
	int val;
	ListNode next;

	ListNode(int val)
	{
		this.val = val;
		this.next = null;
	}
 }

public class CycleLinkedList_T103
{
    public ListNode detectCycle(ListNode head) 
    {  
        HashMap<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        
        ListNode result = null;
        
        if(head == null)
        {
            return result;
        }
        
        ListNode slow =  head;//慢指针
        map.put(slow,1);
        ListNode fast = head.next;//快指针
        
        
        while(slow != null && fast != null)
        {
            if(map.containsKey(slow))
            {
                map.put(slow, map.get(slow)+1);
            }
            else
            {
                map.put(slow,1);
            }
            
            if(map.containsKey(fast))
            {
            	//第三次访问到该结点则该结点是环的起始结点.
                if(map.get(fast) == 2)
                {
                    return result = fast;
                }
                else
                {
                    map.put(fast, map.get(fast)+1);
                }
            }
            else
            {
                map.put(fast, 1);
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return result;
    }
}
