// Problem Link :- https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
// Video Link :- https://youtu.be/WuEIJIDAJ-w


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Time Complexity :- O(n.totalSum);
    // 	Space Complexity :- O(n.totalSum);
    
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int totalSum =0;
	    for(int a : arr) totalSum+=a;
	    
	    int[][] dp = new int[n][totalSum+1];
	    for(int i=0;i<dp.length;i++) {
	        for(int j=0;j<dp[i].length;j++) dp[i][j]=-2;
	    }
	    
	    return f(arr,0,totalSum,0,dp);
	}
	
	public static int f(int[] arr,int idx,int totalSum,int sum,int[][] dp) {
	    if(idx>=arr.length) {
	        return Math.abs((totalSum-sum)-sum);
	    }
	    
	    if(dp[idx][sum]!=-2) return dp[idx][sum];
	    
	    int f1 = f(arr,idx+1,totalSum,sum+arr[idx],dp);
	    int f2 = f(arr,idx+1,totalSum,sum,dp);
	    
	    return dp[idx][sum]=Math.min(f1,f2);
	}
}
