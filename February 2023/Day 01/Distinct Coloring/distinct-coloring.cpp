//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    long long int distinctColoring(int N, int r[], int g[], int b[]){
        // code here
        vector<vector<long long int>> dp(N+1,vector<long long int>(3,0));
        for(int i=N-1;i>=0;i--) {
            dp[i][0]=min(dp[i+1][1],dp[i+1][2])+r[i];
            dp[i][1]=min(dp[i+1][0],dp[i+1][2])+g[i];
            dp[i][2]=min(dp[i+1][0],dp[i+1][1])+b[i];
        }
        return min(dp[0][0],min(dp[0][1],dp[0][2]));
    }
    
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin >> N;
        int r[N],g[N],b[N];
        for(int i = 0; i < N; i++)
            cin >> r[i];
        for(int i = 0; i < N; i++)
            cin >> g[i];
        for(int i = 0; i < N; i++)
            cin >> b[i];
        
        Solution ob;
        cout << ob.distinctColoring(N, r, g, b) << endl;
    }
    return 0; 
}
// } Driver Code Ends