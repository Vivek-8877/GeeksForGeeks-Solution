//{ Driver Code Starts
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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // Time Complexity :- O(32.r.log(c));
    // Space Complexity :- O(1);
    
    int median(int matrix[][], int R, int C) {
        // code here   
        
        // Brute Force
        // Time Complexity :- O(r.c);
        // Space Complexity :- O(r.c);
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int[] val : matrix) {
        //     for(int v1 : val) {
        //         list.add(v1);
        //     }
        // }
        // Collections.sort(list);
        // int idx = (R*C)/2;
        // if(R%2==0 || C%2==0) idx--;
        // return list.get(idx);
        
        int lo = Integer.MAX_VALUE,hi=Integer.MIN_VALUE;
        
        for(int i=0;i<R;i++) {
            lo = Math.min(lo,matrix[i][0]);
            hi = Math.max(hi,matrix[i][C-1]);
        }
        int required_value=((R*C)/2);
        if(R%2==0 || C%2==0) required_value--;
        int ans=hi;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            
            int count=0;
            for(int i=0;i<R;i++) {
                count+=search(matrix[i],mid);
            }
            
            if(count<=required_value) {
                lo=mid+1;
            } else {
                hi=mid-1;
                ans=Math.min(ans,mid);
            }
        }
        return ans;
        
    }
    
    public static int search(int[] a,int v) {
        int lo=0,hi=a.length-1;
        int ans=-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<=v) {
                lo=mid+1;
                ans=Math.max(ans,mid);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
}
