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
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
	        
	        int brr [] = new int[N];
		    line = br.readLine();
		    String[] elem = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            brr[i] = Integer.parseInt(elem[i]);    
	        }
		    
		    Solution obj = new Solution();
		    boolean ans = obj.isFit(arr, brr, N);
        	if(ans == true)
        	    System.out.println("YES");
		    else
		        System.out.println("NO");
		}
	}
}








// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static boolean isFit (int arr[], int brr[], int n) {
        //Complete the function
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<n;i++) if(arr[i]>brr[i]) return false;
        return true;
    }
    
}
