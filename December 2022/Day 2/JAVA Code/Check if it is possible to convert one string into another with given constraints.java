//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(M+N);
    // Space Complexity :- O(1);
    
    int isItPossible(String S, String T, int M, int N) {
        // code here
        if(M!=N) return 0;
        int i=0,j=0;
        while(i<M && j<N) {
            char s = S.charAt(i);
            char t = T.charAt(j);
            if(s==t) {
                i++;
                j++;
            } else {
                if(s=='A') {
                    return 0;
                } else if(s=='B') {
                    if(t=='A') {
                        return 0;
                    } else {
                        j++;
                    }
                } else {
                    i++;
                }
            }
        }
        while(i<M && S.charAt(i)=='#') i++;
        while(j<N && T.charAt(j)=='#') j++;
        if(i<M || j<N) return 0;
        return 1;
    }
};
