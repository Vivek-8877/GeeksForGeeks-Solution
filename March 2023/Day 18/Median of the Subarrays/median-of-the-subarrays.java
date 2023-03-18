//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countSubarray(int N, int A[], int M) 
    { 
        return greater_than_equal_to_m_median(A,M)-greater_than_equal_to_m_median(A,M+1);
    }
    
    long greater_than_equal_to_m_median(int[] A,int m) {
        int[] b = new int[A.length];
        for(int i=0;i<b.length;i++) {
            if(A[i]>=m) {
                b[i]=1;
            } else {
                b[i]=-1;
            }
        }
        SegmentTree st = new SegmentTree(A.length*2);
        st.add(b.length);
        long ans=0;
        int s=0;
        for(int i=0;i<b.length;i++) {
            s+=b[i];
            st.add(s+b.length);
            ans+=(long)(st.get(s+b.length-1));
            st.print();
            // System.out.println(s+b.length-1+" "+st+" "+ans);
        }
        return ans;
    }
    
    public static class SegmentTree {
        public static int[] a;
        public static int size;
        SegmentTree(int n) {
            size=n+5;
            a = new int[size*4];
            Arrays.fill(a,0);
        }
        
        public static void add(int v) {
            // System.out.println(v+" --> ");
            add(v,1,0,0,size);
        }
        
        public static int get(int idx) {
            if(idx<0) return 0;
            // System.out.println(idx+" ==> ");
            return get(0,size,0,idx);
        }
        
        private static int get(int lx,int rx,int x,int idx) {
            if(rx-lx==1) return a[x];
            int m = lx+(rx-lx)/2;
            int ans=0;
            if(idx<m) {
                ans= get(lx,m,2*x+1,idx);
            } else {
                ans= get(m,rx,2*x+2,idx)+a[2*x+1];
            }
            // System.out.println(lx+" "+rx+" "+x+" "+ans);
            return ans;
        }
        
        private static void add(int idx,int val,int x,int lx,int rx) {
            // System.out.println(lx+" "+rx+" "+x+" "+a[x]);
            if(rx-lx==1) {
                a[x]+=val;
                return;
            }
            int m = lx+(rx-lx)/2;
            if(idx<m) {
                add(idx,val,2*x+1,lx,m);
            } else {
                add(idx,val,2*x+2,m,rx);
            }
            a[x]=a[2*x+1]+a[2*x+2];
            // System.out.println(lx+" "+rx+" "+x+" --> "+a[x]);
        }
        
        public static void print() {
            // print(0,size,0);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for(long val : this.a) {
                sb.append(val+" ");
            }
            sb.append("Size => "+this.size+"}");
            return sb.toString();
        }
    }
} 