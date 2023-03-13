//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
#define ll long long int
class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Compleixty :- O(1);
    long long maxPossibleValue(int N,vector<int> A, vector<int> B) {
        // code here
        ll ans=0;
        ll pv=0;
        ll mn=INT_MAX;
        for(int i=0;i<N;i++) {
            ll side=A[i];
            ll fre=B[i]/4;
            ans+=(4*side*fre);
            if(B[i]!=1) mn = min(side,mn);
            if(B[i]%4==2 || B[i]%4==3) {
                if(pv==0) {
                    pv=side;
                } else {
                    ans+=(2*pv)+(2*side);
                    pv=0;
                }
            }
        }
        if(pv!=0) {
            ans = max(ans,ans-2*mn+2*pv);
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        vector<int> A(N), B(N);
        for(int i=0;i<N;i++){
            cin>>A[i];
        }
        for(int i=0;i<N;i++){
          cin>>B[i];
        }
        Solution obj;
        auto ans = obj.maxPossibleValue(N,A,B);
        cout<<ans<<endl;
    }
} 
// } Driver Code Ends