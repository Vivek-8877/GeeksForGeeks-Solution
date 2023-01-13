//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            int arr[] = new int[(int)(N)];
int i=0;
            String inputLine2[] = read.readLine().trim().split(" ");
            for (i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
            int graph[][] = new int[M][2];
            for (i = 0; i < M; i++) {
                String S1[] = read.readLine().trim().split(" ");
                graph[i][0] = Integer.parseInt(S1[0]);
                graph[i][1] = Integer.parseInt(S1[1]);
            }

            Solution ob = new Solution();
            System.out.println(ob.luckyPermutations(N, M, arr, graph));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long luckyPermutations(int N, int M, int arr[], int[][] graph) {
        // Code here
        HashSet<Integer>[] grap = new HashSet[N+1];
        for(int i=0;i<=N;i++) grap[i] = new HashSet<>();
        for(int[] g : graph) {
            grap[g[0]].add(g[1]);
            grap[g[1]].add(g[0]);
        }
        return f(grap,arr,0,-1,0,new Long[N][N+2][1<<N]);
    }
    long f(HashSet<Integer>[] graph,int[] a,int idx,int p_val,int visit,Long[][][] dp) {
        if(idx>=a.length) return 1;
        
        if(dp[idx][p_val+1][visit]!=null) return dp[idx][p_val+1][visit];
        long ans=0;
        for(int i=0;i<a.length;i++) {
            if((visit&(1<<i))==0) {
                // visit[i]=1;
                if(p_val==-1) {
                    ans+=f(graph,a,idx+1,a[i],visit+(1<<i),dp);
                } else {
                    if(graph[p_val].contains(a[i])) {
                        ans+=f(graph,a,idx+1,a[i],visit+(1<<i),dp);
                    }
                }
                // visit[i]=0;
            }
        }
        return dp[idx][p_val+1][visit]=ans;
    }
}
