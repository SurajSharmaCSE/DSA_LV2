// solution video - > https://www.youtube.com/watch?v=1QybAZMCYhA&t=37s
class Solution {
    public List<Integer> Approch_1(int[] nums)  
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>(); // Changed to List<Integer>

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i]; // Get the current element
            if (map.containsKey(num)) {
                int freq = map.get(num);
                freq++;
                map.put(num, freq);
            } else {
                map.put(num, 1);
            }
        }

        // Find elements that appear more than n/3 times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > n / 3) {
                ans.add(key);
            }
        }

        return ans;
    }
    public int FreqCount(int val, int[] nums)
    {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == val){count++;}
        }
        return count;

    }
    public List<Integer> Approch_2(int[] nums)
    {
      //step1 . take 4 varibale
       int val1 = nums[0];
       int count1 = 1;

       int val2 = nums[0];
       int count2 = 0 ;
      //step2. find potantial element 
       for(int i=1;i<nums.length;i++)
       {
           if(nums[i] == val1)
           {
               count1++;
           }
           else if(nums[i] == val2)
           {
               count2++;
           }
           else
           {
               if(count1 == 0)
               {
                   val1 = nums[i];
                   count1 = 1;
               }
               else if(count2 == 0)
               {
                   val2 = nums[i];
                   count2 = 1;
               }
               else
               {
                   count1--;
                   count2--;
               }
           }
       }

       //step3. check val1 and val2 is our mejority element or not 
       List<Integer> ans = new ArrayList<>();
       int n = nums.length;
       if(FreqCount(val1,nums)>n/3)
       {
           ans.add(val1);
       }
       if( val2!=val1 && FreqCount(val2,nums)>n/3)
       {
           ans.add(val2);
       }

       return ans;
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans1 = Approch_1(nums);  //TC - O(nlogn), SC - O(n)
        List<Integer> ans2 = Approch_2(nums);  //TC - O(n), SC - O(1)    -> optimal solution 

        return ans2;
       
    }
}