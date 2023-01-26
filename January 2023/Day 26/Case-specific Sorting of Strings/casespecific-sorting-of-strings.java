//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    public static String caseSort(String str)
    {
        // Your code here
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        int up=0,lo=0;
        while(lo<ch.length) {
            if(ch[lo]>='a') break;
            lo++;
        }
        
        char[] ans = new char[ch.length];
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)>='a') {
                ans[i]=ch[lo++];
            } else {
                ans[i]=ch[up++];
            }
        }
        return new String(ans);
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends