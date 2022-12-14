// Problem Link :- https://practice.geeksforgeeks.org/problems/complement3911/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    
    Vector<Integer> findRange(String str, int n) {
        // code here
        Vector<Integer> ans = new Vector<>();
        int sum=0,maxSum=0;
        for(int i=0;i<n;i++) {
            int v = str.charAt(i)-'0';
            if(v==0) {
                v=1;
            } else {
                v=-1;
            }
            if(sum+v<v) {
                sum=v;
            } else {
                sum+=v;
            }
            maxSum=Math.max(maxSum,sum);
        }
        sum=0;
        // System.out.println(maxSum);
        if(maxSum==0) {
            ans.add(-1);
        } else {
            int strt=0;
            for(int i=0;i<n;i++) {
                int v = str.charAt(i)-'0';
                if(v==0) {
                    v=1;
                } else {
                    v=-1;
                }
                
                if(sum+v<v) {
                    sum=v;
                    strt=i;
                } else {
                    sum+=v;
                }
                
                if(sum==maxSum) {
                    ans.add(strt+1);
                    ans.add(i+1);
                    break;
                }
            }
        }
        return ans;
    }
}
