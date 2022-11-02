// Problem Link :- https://practice.geeksforgeeks.org/problems/enemy/1
// Video Solution Link :- https://www.youtube.com/watch?v=oer2YIPWDgI


//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution
{
    // Time Complexity :- O(k.log(k));
    // Space Complexity :- O(k);
    public:
        int largestArea(int n,int m,int k,vector<vector<int>> &enemy)
        {
            //  code here
            if(k==0) return m*n;
            vector<int> col;
            vector<int> row;
            for(vector<int> a : enemy) {
                row.push_back(a[0]);
                col.push_back(a[1]);
            }
            sort(col.begin(),col.end());
            int max_column=col[0]-1;
            for(int i=0;i<col.size();i++) {
                if(i==col.size()-1) {
                    max_column = max(max_column,(m+1)-col[i]-1);
                } else {
                    max_column = max(max_column,col[i+1]-col[i]-1);
                }
            }
            sort(row.begin(),row.end());
            int max_row = row[0]-1;
            for(int i=0;i<row.size();i++) {
                if(i==enemy.size()-1) {
                    max_row = max(max_row,(n+1)-row[i]-1);
                } else {
                    max_row = max(max_row,row[i+1]-row[i]-1);
                }
            }
            return max_row*max_column;
        }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        int k;
        cin>>k;
        vector<vector<int>> e(k,vector<int>(2));
        for(int i=0;i<k;i++)
            cin>>e[i][0]>>e[i][1];
        Solution a;
        cout<<a.largestArea(n,m,k,e)<<endl;
    }
    return 0;
}
// } Driver Code Ends
