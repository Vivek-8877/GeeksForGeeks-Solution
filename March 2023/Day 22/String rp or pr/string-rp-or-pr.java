//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    static long solve(int X,int Y, String S)
	{    
	    // code here
        long ans;
        if(X<Y) {
            ans = f(Y,X,S,'r','p');
        } else {
            ans = f(X,Y,S,'p','r');
        }
        return ans;
	}
	
	public static long f(long x,long y,String s,char c1,char c2) {
	    Stack<Character> st = new Stack<>();
	    long ans=0;
	    for(int i=0;i<s.length();i++) {
	        char c = s.charAt(i);
	        if(c==c2) {
	            if(st.size()>0 && st.peek()==c1) {
	                st.pop();
	                ans+=x;
	            } else {
	                st.push(c);
	            }
	        } else {
	            st.push(c);
	        }
	    }
	    
	    Stack<Character> st1 = new Stack<>();
	    while(st.size()>0) {
	        if(st.peek()==c2) {
	            if(st1.size()>0 && st1.peek()==c1) {
	                ans+=y;
	                st1.pop();
	                st.pop();
	            } else {
	                st1.push(st.pop());
	            }
	        } else {
	            st1.push(st.pop());
	        }
	    }
	    return ans;
	}
} 
