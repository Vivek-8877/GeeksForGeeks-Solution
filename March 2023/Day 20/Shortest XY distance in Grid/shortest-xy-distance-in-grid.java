//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) if(grid.get(i).get(j)=='X') pq.offer(new int[]{i,j,0});
        }
        byte[][] visit = new byte[N][M];
        while(pq.size()>0) {
            int[] p = pq.poll();
            int i=p[0],j=p[1];
            if(visit[i][j]==1) continue;
            visit[i][j]=1;
            if(grid.get(i).get(j)=='Y') return p[2];
            if(isValid(i+1,j,N,M,visit)) pq.offer(new int[]{i+1,j,p[2]+1});
            if(isValid(i,j+1,N,M,visit)) pq.offer(new int[]{i,j+1,p[2]+1});
            if(isValid(i-1,j,N,M,visit)) pq.offer(new int[]{i-1,j,p[2]+1});
            if(isValid(i,j-1,N,M,visit)) pq.offer(new int[]{i,j-1,p[2]+1});
        }
        return -1;
    }
    public static boolean isValid(int i,int j,int n,int m,byte[][] visit) {
        if(i<0 || j<0 || i>=n || j>=m || visit[i][j]==1) return false;
        return true;
    }
};