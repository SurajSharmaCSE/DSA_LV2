//leetcode 160

/* ------------------ APPROCH - 1 ---------------------------- */
// public class Solution {
//     public static int size(ListNode head)
//     {
//         int sz=1;
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             temp=temp.next;
//             sz++;
//         }
//         return sz;
//     }
//     //-----------------------------
//     public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
//         //step-1 take pointer t1 and t2
//         ListNode t1=l1;
//         ListNode t2=l2;
//         int size1=size(l1);
//         int size2=size(l2);
        
//         //step-2 find difference
//         int diff=Math.abs(size1-size2);
        
//         // step-2 move pointer at diff
//         if(size1>size2)
//         {
//             for(int i=1;i<=diff;i++)
//             {
//                 t1=t1.next;
//             }
//         }
//         else
//         {
//             for(int i=1;i<=diff;i++)
//             {
//                 t2=t2.next;
//             }
//         }
        
//         //step-3 find intersect point 
//         while(t1!=t2)
//         {
//             t1=t1.next;
//             t2=t2.next;
//         }
        
//         return t1;
//     }
// }

/* Approch - 2 */

  /* ------Aproch - 2 */
  public ListNode getIntersectionNode(ListNode l1, ListNode l2) 
  {
      // step-1 
      ListNode temp=l1;
      //run while loop
      while(temp.next!=null)
      {
          temp=temp.next;
      }
      
      //step-3 make a cycle 
      temp.next=l2;
      
      // Apply Detect Cycle Approch
      ListNode slow=l1;
      ListNode fast=l1;
      while(fast!=null || fast.next!=null)
      {
          fast=fast.next.next;
          slow=slow.next;
          if(slow==fast)
          {
              break;
          }
            
      }
      
      // Apply Cycle Detect-II Approch where the interesect point
      if(fast!=slow)
      {
          return null;
      }
      slow=l1;
      while(slow!=fast)
      {
          slow=slow.next;
          fast=fast.next;
      }
      return slow;
      
  }