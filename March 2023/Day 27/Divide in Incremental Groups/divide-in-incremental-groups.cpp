//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int countWaystoDivide(int N, int K) {
        // Code here
        vector<vector<vector<int>>> dp(N+1,vector<vector<int>>(K+1,vector<int>(N+1,-1)));
        return f(N,K,1,dp);
    }
    
    int f(int sum,int k,int previousElement,vector<vector<vector<int>>>& dp) {
        if(k==0 && sum==0) return 1;
        if(k==0 || sum<=0) return 0;
        if(dp[sum][k][previousElement]!=-1) return dp[sum][k][previousElement];
        
        int ans=0;
        for(int i=previousElement;i<=sum;i++) {
            ans+=f(sum-i,k-1,i,dp);
        }
        return dp[sum][k][previousElement]=ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> N >> K;
        Solution ob;
        cout << ob.countWaystoDivide(N, K) << endl;
    }
}
// } Driver Code Ends