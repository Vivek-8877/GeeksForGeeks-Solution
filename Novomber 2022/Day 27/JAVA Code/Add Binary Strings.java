// Probelm Link :- https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1
// Video Solution Link :- https://youtu.be/xQ7_Iu4HETw

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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Time Complexity :- O(max(|A|, |B|));
    // Space Complexity :- O(max(|A|, |B|)) (for output string);
    
    String addBinary(String A, String B) {
        // code here
        int i=A.length()-1,j=B.length()-1;
        int c=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0) {
            int a1 = A.charAt(i)-'0';
            int b1 = B.charAt(j)-'0';
            sb.append((a1^b1^c));
            i--;
            j--;
            c = ((a1&b1) | (b1&c) | (a1&c));
        }
        while(i>=0) {
            int a1 = A.charAt(i)-'0';
            sb.append((a1^c));
            c = a1&c;
            i--;
        }
        
        while(j>=0) {
            int b1 = B.charAt(j)-'0';
            sb.append((b1^c));
            c = b1&c;
            j--;
        }
        
        sb.append(c);
        sb.reverse();
        i=0;
        while(i<sb.length() && sb.charAt(i)=='0') {
            i++;
        }
        sb.delete(0,i);
        return sb.toString();
    }
}
