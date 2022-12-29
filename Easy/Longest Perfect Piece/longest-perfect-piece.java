//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        // code here
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i=0,j=0;
        int ans=0;
        while(j<N) {
            if(map.size()<2) {
                ans = Math.max(ans,j-i);
                add(map,arr[j]);
                j++;
            } else if(map.size()==2) {
                if(map.lastKey()-map.firstKey()<=1) {
                    ans = Math.max(ans,j-i);
                    add(map,arr[j]);
                    j++;
                } else {
                    remove(map,arr[i]);
                    i++;
                }
            } else {
                remove(map,arr[i]);
                i++;
            }
        }
        while(i<N) {
            if(map.size()<2) {
                ans = Math.max(ans,j-i);
                break;
            } else if(map.size()==2) {
                if(map.lastKey()-map.firstKey()<=1) {
                    ans = Math.max(ans,j-i);
                    break;
                } else {
                    remove(map,arr[i]);
                    i++;
                }
            } else {
                remove(map,arr[i]);
                i++;
            }
        }
        return ans;
    }
    
    public static void add(TreeMap<Integer,Integer> map,int v) {
        if(map.containsKey(v)) {
            map.put(v,map.get(v)+1);
        } else {
            map.put(v,1);
        }
    }
    
    public static void remove(TreeMap<Integer,Integer> map,int v) {
        if(map.get(v)!=1) {
            map.put(v,map.get(v)-1);
        } else {
            map.remove(v);
        }
    }
};