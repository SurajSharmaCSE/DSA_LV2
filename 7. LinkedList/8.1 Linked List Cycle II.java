// leetcode 142

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        //base case
        if(head==null || head.next==null)
        {
            return null;
        }
        
        // step 1 Detect cycle in Linkedlist
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast)
            {
                break;
            }
        }
        
        //
        if(fast!=slow)
        {
            return null;
        }
        //step-2
        slow=head;
        //step-3
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;
        
        
        
    }
}