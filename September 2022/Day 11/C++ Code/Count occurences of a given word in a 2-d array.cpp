//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int findOccurrence(vector<vector<char> > &mat, string target){
        int ans=0;
        for(int i=0;i<mat.size();i++) {
            for(int j=0;j<mat[i].size();j++) {
                vector<vector<int>> visit(mat.size(),vector<int>(mat[0].size(),0));
                ans+=solve(mat,target,i,j,0,visit);
            }
        }
        return ans;
    }
    int solve(vector<vector<char>>& a,string str,int idx,int jdx,int i,vector<vector<int>>& visit) {
        if(idx<0 || jdx<0 || idx>=a.size() || jdx>=a[idx].size() || visit[idx][jdx]==1) return 0;
        if(a[idx][jdx]==str[i]) {
            if(i==str.length()-1) return 1;
        } else {
            return 0;
        }
        
        visit[idx][jdx]=1;
        int lft = solve(a,str,idx,jdx-1,i+1,visit);
        int rt = solve(a,str,idx,jdx+1,i+1,visit);
        int up = solve(a,str,idx-1,jdx,i+1,visit);
        int dn = solve(a,str,idx+1,jdx,i+1,visit);
        visit[idx][jdx]=0;
        return lft+rt+up+dn;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int R, C;
        cin >> R >> C;
        vector<vector<char> > mat(R);
        for (int i = 0; i < R; i++) {
            mat[i].resize(C);
            for (int j = 0; j < C; j++) cin >> mat[i][j];
        }
        string target;
        cin >> target;
        Solution obj;
        cout<<obj.findOccurrence(mat,target)<<endl;
    }
}

// } Driver Code Ends
