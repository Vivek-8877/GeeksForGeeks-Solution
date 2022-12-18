// Problem Link :- https://practice.geeksforgeeks.org/problems/a-game-of-lcm2531/1
// Video Solution Link :- https://youtu.be/OnM_aCgE5ho

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
#define ll long long int
class Solution {
  public:
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(1);
    ll solve(ll n) {
        ll a1 = n;
        int include=0;
        for(ll i=n-1;i>=1;i--) {
            ll g = gcd(a1,i);
            if(g==1) {
                a1*=i;
                include++;
            }
            if(include==3) return a1;
        }
        return a1;
    }
    
    long long maxGcd(int N) {
        // code here
        return max(solve(N),solve(N-1));
    }
    
    ll gcd(ll a,ll b) {
        if(a==0) return b;
        return gcd(b%a,a);
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
        cout << ob.maxGcd(N) << "\n";
    }
}
// } Driver Code Ends
