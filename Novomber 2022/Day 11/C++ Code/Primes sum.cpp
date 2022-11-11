// Problem Link :- https://practice.geeksforgeeks.org/problems/primes-sum5827/1
// Video Solution Link :- https://youtu.be/lHty0tFJSRE

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
public:
    // Time Complexity :- O(n.sqrt(n));
    // Space Complexity :- O(1);
    
    string isSumOfTwo(int N){
        // code here
        for(int i=2;i<=N/2;i++) {
            if(isPrime(i) && isPrime(N-i)) {
                return "Yes";
            }
        }
        return "No";
    }
    bool isPrime(int n) {
        for(int i=2;i*i<=n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.isSumOfTwo(N) << endl;
    }
    return 0;
}

// } Driver Code Ends
