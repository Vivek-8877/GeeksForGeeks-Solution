// Problem Link :- https://practice.geeksforgeeks.org/problems/number-of-open-doors1552/1
// Video Solution Link :-

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(log(N));
    // Space Complexity :- O(1);
    
    int noOfOpenDoors(long long N) {
        // code here
        double ans = sqrt(N+1)-1;
        return ceil(ans);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        long long N;
        
        cin>>N;

        Solution ob;
        cout << ob.noOfOpenDoors(N) << endl;
    }
    return 0;
}
// } Driver Code Ends
