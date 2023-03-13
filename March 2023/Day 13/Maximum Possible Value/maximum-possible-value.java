//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int N, int A[] ,int B[]) { 
        // code here
        long ans=0;
        long pv=0;
        long min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            long side=A[i];
            long fre=B[i]/4;
            ans+=(4*side*fre);
            if(B[i]!=1) min = Math.min(side,min);
            if(B[i]%4==2 || B[i]%4==3) {
                if(pv==0) {
                    pv=side;
                } else {
                    ans+=(2*pv)+(2*side);
                    pv=0;
                }
            }
            // System.out.println(ans);
        }
        if(pv!=0) {
            ans = Math.max(ans,ans-2*min+2*pv);
        }
        // System.out.println(min);
        return ans;
    }
} 