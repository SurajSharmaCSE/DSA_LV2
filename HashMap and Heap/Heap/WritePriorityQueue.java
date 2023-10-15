import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    
    public void swap(int i,int j)
    {
        int ith=data.get(i);
        int jth=data.get(j);
        
        data.set(i,jth);
        data.set(j,ith);
    }
    
    public void upheapify(int ci)
    {
        //base case
        if(ci==0)
        {
            return;
        }
        int pi=(ci-1)/2
        
        if(data.get(ci)<data.get(pi))
        {
            swap(ci,pi);
            upheapify(pi);
        }
    }
    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1)
    }

    public int remove() {
      // write your code here
      if(data.size()==0)
      {
        System.out.println("Underflow");
        return -1;
      }
      swap(0,data.size()-1);
      int value=data.remove(data.size()-1);
      downheapify(0);

      return value;
    }
    public void downheapify(int pi)
    {
        int lci = 2*pi+1;
        int rci = 2*pi+2;

        int minIdx=pi;

        if(lci<data.size() && data.get(minIdx)> data.get(lci));
        {
            minIdx=lci;
        }
        if(rci < data.size() && data.get(minIdx)>data.get(rci))
        {
            minIdx=rci;
        }
        if(minIdx!=pi)
        {
            swap(minIdx,pi);
            downheapify(minIdx);
        }
    }

    public int peek() {
      // write your code here
      if(data.size()==0)
      {
          System.out.println("underflow");
          return;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}