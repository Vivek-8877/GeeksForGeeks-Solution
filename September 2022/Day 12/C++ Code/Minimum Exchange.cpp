//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
public:
int MinimumExchange(vector<vector<char>>matrix){
    // Code here
    return min(solve(matrix,'A'),solve(matrix,'B'));
}

int solve(vector<vector<char>>matrix,char c_start) {
    int ans=0;
    for(vector<char> mat : matrix) {
        char next = (c_start=='A' ? 'B' : 'A');
        for(char ch : mat) {
            if(ch!=c_start) {
                ans++;
            }
            c_start = (c_start=='A' ? 'B' : 'A');
        }
        c_start=next;
    }
    return ans;
}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<char>>matrix(n, vector<char>(m,'x'));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> matrix[i][j];
		}
		Solution obj;
		int ans = obj.MinimumExchange(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends
