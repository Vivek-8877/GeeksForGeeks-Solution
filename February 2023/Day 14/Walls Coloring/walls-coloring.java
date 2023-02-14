//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        return f(colors,0,-1,new Integer[N][4]);
    }
    // 0 -> pink , 1 -> black, 2 -> yellow , -1 -> no color
    int f(int[][] a,int i,int c,Integer[][] dp) {
        if(i>=a.length) return 0;
        if(dp[i][c+1]!=null) return dp[i][c+1];
        int ans=Integer.MAX_VALUE;
        if(c==0) {
            ans=Math.min(ans,f(a,i+1,1,dp)+a[i][1]);
            ans=Math.min(ans,f(a,i+1,2,dp)+a[i][2]);
        } else if(c==1) {
            ans=Math.min(ans,f(a,i+1,0,dp)+a[i][0]);
            ans=Math.min(ans,f(a,i+1,2,dp)+a[i][2]);
        } else if(c==2) {
            ans=Math.min(ans,f(a,i+1,0,dp)+a[i][0]);
            ans=Math.min(ans,f(a,i+1,1,dp)+a[i][1]);
        } else {
            ans=Math.min(ans,f(a,i+1,0,dp)+a[i][0]);
            ans=Math.min(ans,f(a,i+1,1,dp)+a[i][1]);
            ans=Math.min(ans,f(a,i+1,2,dp)+a[i][2]);
        }
        return dp[i][c+1]=ans;
    }
}