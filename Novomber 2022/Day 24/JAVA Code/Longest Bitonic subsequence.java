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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int[] right = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]>nums[j]) right[i] = Math.max(right[i],right[j]);
            }
            right[i]++;
        }
        
        int[] left = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) left[i] = Math.max(left[i],left[j]);
            }
            left[i]++;
        }
        
        int ans=0;
        for(int i=0;i<left.length;i++) {
            ans = Math.max(ans,left[i]+right[i]-1);
        }
        
        return ans;
    }
}
