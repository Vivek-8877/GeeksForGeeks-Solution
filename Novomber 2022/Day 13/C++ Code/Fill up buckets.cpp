// Problem Link :- https://practice.geeksforgeeks.org/problems/fill-up-buckets3500/1
// Video Solution Link :- https://youtu.be/RKczlfKnlEA

//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(1);
    
    int totalWays(int n, vector<int>capacity) {
        // code here
        sort(capacity.begin(),capacity.end());
        int mod = 1000000007;
        int ans=1;
        for(int i=0;i<n;i++) {
            ans = (int)((ans*(long long int)(capacity[i]-i))%mod);
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>capacity(n);
		for(int i = 0; i < n; i++)
			cin >> capacity[i];
		Solution ob;
		int ans = ob.totalWays(n, capacity);
		cout << ans << "\n";
	}  
	return 0;
}
// } Driver Code Ends
