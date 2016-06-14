package com.hypo.LinkedList;

import com.hypo.utils.ListNode;

public class IntersectLinkedList_T380
{
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
    	if(headA == null || headB == null) return null;
    	
    	int lenA = 0;
    	int lenB = 0;
    	
    	ListNode currA = headA;
    	ListNode currB = headB;
    	
    	while(currA != null)
    	{
    		lenA++;
    		currA = currA.next;
    	}
    	while(currB != null)
    	{
    		lenB++;
    		currB = currB.next;
    	}
    	
    	int difflen = lenA - lenB;
    	
    	if(lenB > lenA)
    	{
    		ListNode mid = headA;
    		headA = headB;
    		headB = mid;
    		
    		difflen = lenB- lenA;
    	}
    	
    	while(--difflen >= 0)
    	{
    		headA = headA.next;
    	}
    	
    	while(headA != null)
    	{
    		if(headA == headB)
    		{
    			return headA;
    		}
    		else
    		{
    			headA = headA.next;
    			headB = headB.next;
    		}
    	}
    	
    	return null;
    }  
}
