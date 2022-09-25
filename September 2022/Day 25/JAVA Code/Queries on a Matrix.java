//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    //   Time Complexity :- O(n^2);
    //   Space Complexity :- O(n^2);
    
    public int[][] solveQueries(int n, int[][] Queries) {
        // Code here
        int[][] mat = new int[n][n];
        for(int[] q : Queries) {
            for(int i=q[0];i<=q[2];i++) {
                mat[i][q[1]]++;
                if(q[3]+1<n) mat[i][q[3]+1]--;
            }
        }
        
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=0;j<n;j++) {
                sum+=mat[i][j];
                mat[i][j]=sum;
            }
        }
        return mat;
    }
}
