import java.util.Arrays;

/* adj [][]
       1,2
       2,3
       4,5
       6,7
       5,6
       3,7
 */

class Code
{
    int par[];
    int size[]; // rank arrray

    public int findParent(int u)
    {
        if(par[u]==u)
        {
            return u;
        }

        return par[u] = findParent(par[u]);
    }

    public void merge(int p1, int p2)
    {
        if(size[p1]>size[p2])
        {
            par[p2] = p1;
            size[p1]+=size[p2];
        }
        else
        {
           par[p1] = p2;
           size[p2]+= size[p1];
        }
    }

  
    public void DSU(int V, int [][] adj)
    {
        par= new int[V];
        size=new int[V];

        Arrays.sort(adj, (a.b)->{               // only this sort line add in kruskal ALgo
             return a[0]- b[0];
        });
        

        for(int i=0;i<V;i++)
        {
            size[i]=1;
            par[i]=i;
        }

        for(int edge[]:adj)
        {
            int u = edge[1];
            int v = edge[2];

            int p1 = findParent(u);
            int p2 = findParent(v);

            if(p1!=p2)
            {
                
                merge(p1, p2);
            }
        }


    }

}