//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // T.C :- O(n.log(n))
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(j<n) {
            int ne = j-i;
            if(ne<k) {
                add(map,arr[j]);
                j++;
            } else {
                ans.add(map.lastKey());
                remove(map,arr[i]);
                i++;
            }
        }
        
        if(j-i==k) ans.add(map.lastKey());
        
        return ans;
    }
    
    public static void add(TreeMap<Integer,Integer> map,int key) {
        if(map.containsKey(key)) {
            map.put(key,map.get(key)+1);
        } else {
            map.put(key,1);
        }
    }
    
    public static void remove(TreeMap<Integer,Integer> map,int key) {
        if(map.get(key)==1) {
            map.remove(key);
        } else {
            map.put(key,map.get(key)-1);
        }
    }
    
}
