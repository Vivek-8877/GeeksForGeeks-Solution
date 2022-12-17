// Problem Link :- https://practice.geeksforgeeks.org/problems/break-a-number5913/1
// Video Solution Link :- https://youtu.be/gOvj1bBg-VI

//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.waysToBreakNumber(N));
        }
    }
}
// } Driver Code Ends



class Solution{
    // Time Complexity :- O(1);
    // Space Complexity :- O(1);
    private static final long mod = 1000000007;
    int waysToBreakNumber(int N){
        // code here
        long n = N;
        return (int)((3*n+((n-1)*(n-2))/2)%mod);
    }
}
