//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    public static int appleSequence(int n, int m, String arr){
        //code here
        int i=0,j=0,o=0,ans=0;
        while(j<n) {
            if(arr.charAt(j)=='O') {
                if(o<m) {
                    o++;
                    j++;
                } else {
                    if(arr.charAt(i)=='O') o--;
                    i++;
                }
            } else {
                j++;
            }
            ans = Math.max(ans,j-i);
        }
        return ans;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends