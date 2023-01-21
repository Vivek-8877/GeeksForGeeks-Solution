//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(max(log(a),log(b)));
    // Space Complexity :- O(1);
    public static int minVal(int a, int b) {
        // code here
        int a1 = countSetBit(a);
        int b1 = countSetBit(b);
        int ans = a;
        if(a1==b1) {
            
        } else if(a1<b1) {
            int idx=0;
            while(a1!=b1) {
                if(a%2==0) {
                    a1++;
                    ans+=(1<<idx);
                }
                idx++;
                a/=2;
            }
        } else {
            int idx=0;
            while(a1!=b1) {
                if(a%2==1) {
                    a1--;
                    ans-=(1<<idx);
                }
                idx++;
                a/=2;
            }
        }
        return ans;
    }
    
    public static int countSetBit(int n) {
        int ct=0;
        while(n>0) {
            if(n%2==1) ct++;
            n/=2;
        }
        return ct;
    }
}