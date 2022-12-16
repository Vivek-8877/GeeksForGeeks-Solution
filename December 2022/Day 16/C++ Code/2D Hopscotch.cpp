// Problem Link :- https://practice.geeksforgeeks.org/problems/hopscotch4857/1
// Video Solution is Commin Soon :- https://youtu.be/2YZfVj7l8ds

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    // Time complexity :- O(1);
    // Space Complexity :- O(1);
    int hopscotch(int n, int m, vector<vector<int>> mat, int ty, int i, int j)
    {
        // code here
        int ans=0;
        if(ty==0) {
            if(isValid(i+1,j,n,m)) ans+=mat[i+1][j];    // down
            if(isValid(i-1,j,n,m)) ans+=mat[i-1][j];    // up
            if(j%2==0) {
                if(isValid(i,j+1,n,m)) ans+=mat[i][j+1];    // right-down
                if(isValid(i,j-1,n,m)) ans+=mat[i][j-1];    // left-down
                if(isValid(i-1,j+1,n,m)) ans+=mat[i-1][j+1];    // right-up
                if(isValid(i-1,j-1,n,m)) ans+=mat[i-1][j-1];    // left-up
            } else {
                if(isValid(i,j+1,n,m)) ans+=mat[i][j+1];    // right-up
                if(isValid(i,j-1,n,m)) ans+=mat[i][j-1];    // left-up
                if(isValid(i+1,j+1,n,m)) ans+=mat[i+1][j+1];    // right-down
                if(isValid(i+1,j-1,n,m)) ans+=mat[i+1][j-1];    // left-down
            }
        } else {
            if(isValid(i+2,j,n,m)) ans+=mat[i+2][j];    // down-down
            if(isValid(i-2,j,n,m)) ans+=mat[i-2][j];    // up-up
            if(isValid(i,j+2,n,m)) ans+=mat[i][j+2];    // directly-front
            if(isValid(i,j-2,n,m)) ans+=mat[i][j-2];    // directly-back
            if(j%2==0) {
                if(isValid(i+1,j+1,n,m)) ans+=mat[i+1][j+1];    // right-down-down
                if(isValid(i-2,j+1,n,m)) ans+=mat[i-2][j+1];    // right-up-up
                if(isValid(i+1,j-1,n,m)) ans+=mat[i+1][j-1];    // left-down-down
                if(isValid(i-2,j-1,n,m)) ans+=mat[i-2][j-1];    // left-up-up
                
                if(isValid(i+1,j+2,n,m)) ans+=mat[i+1][j+2];    // right-down-right-down
                if(isValid(i+1,j-2,n,m)) ans+=mat[i+1][j-2];    // left-down-left-down
                if(isValid(i-1,j+2,n,m)) ans+=mat[i-1][j+2];    // right-up-right-up
                if(isValid(i-1,j-2,n,m)) ans+=mat[i-1][j-2];    // left-up-left-up
            } else {
                if(isValid(i-1,j+1,n,m)) ans+=mat[i-1][j+1];    // right-up-up
                if(isValid(i+2,j+1,n,m)) ans+=mat[i+2][j+1];    // right-down-down
                if(isValid(i-1,j-1,n,m)) ans+=mat[i-1][j-1];    // left-up-up
                if(isValid(i+2,j-1,n,m)) ans+=mat[i+2][j-1];    // left-down-down
                
                if(isValid(i-1,j+2,n,m)) ans+=mat[i-1][j+2];    // right-up-right-up
                if(isValid(i-1,j-2,n,m)) ans+=mat[i-1][j-2];    // left-up-left-up
                if(isValid(i+1,j+2,n,m)) ans+=mat[i+1][j+2];    // right-down-right-down
                if(isValid(i+1,j-2,n,m)) ans+=mat[i+1][j-2];    // left-down-left-down
            }
        }
        return ans;
    }
    bool isValid(int i,int j,int n,int m) {
        if(i<0 || j<0 || i>=n || j>=m) return false;
        return true;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, m, ty, i, j;
        cin>>n>>m;
        vector<vector<int>> mat(n, vector<int>(m, 0));
        for(int i = 0;i < n;i++)
            for(int j = 0;j < m;j++)
                cin>>mat[i][j];
        cin>>ty>>i>>j;
        
        Solution ob;
        cout<<ob.hopscotch(n, m, mat, ty, i, j)<<"\n";
    }
    return 0;
}
// } Driver Code Ends
