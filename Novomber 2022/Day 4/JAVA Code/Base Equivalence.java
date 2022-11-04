// Problem Link :- https://practice.geeksforgeeks.org/problems/base-equivalence1022/1
// Video Solution Link :- https://www.youtube.com/watch?v=ERvz7yZjPXA

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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    // Time Complexity :- O(log(30).log(n));
    // Space Complexity :- O(1);
    
    String baseEquiv(int n, int m)
    {
        // code here
        int lo=2,hi=32;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int count_of_digit = decimal_to_m_base(n,mid);
            if(count_of_digit==m) {
                return "Yes";
            } else if(count_of_digit<m) {
                hi=mid-1;
            } else {
                lo=mid+1;
            }
        }
        return "No";
    }
    
    public static int decimal_to_m_base(int n,int m) {
        int ct=0;
        while(n>0) {
            ct++;
            n/=m;
        }
        return ct;
    }
}
