// Problem Link :- https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
// Video Solution Link :- 

//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    // Time Complexity :- O(n*m);
    // Space Complexity :- O(n*m);
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length,m=grid[0].length;
        int[][] ans = new int[n][m];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    dq.add(new int[]{i,j});
                    ans[i][j]=0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        
        while(dq.size()>0) {
            int s = dq.size();
            while(s-->0) {
                int[] p = dq.pop();
                int i=p[0],j=p[1];
                if(isValid(i+1,j,n,m,ans)) {
                    dq.add(new int[]{i+1,j});
                    ans[i+1][j]=ans[i][j]+1;
                }
                if(isValid(i,j+1,n,m,ans)) {
                    dq.add(new int[]{i,j+1});
                    ans[i][j+1]=ans[i][j]+1;
                }
                if(isValid(i-1,j,n,m,ans)) {
                    dq.add(new int[]{i-1,j});
                    ans[i-1][j]=ans[i][j]+1;
                }
                if(isValid(i,j-1,n,m,ans)) {
                    dq.add(new int[]{i,j-1});
                    ans[i][j-1]=ans[i][j]+1;
                }
            }
        }
        return ans;
    }
    
    public static boolean isValid(int i,int j,int n,int m,int[][] ans) {
        if(i<0 || j<0 || i>=n || j>=m || ans[i][j]!=-1) return false;
        return true;
    }
}
