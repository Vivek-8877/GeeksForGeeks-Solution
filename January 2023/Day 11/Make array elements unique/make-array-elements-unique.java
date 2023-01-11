//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        Arrays.sort(arr);
        long ans =0;
        ArrayList<Long> list = new ArrayList<>();
        
        for(long a : arr) {
            if(isPresent(list,a)) {
                long val = list.get(list.size()-1)+1;
                ans+=(val-a);
                a = val;
            }
            list.add(a);
        }
        return ans;
    }
    
    public static boolean isPresent(ArrayList<Long> list,long val) {
        int lo=0,hi=list.size()-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(list.get(mid)<val) {
                lo=mid+1;
            } else if(list.get(mid)==val) {
                return true;
            } else {
                hi=mid-1;
            }
        }
        return false;
    }
}