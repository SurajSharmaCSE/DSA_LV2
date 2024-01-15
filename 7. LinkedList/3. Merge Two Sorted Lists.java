//leetcode 2
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //base case
        if(l1!=null && l2==null)
        {
            return l1;
        }
        if(l1==null && l2!=null)
        {
            return l2;
        }
    //step-1 create two Pointer node
        ListNode i=l1;
        ListNode j=l2;
    //step-2 Create a dummy Linkedlist Node
        ListNode dummy=new ListNode(-1);
    //step-3 Create K Pointer
        ListNode k=dummy;
    // step-4 compare and make ans
        // main logic
        while(i!=null && j!=null)
        {
            if(i.val<=j.val)
            {
                k.next=i;
                i=i.next;
                k=k.next;
            }
            else
            {
                k.next=j;
                j=j.next;
                k=k.next;
           } 
           
        }
    //step-5 Check if i, j Any not note simply attech the k.next
        k.next=(i!=null)?i:j;
        return dummy.next;
    }
}