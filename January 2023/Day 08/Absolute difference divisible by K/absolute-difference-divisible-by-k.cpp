//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
  Time Com
    long long countPairs(int n, int arr[], int k) {
        // code here
        long long int ans=0;
        map<int,int> mp;
        for(int i=0;i<n;i++) {
            arr[i]%=k;
            ans+=(long long int)mp[arr[i]];
            mp[arr[i]]++;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n,k;
        cin>>n;
        
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        
        cin>>k;

        Solution ob;
        cout << ob.countPairs(n,arr,k) << endl;
    }
    return 0;
}
// } Driver Code Ends