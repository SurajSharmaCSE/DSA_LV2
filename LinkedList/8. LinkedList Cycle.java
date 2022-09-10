//leetcode 141

public class Solution {
    //use extra space
 //     public boolean hasCycle(ListNode head)
 //     {
 //         HashSet <ListNode> hashTable=new HashSet<>();
 //         while(head != null)
 //          {
 //             if(hashTable.contains(head))
 //              {
 //                return true;  
 //              }
           
 //            hashTable.add(head);
 //            head = head.next;
 //          }
         
 //       return false;
         
 //     }
     
     // optimal solution
      public boolean hasCycle(ListNode head)
      {
          //base case
          if(head==null)
          {
              return false;
          }
          ListNode slow=head;
          ListNode fast=head;
          
          while(fast!=null && fast.next!=null)
          {
              fast=fast.next.next;
              slow=slow.next;
              
              if(slow==fast)
              {
                  return true;
              }
          }
          
          return false;
      }
     
 }