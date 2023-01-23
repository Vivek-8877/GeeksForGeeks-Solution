//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(stack.size()>0 && stack.peek()==c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.size()==0) return "-1";
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0) sb.append(Character.toString(stack.pop()));
        return sb.reverse().toString();
    }
}
        
