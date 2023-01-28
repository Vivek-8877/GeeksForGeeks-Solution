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
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isScramble(String S1,String S2)
    {
        //code here
        int n = S1.length();
        return isValid(S1,S2,0,S1.length()-1,0,S2.length()-1,new Boolean[n][n][n][n]);
    }
    
    static boolean isValid(String s1,String s2,int lo1,int hi1,int lo2,int hi2,Boolean[][][][] dp) {
        // System.out.println(lo1+" "+hi1+" "+lo2+" "+hi2+" "+step);
        if(s1.substring(lo1,hi1+1).compareTo(s2.substring(lo2,hi2+1))==0) return true;
        
        if(dp[lo1][hi1][lo2][hi2]!=null) return dp[lo1][hi1][lo2][hi2];
        boolean ans=true;
        for(int i=lo1,j=hi2;i<=hi1 && ans;i++,j--) {
            // System.out.println(i+" "+j);
            if(s1.charAt(i)!=s2.charAt(j)) ans=false;
        }
        
        for(int i=0;i<hi1-lo1 && !ans;i++) {
            if(isValid(s1,s2,lo1,lo1+i,lo2,lo2+i,dp) && isValid(s1,s2,lo1+i+1,hi1,lo2+i+1,hi2,dp)) ans=true;
            if(!ans && isValid(s1,s2,lo1,lo1+i,hi2-i,hi2,dp) && isValid(s1,s2,lo1+i+1,hi1,lo2,hi2-i-1,dp)) ans=true;
        }
        // System.out.println(step);
        return dp[lo1][hi1][lo2][hi2]=ans;
    }
    
}
