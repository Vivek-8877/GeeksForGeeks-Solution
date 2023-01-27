//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
		int mod = 1000000007;
		int CountWays(string str){
		    // Code here
		    vector<vector<int>> dp(str.length(),vector<int>(28,-1));
		    return f(str,0,-1,dp);
		}
		
		int f(string s,int idx,int val,vector<vector<int>>& dp) {
            if(val==0 || val>26) return 0;
            if(idx>=s.length()) {
                return 1;
            }
            if(dp[idx][val+1]!=-1) return dp[idx][val+1];
            int ans=0;
            ans = add(ans,f(s,idx+1,s[idx]-'0',dp));
            if(idx!=0) ans = add(ans,f(s,idx+1,(10*val)+(s[idx]-'0'),dp));
            
            return dp[idx][val+1]=ans;
        }
        
        int add(int a,int b) {
            return ((a%mod)+(b%mod))%mod;
        }

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution obj;
		int ans = obj.CountWays(str);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends