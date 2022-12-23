// Problem Link :- https://practice.geeksforgeeks.org/problems/burst-balloons/1
// Video Solution Link :- https://youtu.be/g3IMTELUKX8

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
public:
    // Time Complexity :- O(n^3);
    // Space Complexity :- O(n^2);
    int maxCoins(int N, vector<int> &arr) {
        // code here
        vector<vector<int>> dp(N,vector<int>(N,-1));
        return f(arr,0,N-1,dp);
    }
    
    // return maximum coins we get after bursting ballon from range "i" to "j".
    int f(vector<int>& a,int i,int j,vector<vector<int>>& dp) {
      if(i>j) return 0;
      
      if(dp[i][j]!=-1) return dp[i][j];
      
      int l1 = (i-1>=0 ? a[i-1]:1); // left ballon which exist after bursting i to j.
      int r1 = (j+1<a.size() ? a[j+1]:1); // right ballon which exist after bursting i to j.
      int ans=0;
      for(int k=i;k<=j;k++) {
          int left = f(a,i,k-1,dp);
          int right = f(a,k+1,j,dp);
          
          int coin = left+right+l1*a[k]*r1;
          
          ans = max(ans,coin);
      }
      
      return dp[i][j]=ans;
  }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        
        vector<int> arr(N);
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution obj;
        cout << obj.maxCoins(N, arr) << endl;
    }
    return 0;
}
// } Driver Code Ends
