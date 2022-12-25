// Problem Link :- https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
// Video Solution Link :- 

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

#define ll long long int
class Solution {
public:
    // Time Complexity :- O(n*n);
    // Space Complexity :- O(2*n);
    long long int MissingNo(vector<vector<int> >& matrix) {
        // Code here
        int n = matrix.size();
        int idx=-1,jdx=-1;
        ll d1=0,d2=0,actual_sum=0;
        vector<vector<ll>> sum(n,vector<ll>(2,0));
        // sum[i][0] --> Sum of jth Row   &&  sum[i][1] --> Sum of ith column
        for(int i=0;i<n;i++) {
            bool isChanged = false;
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    idx=i;
                    jdx=j;
                    isChanged=true;
                }
                if(i==j) {
                    d1+=matrix[i][j];
                }
                if(i==n-j-1) {
                    d2+=matrix[i][j];
                }
                sum[i][0]+=matrix[i][j];
                sum[i][1]+=matrix[j][i];
            }
            if(!isChanged) actual_sum=sum[i][0];
        }
        
        ll ans= actual_sum-sum[idx][0];
        if(ans<=0) return -1;
        
        sum[idx][0]+=ans;
        sum[jdx][1]+=ans;
        if(idx==jdx) d1+=ans;
        if(idx==n-jdx-1) d2+=ans;
        
        for(int i=0;i<n;i++) {
            if(sum[i][0]!=actual_sum || sum[i][1]!=actual_sum) return -1;
        }
        if(d1!=actual_sum || d2!=actual_sum) return -1;
        
        return ans;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>> matrix(n, vector<int>(n,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> matrix[i][j];
			}
		}
		Solution ob;
		long long int ans = ob.MissingNo(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends
