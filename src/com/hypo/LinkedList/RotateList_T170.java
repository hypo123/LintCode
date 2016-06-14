package com.hypo.LinkedList;
import com.hypo.utils.ListNode;

public class RotateList_T170
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = head;
        ListNode last = null;//链表最后一个非null结点
        int len = 0;//链表长度
        
        while(curr != null)
        {
            len++;
            last = curr;
            curr = curr.next;
        }
        
        curr = head;
        
        int step = len - k % len;
        
        ListNode cusor = head;
        
        while(--step > 0)
        {
            cusor = cusor.next;
        }
        
        last.next = dummy.next;        
        dummy.next = cusor.next;
        cusor.next = null;
        
        return dummy.next;
    }
}
