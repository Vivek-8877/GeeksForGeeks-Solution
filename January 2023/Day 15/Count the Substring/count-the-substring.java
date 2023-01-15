//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long ans;
    public static int[] merge(int[] a,int[] b) {
        int[] c = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length) {
            if(a[i]<=b[j]) {
                c[k]=a[i];
                i++;
            } else {
                c[k]=b[j];
                ans+=(a.length-i);
                j++;
            }
            k++;
        }
        while(i<a.length) {
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length) {
            c[k]=b[j];
            j++;
            k++;
        }
        return c;
    }
    public static int[] merge(int[] a,int lo,int hi) {
        if(lo>=hi) return new int[]{a[lo]};
        int mid = lo+(hi-lo)/2;
        int[] a1 = merge(a,lo,mid);
        int[] b1 = merge(a,mid+1,hi);
        return merge(a1,b1);
    }
    
    long countSubstring(String S) {
       ans=0;
       int[] a = new int[S.length()];
       for(int i=0;i<a.length;i++) {
           if(S.charAt(i)=='0') {
               a[i]=-1;
           } else {
               a[i]=1;
           }
       }
       
       int[] prefix_sum = new int[a.length];
       int sum=0;
       for(int i=0;i<a.length;i++) {
           sum+=a[i];
           prefix_sum[i]=sum;
           if(sum>0) ans++;
       }
       for(int i=0,j=a.length-1;i<a.length;i++,j--) a[i]=prefix_sum[j];
       merge(a,0,a.length-1);
       return ans;
    }
}