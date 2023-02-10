//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(26);
    public int maxInstance(String s) {
        // Code here
        int[] fre = new int[26];
        for(int i=0;i<s.length();i++) {
            fre[s.charAt(i)-'a']++;
        }
        int m1=s.length(),m2=s.length();
        for(int i=0;i<26;i++) {
            if(i==0 || i==1 || i==13) {
                m1=Math.min(m1,fre[i]);
            } else if(i==14 || i==11) {
                m2=Math.min(m2,fre[i]);
            }
        }
        return Math.min(m1,m2/2);
    }
}