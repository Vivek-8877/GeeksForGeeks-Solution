// Problem Link :- https://practice.geeksforgeeks.org/problems/fill-up-buckets3500/1
// Video Solution Link :- https://youtu.be/RKczlfKnlEA

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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] capacity = new int[n];
            for(int i = 0; i < n; i++)
                capacity[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.totalWays(n, capacity);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(1);
    
    public int totalWays(int n, int[] capacity) {
        // code here
        Arrays.sort(capacity);
        int ans = 1;
        final int mod = 1000000007;
        for(int i=0;i<n;i++) {
            ans = (int)((ans*(long)(capacity[i]-i))%mod);
        }
        return ans;
    }
}
