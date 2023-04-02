//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int knightInGeekland(int start_x,int start_y,vector<vector<int>> &arr){
        // Code here
        int  step[8][2] = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};
        int n = arr.size(),m=arr[0].size();
        vector<vector<int>> visit(n,vector<int>(m,0));
        queue<pair<int,int>> dq;
        dq.push({start_x,start_y});
        vector<int> points;
        while(dq.size()>0) {
            int s = dq.size();
            int point=0;
            while(s-->0) {
                pair<int,int> idx = dq.front();
                dq.pop();
                int i=idx.first,j=idx.second;
                if(visit[i][j]==1) continue;
                visit[i][j]=1;
                point+=arr[i][j];
                for(int k=0;k<8;k++) {
                    if(i+step[k][0]>=0 && i+step[k][0]<n && j+step[k][1]>=0 && j+step[k][1]<m) {
                        if(visit[i+step[k][0]][j+step[k][1]]==0) {
                            dq.push({i+step[k][0],j+step[k][1]});
                        }
                    }
                }
            }
            points.push_back(point);
        }
        int ans=0,max_point=0;
        for(int i=0;i<points.size();i++) {
            int idx=i;
            int score=0;
            while(idx<points.size()) {
                score+=points[idx];
                if(points[idx]==0) break;
                idx+=points[idx];
            }
            if(max_point<score) {
                max_point=score;
                ans=i;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m,start_x,start_y;
        cin>>n>>m>>start_x>>start_y;
        vector<vector<int>> arr(n,vector<int>(m));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin>>arr[i][j];
            }
        }
        Solution ob;
        cout<<ob.knightInGeekland(start_x,start_y,arr)<<endl;
    }
}
// } Driver Code Ends