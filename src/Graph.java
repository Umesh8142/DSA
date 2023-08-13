import java.io.*;
import java.util.*;



public class Graph{
    class Solution {
        static void dfs(int [][] grid ,int i,int j){
            if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0)
                return;

            grid[i][j]=0;
            dfs(grid,i-1,j-1);
            dfs(grid,i-1,j);
            dfs(grid,i-1,j+1);
            dfs(grid,i,j+1);

            dfs(grid,i+1,j+1);
            dfs(grid,i+1,j);
            dfs(grid,i+1,j-1);
            dfs(grid,i,j-1);
        }
        static int numberOfIslands(int[][] grid, int m, int n){
            //Write your code here
            int count=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid [i][j]==1 ){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;
        }

        public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> edges) {

            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (dfs(i, vis, edges, -1)) return true;
                }
            }
            return false;
        }

        static boolean dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int parent) {
            vis[i] = true;
            for (Integer j : adj.get(i)) {
                if (!vis[j]) {
                    if (dfs(j, vis, adj, i)) return true;

                } else if (parent != j) return true;
            }
            return false;
        }
        static boolean dfs(ArrayList<Integer>[] adj,int curr,boolean []vis,boolean st[] ){
            vis[curr]=true;
            st[curr]=true;
            for(int i=0;i<adj[curr].size();i++){
                int nbr=adj[curr].get(i);
                if(!vis[nbr]){
                    if(dfs(adj,nbr,vis,st))
                    {
                        return true;
                    }
                }
                else if(vis[nbr] && st[nbr]) return true;
            }
            st[curr]=false;
            return false;
        }
    }

}
