//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int n = A.length(),m=B.length();
        int j=-1,ct=0;
        for(int i=0;i<n;i++) {
            if(n-i<=m) {
                if(A.substring(i).compareTo(B.substring(0,n-i))==0) {
                    j=n-i;
                    ct++;
                    break;
                }
            } else {
                if(A.substring(i,i+m).compareTo(B)==0) {
                    return 1;
                }
            }
        }
        
        if(j==-1) return -1;
        for(int i=j;i<m;i+=n) {
            if(i+n<=m) {
                if(B.substring(i,i+n).compareTo(A)==0) {
                    j=i+n;
                    ct++;
                } else {
                    return -1;
                }
            } else {
                if(B.substring(j).compareTo(A.substring(0,m-j))==0) {
                    ct++;
                    j=m;
                } else {
                    return -1;
                }
            }
        }
        // System.out.println(j+" "+ct);
        return ct;
    }
};