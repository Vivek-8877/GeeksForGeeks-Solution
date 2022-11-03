// Problem Link :-https://practice.geeksforgeeks.org/problems/array-removals/1
// Video Solution Link :- https://www.youtube.com/watch?v=d_p7QCwqZ6A

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int ans=n;
        for(int i=0;i<n;i++) {
            int j = search(arr,k+arr[i],i,n-1);
            int required_value= i +(n-j-1);
            ans = Math.min(ans,required_value);
        }
        return ans;
    }
    
    public static int search(int[] a,int val,int lo,int hi) {
        int ans=lo;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<=val) {
                lo=mid+1;
                ans = Math.max(ans,mid);
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
}
