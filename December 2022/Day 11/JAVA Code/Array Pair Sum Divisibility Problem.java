// Problem Link :- https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(10^5) or O(n);
    // Time Complexity :- O(10^5) or O(n);
    public boolean canPair(int[] nums, int k) {
        // Code here
        if(nums.length%2==1) return false;
        
        int[] fre = new int[100001];
        for(int num : nums) {
            int num1 = num%k;
            if(fre[(k-num1)%k]!=0) {
                fre[(k-num1)%k]--;
            } else {
                fre[num1]++;
            }
        }
        for(int f : fre) {
            if(f>0) return false;
        }
        return true;
    }
}
