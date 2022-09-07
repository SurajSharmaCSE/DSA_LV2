// leetcode 328

class Solution {
    public ListNode oddEvenList(ListNode head) {
        //base case
        if(head==null || head.next==null)
        {
            return head;
        }
        
    // step-1 create Node Pointer
        ListNode odd=head;
        ListNode od=odd;
        
        ListNode even=head.next;
        ListNode ep=even;
    // step-2 Take a count variable and temp pointer    
        ListNode temp=even.next;
        int count=3;
    // step -3 final make ans 
        while(temp!=null)
        {
            if(count%2==0)
            {
               ep.next=temp;
               ep=ep.next;
            }
            else
            {
                od.next=temp;
                od=od.next;
            }
           // update pointers and variable
            temp=temp.next;
            count++;
        }
       // last attech odd pointer node with even pointer node
        od.next=even;
        ep.next=null;
            
        return head;
    }
}