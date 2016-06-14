package com.hypo.LinkedList;
import com.hypo.utils.ListNode;
/**
 *	探测链表是否有环
 */

public class CycleLinkedList_T102
{
    public boolean hasCycle(ListNode head) 
    {  
        if(head == null)
        {
            return false;
        }
        
        ListNode slow =  head;//慢指针
        ListNode fast = head.next;//快指针
        
        
        while(slow != null && fast != null)
        {
            if(slow == fast)
            {
                return true;
            }
            
            slow = slow.next;
            
            if(fast.next == null)
            {
                return false;
            }
            fast = fast.next.next;
        }
        
        return false;
    }
}
