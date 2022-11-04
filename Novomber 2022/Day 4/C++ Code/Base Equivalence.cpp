// Problem Link :- https://practice.geeksforgeeks.org/problems/base-equivalence1022/1
// Video Solution Link :- 

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    // Time Complexity :- O(30.log(n));
    // Space Complexity :- O(1);
    
    string baseEquiv(int n, int m){
        // code here
        for(int i=2;i<=32;i++) {
            if(decimal_to_m_base(n,i)==m) return "Yes";
        }
        return "No";
    }
    
    int decimal_to_m_base(int n,int m) {
        int ct=0;
        while(n>0) {
            ct++;
            n/=m;
        }
        return ct;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        Solution ob;
        cout<<ob.baseEquiv(n,m)<<endl;
    }
    return 0;
}

// } Driver Code Ends
