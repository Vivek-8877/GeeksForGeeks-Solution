//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends

//User function Template for Java

class Solution {
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    public int removeStudents(int[] H, int N) {
        // code here
        int LIS = lengthOfLIS(H);
        return N-LIS;
    }
    
    public static int lengthOfLIS(int[] H) {
        int[] a = new int[H.length+1];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0]=Integer.MIN_VALUE;
        for(int h : H) {
            int idx = searchLess(a,h);
            a[idx+1]=h;
        }
        for(int i=a.length-1;i>=0;i--) if(a[i]!=Integer.MAX_VALUE) return i;
        return 0;
    }
    
    public static int searchLess(int[] a,int n) {
        int lo=0,hi=a.length-1,ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<n) {
                lo=mid+1;
                ans = Math.max(ans,mid);
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
};
