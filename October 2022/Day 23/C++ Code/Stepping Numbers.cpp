//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
public:

    int steppingNumbers(int n, int m)
    {
        // Code Here
        string s = to_string(n-1);
        string t = to_string(m);
        vector<vector<vector<int>>> dpt(t.length(),vector<vector<int>>(11,vector<int>(2,-1)));
        int ans = f(t,0,-1,1,dpt);
        if(n>1) {
            vector<vector<vector<int>>> dps(s.length(),vector<vector<int>>(11,vector<int>(2,-1)));
            ans-= f(s,0,-1,1,dps);
        } else if(n==1) {
            ans-=1;
        }
        return ans;
    }
    
    // T.C :- O(n.length()*11*2) => O(log(n)*11*2)
    
    int f(string n,int idx,int pd,int tight,vector<vector<vector<int>>>& dp) {
        if(idx>=n.length()) return 1;
        
        if(dp[idx][pd+1][tight]!=-1) return dp[idx][pd+1][tight];
        
        int ans =0;
        
        if(pd==-1) {
            for(int i=0;i<=9;i++) {
                if(i==0) {
                    ans+=f(n,idx+1,-1,0,dp);
                } else {
                    if(tight==1 && n[idx]-'0'==i) {
                        ans+=f(n,idx+1,i,1,dp);
                        break;
                    }
                    ans+=f(n,idx+1,i,0,dp);
                }
            }
        } else {
            if(tight==1) {
                if(pd-1>=0) {
                    if(pd-1==n[idx]-'0') {
                        ans+=f(n,idx+1,pd-1,1,dp);
                    } else if(pd-1<n[idx]-'0') {
                        ans+=f(n,idx+1,pd-1,0,dp);
                    }
                }
                
                if(pd+1<=9) {
                    if(pd+1==n[idx]-'0') {
                        ans+=f(n,idx+1,pd+1,1,dp);
                    } else if(pd+1<n[idx]-'0') {
                        ans+=f(n,idx+1,pd+1,0,dp);
                    }
                }
            } else {
                if(pd-1>=0) ans+=f(n,idx+1,pd-1,0,dp);
                if(pd+1<=9) ans+=f(n,idx+1,pd+1,0,dp);
            }
        }
        
        return dp[idx][pd+1][tight]=ans;
    }
    
};


//{ Driver Code Starts.

int main()
{
    Solution obj;
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        cin>>n>>m;
        cout << obj.steppingNumbers(n,m) << endl;
    }
	return 0;
}


// } Driver Code Ends
