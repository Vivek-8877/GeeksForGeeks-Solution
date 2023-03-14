//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution{
    public:
        // Time Complexity :- O(n^3);
        // Space Complexity :- O(n^2);
        int maxCoins(int N, vector <int> &a)
        {
            // write your code here
            vector<vector<int>> dp(N,vector<int>(N,-1));
            return f(a,0,N-1,dp);
        }
        int f(vector <int> &arr,int lo,int hi,vector<vector<int>>& dp) {
    	    if(lo>hi) return 0;
    	    
    	    if(dp[lo][hi]!=-1) return dp[lo][hi];
    	    
    	    int ans=0;
    	    for(int i=lo;i<=hi;i++) {
    	        int val=arr[i];
    	        if(lo-1>=0) val*=arr[lo-1];
    	        if(hi+1<arr.size()) val*=arr[hi+1];
    	        val += (f(arr,lo,i-1,dp) + f(arr,i+1,hi,dp));
    	        
    	        ans = max(ans,val);
    	    }
    	    return dp[lo][hi]=ans;
    	}
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<int> a(n);
        for(int i=0;i<n;i++)
            cin>>a[i];
        Solution S;
        cout<<S.maxCoins(n,a)<<endl;
    }
    return 0;
}
// } Driver Code Ends
