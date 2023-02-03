//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        return f(arr,0,0,0,-1,-1);
    }
    // 0 -> right , 1 -> down , 2 -> left , 3 -> up;
    static int[] f(int[][] a,int i,int j,int dir,int pi,int pj) {
        if(i<0 || j<0 || i>=a.length || j>=a[i].length) return new int[]{pi,pj};
        int[] ans;
        if(dir==0) {
            if(a[i][j]==0) {
                ans = f(a,i,j+1,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i+1,j,1,i,j);
            }
        } else if(dir==1) {
            if(a[i][j]==0) {
                ans = f(a,i+1,j,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i,j-1,2,i,j);
            }
        } else if(dir==2) {
            if(a[i][j]==0) {
                ans = f(a,i,j-1,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i-1,j,3,i,j);
            }
        } else {
            if(a[i][j]==0) {
                ans = f(a,i-1,j,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i,j+1,0,i,j);
            }
        }
        return ans;
    }
}