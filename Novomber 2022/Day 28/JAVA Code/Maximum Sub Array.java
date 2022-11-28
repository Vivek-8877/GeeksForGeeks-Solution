// Problem Link :- https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1
// Video Solution Link :- https://youtu.be/HxTo8vRl6R8

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(n);
    // 	Space Complexity :- O(1);
    
    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        long sum=0;
        int l=0,idx=-1;
        
        long max = 0;
        int l1=0,idx1=-1;
        for(int i=0;i<n;i++) {
            if(a[i]>=0) {
                sum+=(long)(a[i]);
                l++;
                if(idx==-1) {
                    idx=i;
                }
            } else {
                sum=0;
                l=0;
                idx=-1;
            }
            
            if(max<sum) {
                max=sum;
                idx1=idx;
                l1=l;
            } else if(max==sum) {
                if(l1<l) {
                    max=sum;
                    idx1=idx;
                    l1=l;
                }
            }
        }
        
        if(l1==0) return new ArrayList<>(Arrays.asList(-1));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=idx1;i<n && a[i]>=0;i++) list.add(a[i]);
        return list;
    }
}
