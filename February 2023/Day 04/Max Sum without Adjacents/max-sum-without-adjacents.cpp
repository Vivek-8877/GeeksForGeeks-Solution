//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	// calculate the maximum sum with out adjacent
// 	Time Complexity :- O(n);
// 	Space Complexity :- O(1);
	int findMaxSum(int *arr, int n) {
	    // code here
	    int ans=0,mx=0,max1=0;
	   // mx -> it Store maximum sebsequence sum before of before current index.
	   // max1 -> it store maximum sebsequence sum before current index.
        for(int i=0;i<n;i++) {
            int val = arr[i]+mx;
            mx = max(mx,max1);
            max1 = max(max1,val);
            ans = max(ans,val);
        }
        return ans;
	}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.findMaxSum(arr, n);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends