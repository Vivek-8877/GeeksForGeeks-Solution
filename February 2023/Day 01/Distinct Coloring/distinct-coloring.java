//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        long[][] dp = new long[N+1][3];
        for(int i=N-1;i>=0;i--) {
            dp[i][0]=Math.min(dp[i+1][1],dp[i+1][2])+r[i];
            dp[i][1]=Math.min(dp[i+1][0],dp[i+1][2])+g[i];
            dp[i][2]=Math.min(dp[i+1][0],dp[i+1][1])+b[i];
        }
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        // return f(r,g,b,0,-1,Long[N][4]);
    }
    
    // 0 -> Red , 1 -> Green , 2 -> Blue
    public static long f(int[] r,int[] g,int[] b,int idx,int col,Long[][] dp) {
        if(idx>=r.length) return 0;
        if(dp[idx][col+1]!=null) return dp[idx][col+1];
        long ans;
        if(col==0) {
            long f2 = f(r,g,b,idx+1,1,dp)+g[idx];
            long f3 = f(r,g,b,idx+1,2,dp)+b[idx];
            ans = Math.min(f2,f3);
        } else if(col==1) {
            long f1 = f(r,g,b,idx+1,0,dp)+r[idx];
            long f3 = f(r,g,b,idx+1,2,dp)+b[idx];
            ans = Math.min(f1,f3);
        } else if(col==2) {
            long f1 = f(r,g,b,idx+1,0,dp)+r[idx];
            long f2 = f(r,g,b,idx+1,1,dp)+g[idx];
            ans = Math.min(f1,f2);
        } else {
            long f1 = f(r,g,b,idx+1,0,dp)+r[idx];
            long f2 = f(r,g,b,idx+1,1,dp)+g[idx];
            long f3 = f(r,g,b,idx+1,2,dp)+b[idx];
            ans = Math.min(f1,Math.min(f2,f3));
        }
        return dp[idx][col+1]=ans;
    }
}


//{ Driver Code Starts.

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
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends