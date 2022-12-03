// Problem Link :- https://practice.geeksforgeeks.org/problems/aggressive-cows/1
// Video Solution Link :- 

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Time Complexity :- O(n.log(10^9));
    // Space Complexity :- O(1);
    
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int lo=0,hi=stalls[stalls.length-1];
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(isValid(stalls,k,mid)) {
                ans = Math.max(ans,mid);
                lo=mid+1;
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
    
    public static boolean isValid(int[] a,int k,int dis) {
        int pidx=0;
        for(int i=1;i<a.length;i++) {
            if(a[i]-a[pidx]>=dis) {
                k--;
                pidx=i;
            }
        }
        return k<=1;
    }
    
}
