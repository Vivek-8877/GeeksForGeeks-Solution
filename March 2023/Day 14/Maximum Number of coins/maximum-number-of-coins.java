//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		return f(arr,0,N-1,new Integer[N][N]);
	}
	
	public static int f(ArrayList<Integer> arr,int lo,int hi,Integer[][] dp) {
	    if(lo>hi) return 0;
	    if(lo==hi) {
	        int ans=arr.get(lo);
	        if(lo-1>=0) ans*=arr.get(lo-1);
	        if(lo+1<arr.size()) ans*=arr.get(lo+1);
	        return ans;
	    }
	    
	    if(dp[lo][hi]!=null) return dp[lo][hi];
	    
	    int ans=0;
	    for(int i=lo;i<=hi;i++) {
	        int val=arr.get(i);
	        if(lo-1>=0) val*=arr.get(lo-1);
	        if(hi+1<arr.size()) val*=arr.get(hi+1);
	        val += (f(arr,lo,i-1,dp) + f(arr,i+1,hi,dp));
	        
	        ans = Math.max(ans,val);
	    }
	    return dp[lo][hi]=ans;
	}
}