import java.util.* ;
import java.io.*; 
public class Solution {
	/*
	 Approch1- Using Sorting
	 1. Sort the given Array 
	 2. take a another Array ans[]
	 3. and fill like this
	    if(i%2==0)
		{
			ans[i] = arr[i];
		} 
		else
		{
			ans[i] = arr[n-1-i];
		}
		return ans;
	    
	*/
	public static int[] Approch1(int arr[])
	{
		int n = arr.length;
		int ans[] = new int[n];

		Arrays.sort(arr);
		int i=0, j=arr.length-1, idx=0;
		while(i<=j)
		{
           if(idx%2==0)
		   {
			   ans[idx] = arr[i];
			   i++;
		   }
		   else
		   {
			   ans[idx] = arr[j];
			   j--;
		   }
		   idx++;
		}
		return ans;
	}

	/*
	Approch-2:
	1. Travese on Array using for loop i=0 to i<n-1, and alos take idx=0
	2. if(i even  && arr[idx+1]<arr[idx])
	   {
		   swap(arr,idx,idx+1)
	   }
	3. if(i odd  && arr[idx+1]>arr[idx])
	   {
		   swap(arr,idx,idx+1)
	   }
	*/

	public static int[] Approch2(int arr[])
	{
		int n = arr.length;
		for(int i=0;i<n-1;i++)
		{
			if(i%2==0)
			{
				if(arr[i+1]<arr[i])
				  swap(arr,i,i+1);
			}
			else
			{
				if(arr[i+1]>arr[i])
				  swap(arr,i,i+1);
			}
		}
		return arr;
	}
	public static int[] wiggleSort(int n, int[] arr) {
		// Write your code here.
		// return Approch1(arr);
		return Approch2(arr);
	}

	public static void swap(int arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}