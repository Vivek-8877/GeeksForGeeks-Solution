//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        // Code here
        return f(N,K,1,new Integer[N+1][K+1][N+1]);
    }
    public static int f(int sum,int k,int previousElement,Integer[][][] dp) {
        if(k==0 && sum==0) return 1;
        if(k==0 || sum<=0) return 0;
        if(dp[sum][k][previousElement]!=null) return dp[sum][k][previousElement];
        
        int ans=0;
        for(int i=previousElement;i<=sum;i++) {
            ans+=f(sum-i,k-1,i,dp);
        }
        return dp[sum][k][previousElement]=ans;
    }
}