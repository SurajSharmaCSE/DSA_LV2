class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      // step-1 Create c1,c2 Node pointer and set like this
        ListNode c1=l1;
        ListNode c2=l2;
      // step-2 Create Dummy Node for making ans
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;  // ans i.e p pointer
        
        int carry=0;
     // step-3 Make ans
        while(c1!=null || c2!=null)
        {
            int num1=(c1!=null)?c1.val:0;
            int num2=(c2!=null)?c2.val:0;
            
            int sum=num1+num2+carry;
            
            ans.next=new ListNode(sum%10);
            ans=ans.next;
            
            carry=sum/10;
            
            // increment temp pointer
            if(c1!=null)
            {
                c1=c1.next;
            }
            if(c2!=null)
            {
                c2=c2.next;
            }
        }
       // cheking any caryy bachha to nhi hai
        if(carry>0)
        {
            ans.next=new ListNode(carry);
        }
        
        return dummy.next;
        
    }
}