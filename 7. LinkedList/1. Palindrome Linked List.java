class Solution {
    // reverse function (use in step-2)
    public static ListNode reverse(ListNode head)
    {
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
    public boolean isPalindrome(ListNode head) {
    
        ListNode slow=head;
        ListNode fast=head;
        // step-1 find Mid
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        //step-2 Reverse second half
        slow.next=reverse(slow.next);
        
        // step-3 Increment slow by one step
        slow=slow.next;
        // step-4 check head.data==slow.data
        while(slow!=null)
        {
            if(head.val!=slow.val)
            {
                return false;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
}