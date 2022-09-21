void addNode(Node head, int pos, int data)
{
    // Your code here
       Node temp=new Node(data);
       
       if(head==null)
       {
           head=temp;
           return;
       }
       
       Node p=head;
       for(int i=1;i<=pos;i++)
       {
           p=p.next;
       }
       
       if(p.next==null)
       {
           p.next=temp;
           temp.prev=p;
       }
       else
       {
           p.next.prev=temp;
           temp.next=p.next;
           
           temp.prev=p;
           p.next=temp;
       }

}