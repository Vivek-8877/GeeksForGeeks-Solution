// Problem Link :- https://practice.geeksforgeeks.org/problems/grouping-of-numbers0015/1
// Video Solution Link :- https://www.youtube.com/watch?v=MY2FOOm3wBg

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(k);
    
    static int maxGroupSize(int[] arr, int N, int K) {
        // code here
        int[] fre = new int[K];
        for(int a : arr) {
            a%=K;
            fre[a]++;
        }
        
        int ans =0;
        for(int i=0;i<K;i++) {
            if(fre[i]==0) continue;
            int j = K-i;
            if(i==0 || i==j) {
                ans++;
            } else {
                if(fre[j]!=0) {
                    ans+=Math.max(fre[i],fre[j]);
                    fre[j]=0;
                } else {
                    ans+=fre[i];
                }
                fre[i]=0;
            }
        }
        return ans;
    }
};
