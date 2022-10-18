public static int solution(String str) {
    // write your code here
    
   HashMap<Character,Integer>map=new HashMap<>();
   int ans=0,i=-1,j=-1;
   
   while(true)
   {
       boolean flag1=false;
       boolean flag2=false;
       
       //aquire
       while(i<str.length()-1)
       {
           flag1=true;
           i++;
           char ch=str.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
           
           if(map.get(ch)==2)
           {
               break;
           }
           else
           {
               //make ans
               int len=i-j;
               if(len>ans)
               {
                   ans=len;
               }
           }
       }
       
       //release
       while(j<i)
       {
           flag2=true;
           j++;
           char ch=str.charAt(j);
           map.put(ch,map.get(ch)-1);
           
           if(map.get(ch)==1)
           {
               break;
           }
       }
       if(flag1==false && flag2==false){break;}
   }
   return ans;
}
