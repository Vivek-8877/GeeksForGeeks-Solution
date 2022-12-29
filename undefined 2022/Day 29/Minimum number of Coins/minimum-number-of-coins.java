//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    
    static List<Integer> minPartition(int N)
    {
        // code here
        final int[] coins = new int[]{1,2,5,10,20,50,100,200,500,2000};
        int[][] dp = new int[N+1][2];
        // for(int i=0;i<=N;i++) {
        //     dp[i][0]=-2;
        // }
        // f(N,coins,dp);
        
        for(int i=1;i<=N;i++) {
            dp[i][0]=Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i-coin>=0) {
                    if(dp[i-coin][0]+1<dp[i][0]) {
                        dp[i][0]=dp[i-coin][0]+1;
                        dp[i][1]=coin;
                    }
                } else {
                    break;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(N>0) {
            ans.add(dp[N][1]);
            N-=dp[N][1];
        }
        Collections.sort(ans,(a,b) -> (b-a));
        return ans;
    }
    
    public static int[] f(int n,int[] coins,int[][] dp) {
        if(n==0) return new int[]{0,0};
        if(n<0) return new int[]{-1,-1};
        if(dp[n][0]!=-2) return dp[n];
        
        int ans = Integer.MAX_VALUE;
        int c =0;
        for(int coin : coins) {
            int[] val = f(n-coin,coins,dp);
            if(val[0]!=-1) {
                if(ans>val[0]+1) {
                    ans = val[0]+1;
                    c= coin;
                }
            }
        }
        
        return dp[n]=new int[]{ans,c};
    }
}