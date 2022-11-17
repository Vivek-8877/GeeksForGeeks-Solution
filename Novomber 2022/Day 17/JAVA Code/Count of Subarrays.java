// Problem Link :- https://practice.geeksforgeeks.org/problems/count-of-subarrays5922/1
// Video Solution Link :- https://youtu.be/cluFktVZPhA

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            long ans = new Solution().countSubarray(arr, n, k);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // 	Time Complexity :- O(n);
    // 	Space Complexity :- O(1);
    
    long countSubarray(int arr[], int n, int k) {

        // code here
        long ans = (long)n*(n+1)/2;
        long l =0;
        for(int ar : arr) {
            if(ar<=k) {
                l++;
            } else {
                ans-=(l*(l+1)/2);
                l=0;
            }
        }
        ans-=(l*(l+1)/2);
        return ans;
    }
}
