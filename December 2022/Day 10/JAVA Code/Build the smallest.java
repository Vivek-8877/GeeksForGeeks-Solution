// Probelm Link :- https://practice.geeksforgeeks.org/problems/build-the-smallest2841/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Time Complexity :- O(num.length);
    // Space Complexity :- O(num.length);
    static String buildLowestNumber(String str, int N) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            while(stack.size()>0 && stack.peek()>c && N>0) {
                N--;
                stack.pop();
            }
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0) {
            char c = stack.pop();
            if(N>0) {
                N--;
                continue;
            }
            sb.append(Character.toString(c));
        }
        
        String ans = sb.reverse().toString();
        for(int i=0;i<ans.length();i++) {
            if(ans.charAt(i)!='0') return ans.substring(i);
        }
        return "0";
    }
}
