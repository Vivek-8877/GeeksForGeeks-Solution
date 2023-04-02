//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // Time Complexity :- O(n*m);
    // Space Complexity :- O(n*m);
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        // Code Here.
        int[][] steps = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};
        int n = arr.length,m=arr[0].length;
        byte[][] visit = new byte[n][m];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start_x,start_y});
        ArrayList<Integer> points = new ArrayList<>();
        while(dq.size()>0) {
            int s = dq.size();
            int point=0;
            while(s-->0) {
                int[] idx = dq.pop();
                int i=idx[0],j=idx[1];
                if(visit[i][j]==1) continue;
                visit[i][j]=1;
                point+=arr[i][j];
                for(int[] step : steps) {
                    if(i+step[0]>=0 && i+step[0]<n && j+step[1]>=0 && j+step[1]<m) {
                        if(visit[i+step[0]][j+step[1]]==0) dq.add(new int[]{i+step[0],j+step[1]});
                    }
                }
            }
            points.add(point);
        }
        int ans=0,max_point=0;
        for(int i=0;i<points.size();i++) {
            int idx=i;
            int score=0;
            while(idx<points.size()) {
                score+=points.get(idx);
                if(points.get(idx)==0) break;
                idx+=points.get(idx);
            }
            if(max_point<score) {
                max_point=score;
                ans=i;
            }
        }
        return ans;
    }
}   
