//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++

class Solution{
  public:
    int countVertex(int N, vector<vector<int>>edges){
        // code here
        vector<int> graph[N+1];
        for(vector<int> e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(N+1,vector<int>(2,-1));
        vector<vector<int>> dp1(N+1,vector<int>(2,-1));
        return min(f(graph,1,0,-1,dp),f(graph,1,1,-1,dp1)+1);
    }
    
    int f(vector<int> graph[],int src,int isLighted,int prnt,vector<vector<int>>& dp) {
        if(dp[src][isLighted]!=-1) return dp[src][isLighted];
        int ans=0;
        for(int nbr : graph[src]) {
            if(nbr!=prnt) {
                if(isLighted==0) {
                    int f1 = f(graph,nbr,1,src,dp);
                    ans+=f1+1;
                } else {
                    int f0 = f(graph,nbr,0,src,dp);
                    int f1 = f(graph,nbr,1,src,dp);
                    ans+=min(f0,f1+1);
                }
            }
        }
        return dp[src][isLighted]=ans;
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
        vector<vector<int>>edges;
        for(int i = 0; i < N-1; i++){
            int x,y;
            cin >> x >> y;
            vector<int> edge;
            edge.push_back(x);
            edge.push_back(y);
            edges.push_back(edge);
        }
        
        Solution ob;
        cout << ob.countVertex(N, edges) << endl;
    }
    return 0; 
} 
// } Driver Code Ends