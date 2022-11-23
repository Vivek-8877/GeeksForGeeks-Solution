// Problem Link :- https://practice.geeksforgeeks.org/problems/maximum-sum-lcm3025/1
// Vidoe Solution Link :- https://youtu.be/5S-WXPv0peg

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.maxSumLCM(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    // Time Complexity :- O(sqrt(n));
    // Space Complexity :- O(1);
    
    static long maxSumLCM(int n) {
        // code here
        long ans=0;
        for(long i=1;i*i<=n;i++) {
            if(n%i==0) {
                ans+=i;
                if(i!=n/i) ans+=(n/i);
            }
        }
        return ans;
    }
}
