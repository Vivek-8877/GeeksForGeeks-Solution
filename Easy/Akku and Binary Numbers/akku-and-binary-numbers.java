//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    
    void precompute(){
        // Code Here
    }
    // Time Complexity :- O(63^3);
    // Space Complexity :- O(1);
    long solve(long L, long R){
        // Code here
        return f(R,63,0,0)-f(L-1,63,0,0);
    }
    
    // function return count of number less then or equal to "n" having exactly number of
    // set bit 3.
    long f(long n,long idx,int count_set_bit,int set) {
        if(count_set_bit==3) {
            return 1;
        }
        if(idx<0) return 0;
        
        long ans=0;
        if(isSet(n,idx)) {
            ans+=f(n,idx-1,count_set_bit+1,set&1);
            ans+=f(n,idx-1,count_set_bit,1);
        } else {
            if(set==1) {
                ans+=f(n,idx-1,count_set_bit+1,set);
                ans+=f(n,idx-1,count_set_bit,set);
            } else {
                ans+=f(n,idx-1,count_set_bit,set);
            }
        }
        
        return ans;
    }
    // return true if "idx" bit from right to left is set in "n".
    boolean isSet(long n,long idx) {
        long mask = (1l<<idx);
        return (n&mask)!=0;
    }
    
}
