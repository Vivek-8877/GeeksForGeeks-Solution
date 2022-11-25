//{ Driver Code Starts
//Initial Template for C++

#include <iostream>
using namespace std;


// } Driver Code Ends
//User function Template for C++
#include <vector>
#include <bits/stdc++.h>
class Solution{
public:
    // Time Complexity :- O(log(n))+O(log(n)*number of set bit*2) => O(log(n));
    // Space Complexity :- O(log(n))+O(log(n)*number of set bit*2) => O(log(n));
    long long count(long long x) {
        // Code Here
        vector<int> list;
        int ct=0;
        while(x>0) {
            if(x%2==0) {
                list.push_back(0);
            } else {
                list.push_back(1);
                ct++;
            }
            x/=2;
        }
        reverse(list.begin(),list.end());
        vector<vector<vector<long long>>> dp(list.size(),vector<vector<long long>>(ct+1,vector<long long>(2,-1)));
        return f(list,0,ct,0,dp)-1;
    }
    
    long f(vector<int> num,int idx,int ct,int turn,vector<vector<vector<long long>>>& dp) {
        if(idx>=num.size()) {
            if(ct!=0) return 0;
            return 1;
        }
        if(ct==0) {
            return 1;
        }
        if(dp[idx][ct][turn]!=-1) return dp[idx][ct][turn];
        long long ans;
        if(num[idx]==1) {
            ans = f(num,idx+1,ct-1,turn,dp)+f(num,idx+1,ct,1,dp);
        } else {
            if(turn==0) {
                ans = f(num,idx+1,ct,turn,dp);
            } else {
                ans = f(num,idx+1,ct-1,turn,dp)+f(num,idx+1,ct,1,dp);
            }
        }
        
        return dp[idx][ct][turn]=ans;
    }
    
};

//{ Driver Code Starts.

int main() {
    
	int t;
	cin >> t;
	while (t-- > 0) {
	    long long x; cin >> x;
	    Solution ob;
	    cout << ob.count(x) << '\n';
	}
	return 0;
}
// } Driver Code Ends
