//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public int countVertex(int N, int[][] edges){
        // code here
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return Math.min(f(graph,1,0,-1,new Integer[N+1][2]),f(graph,1,1,-1,new Integer[N+1][2])+1);
    }
    
    public static int f(ArrayList<Integer>[] graph,int src,int isLighted,int prnt,Integer[][] dp) {
        if(dp[src][isLighted]!=null) return dp[src][isLighted];
        int ans=0;
        for(int nbr : graph[src]) {
            if(nbr!=prnt) {
                if(isLighted==0) {
                    int f1 = f(graph,nbr,1,src,dp);
                    ans+=f1+1;
                } else {
                    int f0 = f(graph,nbr,0,src,dp);
                    int f1 = f(graph,nbr,1,src,dp);
                    ans+=Math.min(f0,f1+1);
                }
            }
        }
        return dp[src][isLighted]=ans;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends