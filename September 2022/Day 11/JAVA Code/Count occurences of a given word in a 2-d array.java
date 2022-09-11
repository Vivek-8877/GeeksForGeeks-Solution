//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
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
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findOccurrence(char mat[][], String target)
    {
        // Write your code here
        int ans=0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                ans+=solve(mat,target,i,j,0,new byte[mat.length][mat[0].length]);
            }
        }
        return ans;
    }
    public static int solve(char[][] a,String str,int idx,int jdx,int i,byte[][] visit) {
        if(idx<0 || jdx<0 || idx>=a.length || jdx>=a[idx].length || visit[idx][jdx]==1) return 0;
        if(a[idx][jdx]==str.charAt(i)) {
            if(i==str.length()-1) return 1;
        } else {
            return 0;
        }
        
        visit[idx][jdx]=1;
        int lft = solve(a,str,idx,jdx-1,i+1,visit);
        int rt = solve(a,str,idx,jdx+1,i+1,visit);
        int up = solve(a,str,idx-1,jdx,i+1,visit);
        int dn = solve(a,str,idx+1,jdx,i+1,visit);
        visit[idx][jdx]=0;
        return lft+rt+up+dn;
    }
}
