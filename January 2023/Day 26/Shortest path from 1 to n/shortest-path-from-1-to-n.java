//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minStep(int n){
        //complete the function here
        if(n==1) return 0;
        if(n==2 || n==3) return 1;
        int ans;
        if(n%3==0) {
            ans=minStep(n/3)+1;
        } else if(n%3==1) {
            ans=minStep(n/3)+2;
        } else {
            ans=minStep(n/3)+3;
        }
        // System.out.println(n+" --> "+ans);
        return ans;
    }
}
