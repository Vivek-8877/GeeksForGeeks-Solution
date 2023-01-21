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
    public static int minVal(int a, int b) {
        // code here
        byte[] a1 = decimalToBinary(a);
        byte[] b1 = decimalToBinary(b);
        
        int ans = a;
        if(a1[32]==b1[32]) {
            
        } else if(a1[32]<b1[32]) {
            for(int i=0;i<32 && a1[32]!=b1[32];i++) {
                if(a1[i]==0) {
                    ans+=(1<<i);
                    a1[32]++;
                }
            }
        } else {
            for(int i=0;i<32 && a1[32]!=b1[32];i++) {
                if(a1[i]==1) {
                    ans-=(1<<i);
                    a1[32]--;
                }
            }
        }
        return ans;
    }
    public static byte[] decimalToBinary(int n) {
        byte[] binary = new byte[33];
        for(int i=0;i<32;i++) {
            if((n&(1<<i))!=0) {
                binary[32]++;
                binary[i]=1;
            }
        }
        return binary;
    }
}