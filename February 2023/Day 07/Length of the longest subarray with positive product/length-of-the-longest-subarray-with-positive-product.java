//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    int maxLength(int arr[], int n) { 
        //code here
        int strt=0,first_negative=-1,count_negative=0;
        int ans=0;
        for(int i=0;i<n;i++) {
            if(arr[i]==0) {
                strt=i+1;
                first_negative=-1;
                count_negative=0;
                continue;
            } else if(arr[i]<0) {
                count_negative++;
                if(first_negative==-1) first_negative=i;
            }
            
            if(count_negative%2==0) {
                ans = Math.max(ans,i-strt+1);
            } else {
                ans = Math.max(ans,i-first_negative);
            }
        }
        return ans;
    }
   
}
