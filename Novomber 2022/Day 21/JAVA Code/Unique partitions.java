// Problem Link :- https://practice.geeksforgeeks.org/problems/unique-partitions1041/1
// Video Solution Link :- https://youtu.be/BfWiMxyazh4

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
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Time Complexity :- O(2^n) (approx);
    // Space Complexity :- O(n);
    
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        f(n,ans,new ArrayList<>());
        return ans;
    }
    
    public static void f(int n,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list) {
        if(n<=0) {
            if(n==0) {
                ans.add((ArrayList)list.clone());
            }
            return;
        }
        int v =n;
        if(list.size()>0) v = list.get(list.size()-1);
        
        for(int i=v;i>=1;i--) {
            list.add(i);
            f(n-i,ans,list);
            list.remove(list.size()-1);
        }
        
    }
}
