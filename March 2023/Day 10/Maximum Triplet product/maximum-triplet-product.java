//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        // Complete the function
        long mx1=Integer.MIN_VALUE;
        long mx2=mx1,mx3=mx1;
        long mn1=Integer.MAX_VALUE;
        long mn2=mn1;
        for(long val : arr) {
            if(mx1<=val) {
                mx3=mx2;
                mx2=mx1;
                mx1=val;
            } else if(mx2<=val) {
                mx3=mx2;
                mx2=val;
            } else if(mx3<=val) {
                mx3=val;
            }
            
            if(mn1>=val) {
                mn2=mn1;
                mn1=val;
            } else if(mn2>=val) {
                mn2=val;
            }
        }
        // System.out.println(mx1+" "+mx2+" "+mx3+" "+mn1+" "+mn2);
        return Math.max(mn1*mn2*mx1,mx1*mx2*mx3);
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends