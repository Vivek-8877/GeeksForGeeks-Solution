// Problem Link :- https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(10^5) or O(n);
    // Time Complexity :- O(10^5) or O(n);
    bool canPair(vector<int> nums, int k) {
        // Code here.
        if(nums.size()%2==1) return false;
        
        vector<int> fre(100001,0);
        for(int num : nums) {
            int num1 = num%k;
            if(fre[(k-num1)%k]!=0) {
                fre[(k-num1)%k]--;
            } else {
                fre[num1]++;
            }
        }
        for(int f : fre) {
            if(f>0) return false;
        }
        return true;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, k;
        cin >> n >> k;
        vector<int> nums(n);
        for (int i = 0; i < nums.size(); i++) cin >> nums[i];
        Solution ob;
        bool ans = ob.canPair(nums, k);
        if (ans)
            cout << "True\n";
        else
            cout << "False\n";
    }
    return 0;
}
// } Driver Code Ends
