// Problem Link :- https://practice.geeksforgeeks.org/problems/asteroid-collision/1
// Video Solution Link :- 

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            while(stack.size()>0) {
                int idx = stack.peek();
                if(asteroids[i]<0) {
                    // left-movement
                    if(asteroids[idx]>0) {
                        // right-movement
                        if(-asteroids[i]<asteroids[idx]) {
                            asteroids[i]=0;
                            break;
                        } else if(-asteroids[i]==asteroids[idx]) {
                            asteroids[i]=0;
                            asteroids[idx]=0;
                            stack.pop();
                            break;
                        } else {
                            asteroids[idx]=0;
                            stack.pop();
                        }
                    } else {
                        // left-movement
                        break;
                    }
                } else if(asteroids[i]==0) {
                    break;
                } else {
                    // right-movement
                    break;
                }
            }
            
            if(asteroids[i]!=0) {
                stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        int idx=ans.length-1;
        while(stack.size()>0) {
            ans[idx]=asteroids[stack.pop()];
            idx--;
        }
        return ans;
    }
}
