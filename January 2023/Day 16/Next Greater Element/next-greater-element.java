//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(stack.size()>0 && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                ans[i]=-1;
            } else {
                ans[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    } 
}