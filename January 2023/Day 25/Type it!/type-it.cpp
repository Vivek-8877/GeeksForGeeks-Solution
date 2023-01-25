//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1);
    int minOperation(string s) {
        // code here
        int ans=s.length();
        for(int i=0;i<s.length()/2;i++) {
            bool isValid=true;
            for(int j=0;j<=i && isValid;j++) {
                if(s[j]!=s[j+i+1]) {
                    isValid=false;
                }
            }
            if(isValid) ans = s.length()-i;
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.minOperation(s) << "\n";
    }
    return 0;
}

// } Driver Code Ends