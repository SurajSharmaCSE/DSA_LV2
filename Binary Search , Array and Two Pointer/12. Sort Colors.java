//Approch 0,1,2 sort Algo Apply

class Solution {
    public static void swap(int arr[],int l,int r)
    {
        int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
        
    }
    public void sortColors(int[] arr) {
        
        int i=0;
        int j=0;
        int k=arr.length-1;
        
        while(i<=k)
        {
            if(arr[i]==0)
            {
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[i]==1)
            {
                i++;
            }
            else
            {
                swap(arr,i,k);
                k--;
            }
        }
        
    }
}