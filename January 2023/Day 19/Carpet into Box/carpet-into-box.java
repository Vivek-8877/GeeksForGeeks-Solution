//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int step=0;
        int l1=Math.max(A,B),b1=Math.min(A,B),l=Math.max(C,D),b=Math.min(C,D);
        while(l1>l || b1>b) {
            // System.out.println("Before :- "+l1+" "+b1);
            if(l1>l && b1>b) {
                l1/=2;
            } else if(l1>l) {
                l1/=2;
            } else {
                b1/=2;
            }
            
            A=l1;
            B=b1;
            l1 = Math.max(A,B);
            b1 = Math.min(A,B);
            
            step++;
            // System.out.println("After :- "+l1+" "+b1);
        }
        
        return step;
    }
   
}
