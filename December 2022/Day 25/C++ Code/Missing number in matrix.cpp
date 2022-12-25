// Problem Link :- https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
// Video Solution Link :- https://youtu.be/2mFvPNUVu7Q

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


#define ll long long int
class Solution {
public:
    // Time Complexity :- O(n*n);
    // Space Complexity :- O(1);
    long long int MissingNo(vector<vector<int> >& matrix) {
        // Code here
        int n = matrix.size();
        int idx=-1,jdx=-1;
        ll expected_sum=-1,required_sum=-1,sum=0;
        for(int i=0;i<n;i++) {
            bool isChanged = false;
            sum=0;
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    idx=i;
                    jdx=j;
                    isChanged=true;
                }
                sum+=matrix[i][j];
            }
            if(isChanged) {
                required_sum=sum;
            } else {
                expected_sum=sum;
            }
            if(idx!=-1 && jdx!=-1 && required_sum!=-1 && expected_sum!=-1) break;
        }
        
        ll ans= expected_sum-required_sum;
        if(ans<=0) return -1;
        
        ll d1=0,d2=0,row_sum=0,col_sum=0,val1=0,val2=0;
        for(int i=0;i<n;i++) {
            row_sum=0;
            col_sum=0;
            for(int j=0;j<n;j++) {
                val1=matrix[i][j];
                val2=matrix[j][i];
                if(j==idx && i==jdx) val2=ans;
                if(i==idx && j==jdx) val1=ans;
                row_sum+=val1;
                col_sum+=val2;
                if(i==j) d1+=val1;
                if(i==n-j-1) d2+=val1;
            }
            if(row_sum!=expected_sum || col_sum!=expected_sum) return -1;
        }
        
        if(d1!=expected_sum || d2!=expected_sum) return -1;
        
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
