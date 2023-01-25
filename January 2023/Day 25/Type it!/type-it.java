//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    int minOperation(String s) {
        // code here
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<s.length()/2;i++) set.add(s.substring(i+1,2*(i+1)));
        
        int ans=s.length();
        for(int i=0;i<s.length()/2;i++) {
            if(set.contains(s.substring(0,i+1))) ans=s.length()-i;
        }
        
        return ans;
    }
}
