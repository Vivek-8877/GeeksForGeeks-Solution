// Problem Link :- https://practice.geeksforgeeks.org/problems/find-patterns0606/1
// Video Solution Link :- https://youtu.be/X-qmx_2xuQs

//{ Driver Code Starts
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
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(n);
    
    static int numberOfSubsequences(String S, String W){
        // code here
        int ans=0;
        byte[] visit = new byte[S.length()];
        for(int i=0;i<=S.length()-W.length();i++) {
            int k=0;
            for(int j=0;j<S.length();j++) {
                if(S.charAt(j)==W.charAt(k) && visit[j]==0) {
                    k++;
                    visit[j]=1;
                }
                if(k>=W.length()) break;
            }
            if(k>=W.length()) ans++;
        }
        return ans;
    }
}
