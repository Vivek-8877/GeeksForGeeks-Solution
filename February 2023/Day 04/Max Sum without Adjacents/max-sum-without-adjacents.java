//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    int findMaxSum(int arr[], int n) {
        // code here
        // int[] dp = new int[n];
        int ans=0,max=0,max1=0;
        // max -> it Store maximum sebsequence sum before of before current index.
	    // max1 -> it store maximum sebsequence sum before current index.
        for(int i=0;i<n;i++) {
            // dp[i]=arr[i];
            // for(int j=0;j<i-1;j++) {
            //     dp[i] = Math.max(dp[i],dp[j]+arr[i]);
            // }
            // ans=Math.max(ans,dp[i]);
            int val = arr[i]+max;
            max = Math.max(max,max1);
            max1 = Math.max(max1,val);
            ans = Math.max(ans,val);
        }
        return ans;
    }
}