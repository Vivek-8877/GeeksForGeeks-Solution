//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public int minLength(String s, int n) { 
    	// code here
    	Stack<Character> stack = new Stack<>();
    	String[] str = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
    	
    	for(int i=0;i<n;i++) {
    	    char c = s.charAt(i);
    	    
    	    if(stack.size()==0) {
    	        stack.push(c);
    	    } else {
    	        char p = stack.peek();
    	        
    	        boolean isValid = false;
    	        for(int j=0;j<str.length && !isValid;j++) {
    	            if(str[j].charAt(0)==p && str[j].charAt(1)==c) isValid = true;
    	        }
    	        
    	        if(isValid) {
    	            stack.pop();
    	        } else{
    	            stack.push(c);
    	        } 
    	    }
    	}
    	return stack.size();
    }
}
