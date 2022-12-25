// Problem Link :- https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
// Video Solution Link :- 

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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Time Complexity :- O(n*n);
    // Space Complexity :- O(2*n);
    public long  MissingNo(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        int idx=-1,jdx=-1;
        long d1=0,d2=0,actual_sum=0;
        long[][] sum = new long[n][2];
        // sum[i][0] --> Sum of jth Row   &&  sum[i][1] --> Sum of ith column
        for(int i=0;i<n;i++) {
            boolean isChanged = false;
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    idx=i;
                    jdx=j;
                    isChanged=true;
                }
                if(i==j) {
                    d1+=(long)matrix[i][j];
                }
                if(i==n-j-1) {
                    d2+=(long)matrix[i][j];
                }
                sum[i][0]+=matrix[i][j];
                sum[i][1]+=matrix[j][i];
            }
            if(!isChanged) actual_sum=sum[i][0];
        }
        
        long ans=-1;
        for(int i=0;i<n;i++) {
            if(i!=idx) {
                ans= actual_sum-sum[idx][0];
                break;
            }
        }
        if(ans<=0) return -1;
        
        sum[idx][0]+=ans;
        sum[jdx][1]+=ans;
        if(idx==jdx) d1+=ans;
        if(idx==n-jdx-1) d2+=ans;
        
        for(int i=0;i<n;i++) {
            if(sum[i][0]!=actual_sum || sum[i][1]!=actual_sum) return -1;
        }
        if(d1!=actual_sum || d2!=actual_sum) return -1;
        
        return ans;
        
    }
}
