Problem Link :- https://practice.geeksforgeeks.org/problems/3-divisors3942/1
Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    // Time Complexity :- O(q*N*log(log(N)));
    // Space Complexity :- O(N), where N is min(10^6,N);
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> prime = primeNumber(1000000);
        ArrayList<Integer> ans = new ArrayList<>();
        for(long q1 : query) {
            ans.add(solve(prime,q1));
        }
        return ans;
    }
    
    public static ArrayList<Integer> primeNumber(int n) {
        int[] prime = new int[n+1];
        Arrays.fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        
        for(int i=2;i<=n;i++) {
            if(prime[i]==1) {
                for(int j=i+i;j<=n;j+=i) {
                    prime[j]=0;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            if(prime[i]==1) list.add(i);
        }
        return list;
    }
    
    public static int solve(ArrayList<Integer> prime,long q) {
        int v1 = (int)Math.sqrt(q);
        int lo=0,hi=prime.size()-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(prime.get(mid)<=v1) {
                lo=mid+1;
                ans = Math.max(ans,mid+1);
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
}
