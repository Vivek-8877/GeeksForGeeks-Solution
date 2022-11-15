// Problem Link :- https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1
// Video Solution Link :- 

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    // Time Complexity :- O(n*n*26) => O(n^2);
    // space Complexity :- O(26) => O(1);
    
    int beautySum(string s) {
        // Your code goes here
        int ans=0;
        for(int i=0;i<s.length();i++) {
            vector<int> fre(26,0);
            for(int j=i;j<s.length();j++) {
                fre[s[j]-'a']++;
                ans+=find(fre);
            }
        }
        return ans;
    }
    
    int find(vector<int> fre) {
        int mx=INT_MIN,mn=INT_MAX;
        for(int f : fre) {
            if(f==0) continue;
            mx = max(mx,f);
            mn = min(mn,f);
        }
        return mx-mn;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.beautySum(s) << endl;
    }
    return 0;
}
// } Driver Code Ends
