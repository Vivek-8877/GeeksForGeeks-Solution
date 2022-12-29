//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long ans;
    static long jumpingNums(long X) {
        // code here
        int d = Long.toString(X).length();
        ans=-1;
        f(X,"",d);
        return ans;
    }
    
    
    public static void f(long n,String s,int d) {
        if(s.length()>1) {
            char cn = s.charAt(s.length()-1);
            char cn1 = s.charAt(s.length()-2);
            if(Math.abs(cn-cn1)!=1) return;
        }
        
        if(s.length()!=0) {
            long val = Long.parseLong(s);
            if(val<=n) ans = Math.max(ans,val);
        }
        
        if(s.length()==d) {
            return;
        }
        
        for(int i=0;i<=9;i++) {
            f(n,s+i,d);
        }
    }
    
};