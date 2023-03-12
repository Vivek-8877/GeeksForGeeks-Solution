//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
public:
    vector<int> findMaxRow(vector<vector<int>> mat, int N) {
        //code here
        vector<int> ans(2,0);
        for(int i=0;i<N;i++) {
            int ix = search(mat[i]);
            if(N-ix>ans[1]) {
                ans[1]=N-ix;
                ans[0]=i;
            }
        }
        return ans;
    }
    int search(vector<int> a) {
        int lo=0,hi=a.size()-1,ans=a.size();
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]==1) {
                hi=mid-1;
                ans=min(ans,mid);
            } else {
                lo=mid+1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
	int t;
    cin>>t;
    while(t--) {
        int n;
        cin>>n;
        vector<vector<int>> arr(n, vector<int> (n));
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                cin >> arr[i][j];
        Solution obj;
        vector<int> ans = obj.findMaxRow(arr, n);
        for(int val : ans) {
            cout << val << " ";
        }
        cout << endl;
    }
}
// } Driver Code Ends