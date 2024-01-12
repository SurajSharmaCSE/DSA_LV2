import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void resize()
    {
        LinkedList<HMNode> oldBucket[]=buckets;

        buckets = new LinkedList[2*oldBucket.length];

        for(int i=0;i<buckets.length;i++)
        {
            buckets[i]=new LinkedList<>();
        }
        size=0;
        for(int i=0;i<oldBucket.length;i++)
        {
            LinkedList<HMNode> ll=oldBucket[i];

            for(int j=0;j<ll.size();j++)
            {
                put(ll.get(j).key,ll.get(j).value);
            }
        }


    }

    public void put(K key, V value) {
      // write your code here
      // key --> Hash_Funtion --> HashCode ---> Entry yes/no

      int bi=hashFunction(key);      // it's retunr buket index 
      int di=findWithInBucket(key,bi);  // it's return -1 or index 

      // if -1
      if(di==-1)
      {
        buckets[bi].add(new HMNode(key, value));
        size++;
      }
      else
      {
        buckets[bi].get(di).value=value;
      }
      double lambda = (double)size/(double)(buckets.length);
      if(lambda>2.0)
      {
        resize();
      }
    }
    public int hashFunction(K key)
    {
        return Math.abs(key.hashCode())%buckets.length;
    }
    public int findWithInBucket(K key,int bi)
    {
        for(int i=0;i<buckets[bi].size();i++)
        {
            K key1=buckets[bi].get(i).key;
            if(key1.equals(key))
            {
                return i;
            }
        }
        return -1;
    }

    public V get(K key)  {
      // write your code here
      int bi=hashFunction(key);
      int di=findWithInBucket(key,bi);

      if(di==-1)
      {
        //means key dosn't exist
        return null;
      }
      else
      {
          return buckets[bi].get(di).value;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bi=hashFunction(key);
      int di=findWithInBucket(key,bi);

      if(di==-1)
      {
        //means key dosn't exist
        return false;
      }
      else
      {
          return true;
      }

    }

    public V remove(K key) {
      // write your code here
      int bi=hashFunction(key);
      int di=findWithInBucket(key,bi);

      if(di==-1)
      {
        //means key dosn't exist
        return null;
      }
      else
      {
          V val=buckets[bi].get(di).value;
          buckets[bi].remove(val);
          size--;
          return val;
      }
    }

    public ArrayList<K> keyset() {
      // write your code here
      ArrayList<K> ans=new ArrayList<>();
      
      for(int i=0;i<buckets.length;i++)
      {
        LinkedList<HMNode> ll =buckets[i];
        for(int j=0;i<ll.size();j++)
        {
            ans.add(ll.get(j).key);
        }
      }

      return ans;
    }

    public int size() {
      // write your code here
      return this.size();
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}