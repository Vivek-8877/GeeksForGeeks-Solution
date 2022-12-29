//{ Driver Code Starts
//Initial Template for Java


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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        // code here
        String s = Integer.toString(n-1);
        String t = Integer.toString(m);
        int ans = f(t,0,-1,1,new Integer[t.length()][11][2]);
        if(n>1) {
            ans-= f(s,0,-1,1,new Integer[s.length()][11][2]);
        } else if(n==1) {
            ans-=1;
        }
        return ans;
    }
    
    // T.C :- O(n.length()*11*2) => O(log(n)*11*2)
    
    public static int f(String n,int idx,int pd,int tight,Integer[][][] dp) {
        if(idx>=n.length()) return 1;
        
        if(dp[idx][pd+1][tight]!=null) return dp[idx][pd+1][tight];
        
        int ans =0;
        
        if(pd==-1) {
            for(int i=0;i<=9;i++) {
                if(i==0) {
                    ans+=f(n,idx+1,-1,0,dp);
                } else {
                    if(tight==1 && n.charAt(idx)-'0'==i) {
                        ans+=f(n,idx+1,i,1,dp);
                        break;
                    }
                    ans+=f(n,idx+1,i,0,dp);
                }
            }
        } else {
            if(tight==1) {
                if(pd-1>=0) {
                    if(pd-1==n.charAt(idx)-'0') {
                        ans+=f(n,idx+1,pd-1,1,dp);
                    } else if(pd-1<n.charAt(idx)-'0') {
                        ans+=f(n,idx+1,pd-1,0,dp);
                    }
                }
                
                if(pd+1<=9) {
                    if(pd+1==n.charAt(idx)-'0') {
                        ans+=f(n,idx+1,pd+1,1,dp);
                    } else if(pd+1<n.charAt(idx)-'0') {
                        ans+=f(n,idx+1,pd+1,0,dp);
                    }
                }
            } else {
                if(pd-1>=0) ans+=f(n,idx+1,pd-1,0,dp);
                if(pd+1<=9) ans+=f(n,idx+1,pd+1,0,dp);
            }
        }
        
        return dp[idx][pd+1][tight]=ans;
    }
}