//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
// Time Complexity :- O(n);
// Space Compleixty :- O(1);
long long int no_of_subarrays(int n, vector<int> &arr) {
    // Write your code here.
    long long int ct=0,ans=0;
	for(int v : arr) {
	    if(v==0) {
	        ct++;
	    } else {
	        ans+=(ct*(ct+1)/2);
	        ct=0;
	    }
	}
	ans+=(ct*(ct+1)/2);
	return ans;
}

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        cout << no_of_subarrays(n, arr) << endl;
    }
}

// } Driver Code Ends