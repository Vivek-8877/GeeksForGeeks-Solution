// Problem Link :- https://practice.geeksforgeeks.org/problems/maximum-sub-string-after-at-most-k-changes3220/1
// Video Solution Link :- https://youtu.be/8YLpilaVL44


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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    // Time Complexity :- O(n)
    // Space Complexity :- O(26)
    
    public int characterReplacement(String s, int k)
    {
        // code here
        int i=0,j=0,ans=0;
        int[] fre = new int[26];
        while(j<s.length()) {
            if(isValid(fre,k)) {
                ans = Math.max(ans,j-i);
                fre[s.charAt(j)-'A']++;
                j++;
            } else {
                fre[s.charAt(i)-'A']--;
                i++;
            }
        }
        
        while(i<s.length()) {
            if(isValid(fre,k)) {
                ans = Math.max(ans,j-i);
                break;
            } else {
                fre[s.charAt(i)-'A']--;
                i++;
            }
        }
        return ans;
    }
    public static boolean isValid(int[] a,int k) {
        int max =0,sum=0;
        for(int b : a) {
            sum+=b;
            max = Math.max(b,max);
        }
        
        sum-=max;
        
        if(sum<=k) return true;
        return false;
    }
}
