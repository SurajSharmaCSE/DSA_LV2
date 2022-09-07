// leetcode 143

class Solution {
    //reverse function
     public static ListNode reverse(ListNode head)
    {
      // base case
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
      
        while(curr!=null)
        {
            ListNode farward=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=farward;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
     //base candition
        if(head==null || head.next==null)
        {
            return;
        }
        
     //step-1 find mid
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
      // step- 2: reverse second half i.e slow.next to end of linked list
        ListNode nNode=slow.next;
        slow.next=null;
        
        nNode=reverse(nNode);
        
     // step-3: Set Linkege
        ListNode f1=head;
        ListNode f2=nNode;
            
        ListNode c1=null;
        ListNode c2=null;
    // step-4 final 
        while(f2!=null)
        {
            c1=f1.next;
            c2=f2.next;
            
            f1.next=f2;
            f2.next=c1; 
            
            f1=c1;
            f2=c2;
        }
    }
}