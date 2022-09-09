//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String digitsNum(int N)
    {
        // Code here
        int sum=N;
        StringBuilder sb = new StringBuilder();
        while(sum>0) {
            if(sum>=9) {
                sb.append("9");
            } else {
                sb.append(sum);
            }
            sum-=9;
        }
        sb.reverse();
        while(N>0) {
            sb.append("0");
            N--;
        }
        return sb.toString();
    }
}
