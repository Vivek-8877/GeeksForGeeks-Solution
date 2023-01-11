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
    // Space Complexity :- O(n);
    long long int minIncrements(vector<int> arr, int N) {
        // Code here
        sort(arr.begin(),arr.end());
        ll ans =0;
        set<ll> st;
        
        for(ll a : arr) {
            auto pos = st.find(a);
            if(st.find(a)!=st.end()) {
                ll val = *st.rbegin()+1;
                ans+=(val-a);
                a=val;
            }
            st.insert(a);
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<int> arr(N);
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        Solution obj;
        cout << obj.minIncrements(arr, N) << endl;
    }
}
// } Driver Code Ends