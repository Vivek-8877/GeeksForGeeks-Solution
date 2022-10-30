//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	
	// Time Complexity :- O(n)
	long long int NoOfChicks(int n){
	    // Code here
	    long long int dp[n+1][2];
        dp[1][0]=1;
        dp[1][1]=1;
        
        for(int i=2;i<=n;i++) {
            if(i>6) {
                dp[i][1]=((dp[i-1][0]-dp[i-6][1])*2);
                
                dp[i][0]=dp[i][1]+dp[i-1][0]-dp[i-6][1];
            } else {
                dp[i][1]=(dp[i-1][0]*2);
                
                dp[i][0]=dp[i][1]+dp[i-1][0];
            }
        }
        
        return dp[n][0];
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution obj;
		long long int ans = obj.NoOfChicks(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends
