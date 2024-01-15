public static ArrayList<Integer> solution(int[] arr, int k) {
    //write your code here

    ArrayList<Integer>ans=new ArrayList<>();
    HashMap<Integer,Integer>map=new HashMap<>();
    
    for(int i=0;i<k-1;i++)
    {
        int freq=map.getOrDefault(arr[i],0);
        map.put(arr[i],freq+1);
    }
    int i=k-1;
    int j=0;
    
    while(i<arr.length)
    {
        int freq=map.getOrDefault(arr[i],0);
        map.put(arr[i],freq+1);
        
        ans.add(map.size());
        
        freq=map.get(arr[j]);
        if(freq==1)
        {
            map.remove(arr[j]);
        }
        else
        {
            map.put(arr[j],freq-1);
        }
        i++;
        j++;
    }
    
    return ans;
}