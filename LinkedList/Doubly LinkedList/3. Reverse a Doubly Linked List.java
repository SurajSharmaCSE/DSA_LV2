public static Node reverseDLL(Node  head)
{
    //Your code here
    if(head==null || head.next==null )
    {
        return head;
    }
    
    Node prev=null;
    Node curr=head;
    
    while(curr!=null)
    {
        prev=curr.prev;
        
        curr.prev=curr.next;
        curr.next=prev;
        
        curr=curr.prev;
    }
    return prev.prev;
    
}