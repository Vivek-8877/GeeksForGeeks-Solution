//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int N, int[] start, int[] end) {
        // code here
        int[] list = new int[2*N];
        int idx=0;
        for(int val : start) list[idx++]=val;
        for(int val : end) list[idx++]=val;
        Arrays.sort(list);
        Arrays.sort(start);
        Arrays.sort(end);
        
        int ans=0;
        for(int i=0;i<list.length-1;i++) {
            int user = startedBefore(start,list[i+1])-endedBeforeOrEqualTo(end,list[i]);
            ans = Math.max(ans,user);
        }
        
        return ans;
    }
    
    public static int startedBefore(int[] a,int val) {
        int lo=0,hi=a.length-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<val) {
                lo=mid+1;
                ans = Math.max(ans,lo);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
    
    public static int endedBeforeOrEqualTo(int[] a,int val) {
        int lo=0,hi=a.length-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<=val) {
                lo=mid+1;
                ans = Math.max(ans,lo);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
}