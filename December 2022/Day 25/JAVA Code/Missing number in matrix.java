// Problem Link :- https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
// Video Solution Link :- https://youtu.be/2mFvPNUVu7Q

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
    // Space Complexity :- O(1);
    public long  MissingNo(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        int idx=-1,jdx=-1;
        long expected_sum=-1,required_sum=-1,sum=0;
        for(int i=0;i<n;i++) {
            boolean isChanged = false;
            sum=0;
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    idx=i;
                    jdx=j;
                    isChanged=true;
                }
                sum+=matrix[i][j];
            }
            if(isChanged) {
                required_sum=sum;
            } else {
                expected_sum=sum;
            }
            if(idx!=-1 && jdx!=-1 && required_sum!=-1 && expected_sum!=-1) break;
        }
        
        long ans= expected_sum-required_sum;
        if(ans<=0) return -1;
        
        long d1=0,d2=0,row_sum=0,col_sum=0,val1=0,val2=0;
        for(int i=0;i<n;i++) {
            row_sum=0;
            col_sum=0;
            for(int j=0;j<n;j++) {
                val1=matrix[i][j];
                val2=matrix[j][i];
                if(j==idx && i==jdx) val2=ans;
                if(i==idx && j==jdx) val1=ans;
                row_sum+=val1;
                col_sum+=val2;
                if(i==j) d1+=val1;
                if(i==n-j-1) d2+=val1;
            }
            if(row_sum!=expected_sum || col_sum!=expected_sum) return -1;
        }
        
        if(d1!=expected_sum || d2!=expected_sum) return -1;
        
        return ans;
    }
}
