//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    // Time Complexity :- O(n);
    // Space Compleixty :- O(1);
    static String secondSmallest(int S, int D){
        // code here
        if(D==1 || S==1 || S>=9*D) return "-1";
        boolean isChanged=false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<D;i++) {
            int digit;
            if(S>9) {
                digit=9;
                S-=9;
            } else {
                if(i==D-1) {
                    digit=S;
                } else {
                    if(S>1) {
                        digit=S-1;
                        S=1;
                    } else {
                        digit=0;
                    }
                }
            }
            if(!isChanged && digit<9 && sb.length()>0) {
                digit++;
                char c = sb.charAt(sb.length()-1);
                sb.setCharAt(sb.length()-1,--c);
                isChanged=true;
            }
            sb.append(digit);
        }
        return sb.reverse().toString();
    }
}