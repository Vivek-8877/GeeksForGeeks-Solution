//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
        int r=0,g=0,b=0;
        for(String s : a) {
            char c = s.charAt(0);
            if(c=='R') {
                r++;
            } else if(c=='G') {
                g++;
            } else {
                b++;
            }
        }
        
        if(r==n || g==n || b==n) {
            return n;
        } else if((r%2==0 && g%2==0 && b%2==0) || (r%2==1 && g%2==1 && b%2==1)) {
            return 2;
        } else {
            return 1;
        }
        
        // return f(r,g,b);
        
    }
    
    public static int f(int r,int g,int b) {
        if(r==0 && g==0) return b;
        if(b==0 && g==0) return r;
        if(b==0 && r==0) return g;
        
        int ans = Integer.MAX_VALUE;
        if(r!=0 && g!=0) ans = Math.min(ans,f(r-1,g-1,b+1));
        if(b!=0 && g!=0) ans = Math.min(ans,f(r+1,g-1,b-1));
        if(b!=0 && r!=0) ans = Math.min(ans,f(r-1,g+1,b-1));
        
        return ans;
    }
}
