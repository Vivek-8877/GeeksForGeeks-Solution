// Problem Link :- https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
// Video Solution Link :- 

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    
    vector<int> minPartition(int N)
    {
        // code here
        vector<int> coins{1,2,5,10,20,50,100,200,500,2000};
        vector<vector<int>> dp(N+1,vector<int>(2,0));
        
        for(int i=1;i<=N;i++) {
            dp[i][0]=INT_MAX;
            for(int coin : coins) {
                if(i-coin>=0) {
                    if(dp[i-coin][0]+1<dp[i][0]) {
                        dp[i][0]=dp[i-coin][0]+1;
                        dp[i][1]=coin;
                    }
                } else {
                    break;
                }
            }
        }
        
        vector<int> ans;
        while(N>0) {
            ans.push_back(dp[N][1]);
            N-=dp[N][1];
        }
        sort(ans.begin(),ans.end(),greater<int>());
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        vector<int> numbers = ob.minPartition(N);
        for(auto u: numbers)
            cout<<u<<" ";
        cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends
