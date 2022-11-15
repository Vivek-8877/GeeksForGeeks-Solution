// Problem Link :- https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1
// Video Solution Link :- 

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
        // code here
        int ans=0;
        for(int i=0;i<s.length();i++) {
            int[] fre = new int[26];
            for(int j=i;j<s.length();j++) {
                fre[s.charAt(j)-'a']++;
                ans+=findBeauty(fre);
            }
        }
        return ans;
    }
    
    public static int findBeauty(int[] fre) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int f : fre) {
            if(f==0) continue;
            max = Math.max(max,f);
            min = Math.min(min,f);
        }
        return max-min;
    }
}
        
