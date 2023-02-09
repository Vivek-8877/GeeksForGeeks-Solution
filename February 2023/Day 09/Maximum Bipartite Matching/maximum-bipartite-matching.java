//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int n = G[0].length;
        int m = G.length;
        int[] visit = new int[n];
        Arrays.fill(visit,-1);
        int ans=0;
        for(int i=0;i<m;i++) {
            boolean[] seen = new boolean[n];
            if(bpm(G,i,seen,visit)) ans++;
        }
        return ans;
    }
    
    public static boolean bpm(int[][] g,int src,boolean[] seen,int[] visit) {
        for(int i=0;i<g[0].length;i++) {
            if(g[src][i]==1 && !seen[i]) {
                seen[i]=true;
                if(visit[i]<0 || bpm(g,visit[i],seen,visit)) {
                    visit[i]=src;
                    return true;
                }
            }
        }
        return false;
    }
}