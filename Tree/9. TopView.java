 /* Approch By DSA Class*/
 static ArrayList<Integer> topView(Node root)
 {
     ArrayList<Integer> ans=new ArrayList<>();
     if(root==null)
     {
         return ans;
     }
     
     //step-1 
     Queue<pair> Q=new ArrayDeque<>();
     Q.add(new pair(0,root));
     HashMap<Integer,Node> map=new HashMap<>();
     int min=0;
     
     while(Q.size()>0)
     {
         pair p=Q.remove();
         int currhd=p.hd;
         Node node=p.node;
         
         if(map.get(currhd)==null)
         {
             map.put(currhd,node);
         }
         
         if(node.left!=null)
         {
             if(min>currhd-1)
             {
                 min=currhd-1;
             }
             
             Q.add(new pair(currhd-1,node.left));
         }
         if(node.right!=null)
         {
             Q.add(new pair(currhd+1,node.right));
         }
     }
     
     // print ans;
     while(map.containsKey(min))
     {
        ans.add(map.get(min).data);
        min++;
     }
     return ans;
 }