// Problem Link :- https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
// Video Solution Link :- 

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution 
{
    public:
    // Time Complexity :- O(n*m);
    // Space Complexity :- O(n*m);
    //Function to find distance of nearest 1 in the grid for each cell.
	vector<vector<int>>nearest(vector<vector<int>>grid)
	{
	    // Code here
	    int n = grid.size(),m=grid[0].size();
        vector<vector<int>> ans(n,vector<int>(m));
        queue<pair<int,int>> dq;
        pair<int,int> p1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    p1.first=i;
                    p1.second=j;
                    dq.push(p1);
                    ans[i][j]=0;
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        
        while(dq.size()>0) {
            int s = dq.size();
            while(s-->0) {
                pair<int,int> p = dq.front();
                dq.pop();
                int i=p.first,j=p.second;
                if(isValid(i+1,j,n,m,ans)) {
                    p1.first=i+1;
                    p1.second=j;
                    dq.push(p1);
                    ans[i+1][j]=ans[i][j]+1;
                }
                if(isValid(i,j+1,n,m,ans)) {
                    p1.first=i;
                    p1.second=j+1;
                    dq.push(p1);
                    ans[i][j+1]=ans[i][j]+1;
                }
                if(isValid(i-1,j,n,m,ans)) {
                    p1.first=i-1;
                    p1.second=j;
                    dq.push(p1);
                    ans[i-1][j]=ans[i][j]+1;
                }
                if(isValid(i,j-1,n,m,ans)) {
                    p1.first=i;
                    p1.second=j-1;
                    dq.push(p1);
                    ans[i][j-1]=ans[i][j]+1;
                }
            }
        }
        return ans;
	}
	
	bool isValid(int i,int j,int n,int m,vector<vector<int>>& ans) {
        if(i<0 || j<0 || i>=n || j>=m || ans[i][j]!=-1) return false;
        return true;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>grid(n, vector<int>(m, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		vector<vector<int>> ans = obj.nearest(grid);
		for(auto i: ans){
			for(auto j: i){
				cout << j << " ";
			}
			cout << "\n";
		}
	}
	return 0;
}
// } Driver Code Ends
