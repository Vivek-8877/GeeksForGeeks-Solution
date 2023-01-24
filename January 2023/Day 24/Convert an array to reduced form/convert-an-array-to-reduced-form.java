//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Time Complexity :- O(n.log(n));
    // space Complexity :- O(n);
    void convert(int[] arr, int n) {
        //Code here
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++) {
            map.put(arr[i],i);
        }
        
        int idx=0;
        for(int key : map.keySet()) {
            arr[map.get(key)]=idx;
            idx++;
        }
    }
}