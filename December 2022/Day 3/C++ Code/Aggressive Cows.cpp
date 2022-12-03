// Problem Link :- https://practice.geeksforgeeks.org/problems/aggressive-cows/1
// Video Solution Link :- https://youtu.be/7OvKCVz79sc

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
public:
    // Time Complexity :- O(n.log(10^9));
    // Space Complexity :- O(1);
    
    int solve(int n, int k, vector<int> &stalls) {
    
        // Write your code here
        sort(stalls.begin(),stalls.end());
        int lo=0,hi=stalls[stalls.size()-1];
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(isValid(stalls,k,mid)) {
                ans = max(ans,mid);
                lo=mid+1;
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
    
    bool isValid(vector<int> a,int k,int dis) {
        int pidx=0;
        for(int i=1;i<a.size();i++) {
            if(a[i]-a[pidx]>=dis) {
                k--;
                pidx=i;
            }
        }
        return k<=1;
    }
};

//{ Driver Code Starts.

int main() {
    int t = 1;
    cin >> t;

    // freopen ("output_gfg.txt", "w", stdout);

    while (t--) {
        // Input

        int n, k;
        cin >> n >> k;

        vector<int> stalls(n);
        for (int i = 0; i < n; i++) {
            cin >> stalls[i];
        }
        // char ch;
        // cin >> ch;

        Solution obj;
        cout << obj.solve(n, k, stalls) << endl;

        // cout << "~\n";
    }
    // fclose(stdout);

    return 0;
}
// } Driver Code Ends
