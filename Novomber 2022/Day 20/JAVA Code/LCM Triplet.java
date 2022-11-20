//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.lcmTriplets(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(1);
    // Space Complexity :- O(1);
    
    long lcmTriplets(long N) {
        // code here
        if(N<=2) return N;
        if(N%2==0) {
            if(N%3==0) {
                return (N-1)*(N-2)*(N-3);
            } else {
                return (N-1)*(N-3)*(N);
            }
        } else {
            return (N-2)*(N-1)*(N);
        }
    }
}
