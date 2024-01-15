// Sir ka code

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //base case
        if(head==null || head.next==null)
        {
            return head;
        }
        
        //step-1 create dummy Node 
          ListNode dummy=new ListNode(-1000);
          ListNode p=dummy;
        //step-2 take a curr pointer ans point head
          ListNode curr=head;
        //step-3 make ans
          while(curr!=null)
          {
              while(curr!=null && curr.val==p.val);
              {
                  curr=curr.next;
              }
              
              // add node in own ans node i.e dummy node
              p.next=curr;
              p=p.next;
             // curr tabhi aage badaye jab uske aage wala valu null na ho | wo bekar h
              if(curr!=null)
              {
                  curr=curr.next;
              }
          }
        
        return dummy.next;
        
        
    }
}


// Suraj Sharma Code

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //base case
        if(head==null || head.next==null)
	  {
	      return head;
	  }
	  ListNode prev=head;
	  ListNode curr=head.next;
	  
	  
	  while(curr!=null)
	  {
	      if(prev.val!=curr.val)
	      {
	          prev.next=curr;
	          prev=curr;
	          
	      }
	      if(prev.val==curr.val && curr.next==null)
	      {
	          prev.next=curr.next;
	      }
	      curr=curr.next;
	     
	   }
	return head;
	 
    }
}