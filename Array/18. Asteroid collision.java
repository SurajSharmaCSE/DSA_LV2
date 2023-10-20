class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            int val=arr[i];
            if(val>0)
            {
                st.push(val);
            }
            else
            {
                //1 
                while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(val))
                {
                    st.pop();
                }

                if(st.size()>0 && st.peek()==Math.abs(val))
                {
                    st.pop();
                }
                else if(st.size()>0 && st.peek()>Math.abs(val))
                {
                    // Do Nothing 
                }
                else 
                {
                    st.push(val);
                }
            }
        }
        int ans[]=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=st.pop();
        }

        return ans;
        
    }
}