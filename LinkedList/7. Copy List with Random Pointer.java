// leetcode - 138
class Solution {
    public Node copyRandomList(Node head) {
        //base case
        if(head==null)
        {
            return null;
        }
        
        //step-1 and 2,3 Create Dummy Linkedlist, pointer p, HashMap and set linkthese
        HashMap<Node,Node>map=new HashMap<>();
        Node curr=head;
        Node nNode=new Node(-1);
        Node p=nNode;
        
        // step -4 Compy all Node and create our dummy linkedlist i.e compleat dummy linkedlist
        while(curr!=null)
        {
            Node node=new Node(curr.val);
            
            p.next=node;
            p=p.next;
            
            map.put(curr,node);
            curr=curr.next;
        }
        
        //step-5 Make ans
        nNode=nNode.next;
        curr=head;
        p=nNode;
        
        while(curr!=null)
        {
            // get random of original linkedlist
            Node Random=curr.random;
            
            if(Random==null)
            {
                p.random=null;
            }
            // get random value or addrese from map
            else
            {
                Node value=map.get(Random);
                // asign random value of oring al linkedlist to dummy linked list
                p.random=value;
            }
            
            curr=curr.next;
            p=p.next;
        }
        return nNode;
        
    }
}