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
            int N = Integer.parseInt(read.readLine());
            ArrayList<Long> A = new ArrayList<Long>();
            String in[] = read.readLine().trim().split(" ");
            for(var i : in){
                Long x = Long.parseLong(i);
                A.add(x);
            }

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(N,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static final long mod = 1000000007;
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        // code here
        long count =0;
        for(long n : A) {
            if(number_of_set_bit(n)==1) {
                count++;
            }
        }
        return subtract(power(2,count),1);
    }
    
    public static long power(long a,long b) {
        if(b==0) return 1;
        
        long p = power(a,b/2)%mod;
        
        if(b%2==1) {
            // p = p*p*a
            p = multiply(p,multiply(p,a));
        } else {
            // p = p*p
            p = multiply(p,p);
        }
        
        return p;
    }
    
    public static int number_of_set_bit(long n) {
        int ct=0;
        while(n>0) {
            long rsbm = n&(-n);
            ct++;
            n-=rsbm;
        }
        return ct;
    }
    
    public static long multiply(long a,long b) {
        return ((a%mod)*(b%mod))%mod;
    }
    
    public static lon
