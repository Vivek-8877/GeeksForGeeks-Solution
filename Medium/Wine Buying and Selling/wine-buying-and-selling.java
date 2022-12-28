//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


//User function Template for Java


class Solution {
    long wineSelling(int arr[],int n){
        // code here
        long ans = 0;
        int i = 0, j = 0;
        while(true) {
            while (i < n && arr[i] <= 0)
                i++;
            while (j < n && arr[j] >= 0)
                j++;
            if(i == n || j == n ) break;
            int change = Math.min(arr[i], -arr[j]);
            ans += (Math.abs(i - j) * change);
            arr[i] -= change;
            arr[j] += change;
        }
        return ans;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends