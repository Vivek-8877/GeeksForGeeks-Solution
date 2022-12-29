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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            int n = a[0],m=a[1],k=a[2];
            
            int[][] e = IntMatrix.input(br, a[2], 2);
            
            Solution obj = new Solution();
            int res = obj.largestArea(n,m,k,e);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




       

class Solution {
    
    // Time Complexity :- O(k.log(k));
    // Space Complexity :- O(k);
    public static int largestArea(int n,int m,int k,int[][] enemy) {
        // code here
        if(k==0) return m*n;
        
        Arrays.sort(enemy,(a,b) ->(a[1]-b[1]));
        int max_column=enemy[0][1]-1;
        for(int i=0;i<enemy.length;i++) {
            if(i==enemy.length-1) {
                max_column = Math.max(max_column,(m+1)-enemy[i][1]-1);
            } else {
                max_column = Math.max(max_column,enemy[i+1][1]-enemy[i][1]-1);
            }
        }
        
        Arrays.sort(enemy,(a,b) -> (a[0]-b[0]));
        int max_row = enemy[0][0]-1;
        for(int i=0;i<enemy.length;i++) {
            if(i==enemy.length-1) {
                max_row = Math.max(max_row,(n+1)-enemy[i][0]-1);
            } else {
                max_row = Math.max(max_row,enemy[i+1][0]-enemy[i][0]-1);
            }
        }
        return max_row*max_column;
    }
}
 
