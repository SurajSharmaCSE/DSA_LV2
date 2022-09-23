class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	// Your code here
	   if(x==1)
	   {
	       head=head.next;
	       head.prev=null; // optional hai
	       return head;
	   }
	   
	   Node temp=head;
	   for(int i=1;i<x;i++)
	   {
	       temp=temp.next;
	   }
	   
	   temp.prev.next=temp.next;
	   
	   if(temp.next!=null)
	   {
	       temp.next.prev=temp.prev;
	   }
	   return head;
    }
}
