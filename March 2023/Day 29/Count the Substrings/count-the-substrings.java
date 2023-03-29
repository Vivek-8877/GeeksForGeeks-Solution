//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1);
    int countSubstring(String S) 
    { 
        // code here
        int ans=0;
        for(int i=0;i<S.length();i++) {
            int l=0,u=0;
            for(int j=i;j<S.length();j++) {
                if(S.charAt(j)>='A' && S.charAt(j)<='Z') {
                    u++;
                } else {
                    l++;
                }
                if(l==u) ans++;
            }
        }
        return ans;
    }
} 
