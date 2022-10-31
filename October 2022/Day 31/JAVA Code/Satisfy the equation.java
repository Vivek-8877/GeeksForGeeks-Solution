//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // Time Complexity :- O(n^2.log(n^2))
    // Space Complexity :- O(n^2)
    static int[] satisfyEqn(int[] A, int N) {
        int[] ans = new int[]{N+1,N+1,N+1,N+1};
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                int key = A[i]+A[j];
                int[] arr;
                if(map.containsKey(key)) {
                    arr = map.get(key);
                    ans = compare(ans,new int[]{arr[0],arr[1],i,j});
                } else {
                    arr = new int[]{i,j};
                }
                map.put(key,arr);
            }
        }
        if(ans[0]==N+1) return new int[]{-1,-1,-1,-1};
        
        return ans;
    }
    
    public static int[] compare(int[] a,int[] b) {
        // to check Validity of Grouping of array b
        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b.length;j++) {
                if(b[i]==b[j] && i!=j) {
                    return a;
                }
            }
        }
        
        for(int i=0;i<a.length;i++) {
            if(a[i]>b[i]) {
                return b;
            } else if(a[i]<b[i]) {
                return a;
            }
        }
        return a;
    }
};
