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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(1);
    long solve(long n) {
        long a1 = n;
        int include=0;
        for(long i=n-1;i>=1;i--) {
            long g = gcd(a1,i);
            if(g==1) {
                a1*=i;
                include++;
            }
            if(include==3) return a1;
        }
        return a1;
    }
    
    long maxGcd(int N) {
        // code here
        return Math.max(solve(N),solve(N-1));
    }
    
    long gcd(long a,long b) {
        if(a==0) return b;
        return gcd(b%a,a);
    }
}