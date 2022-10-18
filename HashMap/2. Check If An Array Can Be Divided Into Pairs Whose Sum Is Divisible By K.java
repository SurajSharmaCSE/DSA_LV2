public static void solution(int[] arr, int k){
    //write your code here
    //step-1 create jasjmap and save all frequency of number
    
    HashMap<Integer,Integer> frequency=new HashMap<>();
    
    for(int i=0;i<arr.length;i++)
    {
        int rem=arr[i]%k;
        int freq=frequency.getOrDefault(rem,0);
        frequency.put(rem,freq+1);
    }
    
    //step-2
    for(int i=0;i<arr.length;i++)
    {
        int rem=arr[i]%k;
        if(rem==0)
        {
           int freq=frequency.get(rem);
           if(freq%2!=0)
           {
               System.out.println(false);
               return;
           }
        }
        else if(2*rem==k)
        {
           int freq=frequency.get(rem);
           if(freq%2!=0)
           {
               System.out.println(false);
               return;
           }
        }
        else
        {
            int freq1=frequency.get(rem);
            int freq2=frequency.getOrDefault(k-rem,0);
            
            if(freq1!=freq2)
            {
                System.out.println(false);
                return;
            }
        }
    }
    System.out.println(true);
}