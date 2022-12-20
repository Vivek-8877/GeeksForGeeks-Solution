// Problem Link :- https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1
// Video Solution Link :- https://youtu.be/KWjBln7Na-M

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int n = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[n];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxDistance(arr, n);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Solution{
    
    // Function for finding maximum and value pair
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        
        int ans=Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++) {
            max = Math.max(max,arr[i]-i);
            min = Math.min(min,arr[i]+i);
            
            int v1 = (arr[i]+i)-min;
            int v2 = max-(arr[i]-i);
            
            ans = Math.max(ans,Math.max(v1,v2));
        }
        
        return ans;
        
    }
    
    
}
