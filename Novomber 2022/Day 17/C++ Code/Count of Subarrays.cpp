// Problem Link :- https://practice.geeksforgeeks.org/problems/count-of-subarrays5922/1
// Video Solution Link :- https://youtu.be/cluFktVZPhA

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

#define ll long long


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	// #define ll long long

// 	Time Complexity :- O(n);
// 	Space Complexity :- O(1);

	ll countSubarray(int arr[], int n, int k) {
	    // code here
	    ll ans = (ll)n*(n+1)/2;
        ll l =0;
        for(int i=0;i<n;i++) {
            if(arr[i]<=k) {
                l++;
            } else {
                ans-=(l*(l+1)/2);
                l=0;
            }
        }
        ans-=(l*(l+1)/2);
        return ans;
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.countSubarray(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends
