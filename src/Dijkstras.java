import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Dijkstras {
    static class Pair{
        int index,weight;
        Pair(int ind,int w ){
            this.index=ind;
            this.weight=w;
        }
    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int [] dis=new int [V];
        for(int i=0;i<V;i++){
            dis[i]=Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->x.weight-y.weight);
        q.offer(new Pair(S,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int u=curr.index;
            if(dis[u]==Integer.MAX_VALUE){
                dis[u]=curr.weight;

                for(ArrayList<Integer> nbr: adj.get(u)){
                    int v=nbr.get(0);
                    int w=nbr.get(1);

                    q.offer(new Pair(v,dis[u]+w));
                }
            }

        }
        return dis;

    }
    public static int[] dijkstra1(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        boolean [] vis = new boolean[V];
        int dis []= new int [V];
        for(int i=0;i<V;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[S]=0;

        for(int i=0;i<V;i++){

            int u=minInd(dis,vis);
            vis[u]=true;

            for(ArrayList<Integer> a:adj.get(u)){
                int v=a.get(0);
                int w=a.get(1);
                if(!vis[v] && dis[v]>(w+dis[u])){
                    dis[v]=w+dis[u];
                }
            }
        }
         for(int v=0;v<V;v++){
          if(dis[v]==Integer.MAX_VALUE){
           dis[v]=-1;
          }
         }
        return dis;

    }
    static int minInd(int []dis,boolean [] vis){
        int min=Integer.MAX_VALUE, minI=0;
        for(int i=0;i<dis.length;i++){
            if(!vis[i] && min>dis[i]){
                min=dis[i];
                minI=i;
            }
        }
        return minI;
    }
}
