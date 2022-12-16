// Problem Link :- https://practice.geeksforgeeks.org/problems/hopscotch4857/1
// Video Solution is Commin Soon :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // Time complexity :- O(1);
    // Space Complexity :- O(1);
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        // code here
        int ans=0;
        if(ty==0) {
            if(isValid(i+1,j,n,m)) ans+=mat[i+1][j];    // down
            if(isValid(i-1,j,n,m)) ans+=mat[i-1][j];    // up
            if(j%2==0) {
                if(isValid(i,j+1,n,m)) ans+=mat[i][j+1];    // right-down
                if(isValid(i,j-1,n,m)) ans+=mat[i][j-1];    // left-down
                if(isValid(i-1,j+1,n,m)) ans+=mat[i-1][j+1];    // right-up
                if(isValid(i-1,j-1,n,m)) ans+=mat[i-1][j-1];    // left-up
            } else {
                if(isValid(i,j+1,n,m)) ans+=mat[i][j+1];    // right-up
                if(isValid(i,j-1,n,m)) ans+=mat[i][j-1];    // left-up
                if(isValid(i+1,j+1,n,m)) ans+=mat[i+1][j+1];    // right-down
                if(isValid(i+1,j-1,n,m)) ans+=mat[i+1][j-1];    // left-down
            }
        } else {
            if(isValid(i+2,j,n,m)) ans+=mat[i+2][j];    // down-down
            if(isValid(i-2,j,n,m)) ans+=mat[i-2][j];    // up-up
            if(isValid(i,j+2,n,m)) ans+=mat[i][j+2];    // directly-front
            if(isValid(i,j-2,n,m)) ans+=mat[i][j-2];    // directly-back
            if(j%2==0) {
                if(isValid(i+1,j+1,n,m)) ans+=mat[i+1][j+1];    // right-down-down
                if(isValid(i-2,j+1,n,m)) ans+=mat[i-2][j+1];    // right-up-up
                if(isValid(i+1,j-1,n,m)) ans+=mat[i+1][j-1];    // left-down-down
                if(isValid(i-2,j-1,n,m)) ans+=mat[i-2][j-1];    // left-up-up
                
                if(isValid(i+1,j+2,n,m)) ans+=mat[i+1][j+2];    // right-down-right-down
                if(isValid(i+1,j-2,n,m)) ans+=mat[i+1][j-2];    // left-down-left-down
                if(isValid(i-1,j+2,n,m)) ans+=mat[i-1][j+2];    // right-up-right-up
                if(isValid(i-1,j-2,n,m)) ans+=mat[i-1][j-2];    // left-up-left-up
            } else {
                if(isValid(i-1,j+1,n,m)) ans+=mat[i-1][j+1];    // right-up-up
                if(isValid(i+2,j+1,n,m)) ans+=mat[i+2][j+1];    // right-down-down
                if(isValid(i-1,j-1,n,m)) ans+=mat[i-1][j-1];    // left-up-up
                if(isValid(i+2,j-1,n,m)) ans+=mat[i+2][j-1];    // left-down-down
                
                if(isValid(i-1,j+2,n,m)) ans+=mat[i-1][j+2];    // right-up-right-up
                if(isValid(i-1,j-2,n,m)) ans+=mat[i-1][j-2];    // left-up-left-up
                if(isValid(i+1,j+2,n,m)) ans+=mat[i+1][j+2];    // right-down-right-down
                if(isValid(i+1,j-2,n,m)) ans+=mat[i+1][j-2];    // left-down-left-down
            }
        }
        return ans;
    }
    public static boolean isValid(int i,int j,int n,int m) {
        if(i<0 || j<0 || i>=n || j>=m) return false;
        return true;
    }
}
