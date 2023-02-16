//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int goodStones(int n, int[] arr) {
        // code here
        byte[] visit = new byte[n];
        for(int i=0;i<n;i++) {
            if(visit[i]==0) {
                isValid(arr,i,visit);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            if(visit[i]==1) ans++;
        }
        return ans;
    }
    
    public static boolean isValid(int[] a,int idx,byte[] visit) {
        // System.out.println(idx);
        if(idx<0 || idx>=a.length || visit[idx]==1) return true;
        if(visit[idx]==-1 || visit[idx]==2) return false;
        visit[idx]=2;
        boolean is = isValid(a,idx+a[idx],visit);
        if(is) {
            visit[idx]=1;
        } else {
            visit[idx]=-1;
        }
        return is;
    }
}
