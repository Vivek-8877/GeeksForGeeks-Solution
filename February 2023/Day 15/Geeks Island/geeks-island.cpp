//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    int water_flow(vector<vector<int>> &mat,int N,int M){
    // Write your code here.
        
        vector<vector<int>> pacific_dq;
        vector<vector<int>> atlantic_dq;
        
        for(int i=0;i<N;i++) {
            pacific_dq.push_back({i,0});
            atlantic_dq.push_back({i,M-1});
        }
        
        for(int i=0;i<M;i++) {
            pacific_dq.push_back({0,i});
            atlantic_dq.push_back({N-1,i});
        }
        
        
        vector<vector<int>> is_connected_pacific = bfs(pacific_dq,mat);
        vector<vector<int>> is_connected_atlantic = bfs(atlantic_dq,mat);
        
        vector<vector<int>> ans;
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(is_connected_pacific[i][j]==1 && is_connected_atlantic[i][j]==1) {
                    // vector<int> index{i,j};
                    ans.push_back({i,j});
                }
            }
        }
        return ans.size();
    }
    
    vector<vector<int>> bfs(vector<vector<int>>& dq,vector<vector<int>>& heights) {
        vector<vector<int>> visit(heights.size(),vector<int>(heights[0].size(),0));
        
        while(dq.size()>0) {
            vector<int> index = dq.back();
            dq.pop_back();
            int i = index[0];
            int j = index[1];
            visit[i][j]=1;
            
            // north or up
            if(isValid(visit,i-1,j) && heights[i-1][j]>=heights[i][j]) {
                dq.push_back({i-1,j});
            }
            
            // south or down
            if(isValid(visit,i+1,j) && heights[i+1][j]>=heights[i][j]) {
                dq.push_back({i+1,j});
            }
            
            // east or left
            if(isValid(visit,i,j-1) && heights[i][j-1]>=heights[i][j]) {
                dq.push_back({i,j-1});
            }
            
            // west or right
            if(isValid(visit,i,j+1) && heights[i][j+1]>=heights[i][j]) {
                dq.push_back({i,j+1});
            }
        }
        return visit;
    }
    
    bool isValid(vector<vector<int>>& visit,int i,int j) {
        if(i<0 || j<0 || i>=visit.size() || j>=visit[0].size() || visit[i][j]==1) return false;
        return true;
    }
};



//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        vector<vector<int>> mat(n, vector<int>(m));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin>>mat[i][j];
            }
        }
        Solution ob;
        cout << ob.water_flow(mat, n, m) << endl;
        
    }
}


// } Driver Code Ends
