// Problem Link :- https://practice.geeksforgeeks.org/problems/lcm-triplet1501/1
// Video Solution Link :- https://youtu.be/2hrQZQDak_k

//{ Driver Code Starts
// Initial Template for C++

// Initial Template for C++
// Back-end complete function Template for C++
// User function Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
//   Time Complexity :- O(1);
//   Space Complexity :- O(1);
  
  public:
    long long lcmTriplets(long long N) {
        // code here
        if(N<=2) return N;
        if(N%2==0) {
            if(N%3==0) {
                return (N-1)*(N-2)*(N-3);
            } else {
                return (N-1)*(N-3)*(N);
            }
        } else {
            return (N-2)*(N-1)*(N);
        }
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N;
        cin >> N;
        Solution ob;
        cout << ob.lcmTriplets(N) << "\n";
    }
}
// } Driver Code Ends
