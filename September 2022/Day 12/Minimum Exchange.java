//{ Driver Code Starts
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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.MinimumExchange(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int MinimumExchange(char[][] matrix)
    {
        // Code here
        
        return Math.min(solve(matrix,'A'),solve(matrix,'B'));
    }
    
    public int solve(char[][] matrix,char r_start) {
        int ans=0;
        for(char[] mat : matrix) {
            char next_r = (r_start=='A' ? 'B' : 'A');
            for(char ch : mat) {
                if(ch!=r_start) {
                    ans++;
                }
                r_start = (r_start=='A' ? 'B' : 'A');
            }
            r_start=next_r;
        }
        return ans;
    }
}
