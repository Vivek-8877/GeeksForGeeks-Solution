//{ Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

//Back-end complete function Template for C++

class Solution{
    public:
    bool isScramble(string S1, string S2){
        //code here
        int n = S1.length();
        vector<vector<vector<vector<int>>>> dp(n,
                vector<vector<vector<int>>>(n,
                        vector<vector<int>>(n,vector<int>(n,-1))));
        return isValid(S1,S2,0,n-1,0,n-1,dp)==1;
    }    
    
    static int isValid(string s1,string s2,int lo1,int hi1,int lo2,int hi2,
                            vector<vector<vector<vector<int>>>>& dp) {
        if(s1.substr(lo1,hi1-lo1+1)==s2.substr(lo2,hi2-lo2+1)) return 1;
        
        if(dp[lo1][hi1][lo2][hi2]!=-1) return dp[lo1][hi1][lo2][hi2];
        bool ans=true;
        for(int i=lo1,j=hi2;i<=hi1 && ans;i++,j--) {
            if(s1[i]!=s2[j]) ans=false;
        }
        
        for(int i=0;i<hi1-lo1 && !ans;i++) {
            if(isValid(s1,s2,lo1,lo1+i,lo2,lo2+i,dp) && 
                isValid(s1,s2,lo1+i+1,hi1,lo2+i+1,hi2,dp)) ans=true;
            if(!ans && isValid(s1,s2,lo1,lo1+i,hi2-i,hi2,dp) && 
                isValid(s1,s2,lo1+i+1,hi1,lo2,hi2-i-1,dp)) ans=true;
        }
        int an;
        if(ans) {
            an=1;
        } else {
            an=0;
        }
        return dp[lo1][hi1][lo2][hi2]=an;
    }
};



//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--){
        string S1, S2;
        cin>>S1>>S2;
        Solution ob;
        
        if (ob.isScramble(S1, S2)) {
            cout << "Yes";
        }
        else {
            cout << "No";
        }
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends