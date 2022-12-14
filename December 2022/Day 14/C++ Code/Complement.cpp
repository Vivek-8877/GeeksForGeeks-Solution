// Problem Link :- https://practice.geeksforgeeks.org/problems/complement3911/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
class Solution{
public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    vector<int> findRange(string str, int n) {
        // code here
        vector<int> ans;
        int sum=0,maxSum=0;
        for(int i=0;i<n;i++) {
            int v = str[i]-'0';
            if(v==0) {
                v=1;
            } else {
                v=-1;
            }
            if(sum+v<v) {
                sum=v;
            } else {
                sum+=v;
            }
            maxSum=max(maxSum,sum);
        }
        sum=0;
        // System.out.println(maxSum);
        if(maxSum==0) {
            ans.push_back(-1);
        } else {
            int strt=0;
            for(int i=0;i<n;i++) {
                int v = str[i]-'0';
                if(v==0) {
                    v=1;
                } else {
                    v=-1;
                }
                
                if(sum+v<v) {
                    sum=v;
                    strt=i;
                } else {
                    sum+=v;
                }
                
                if(sum==maxSum) {
                    ans.push_back(strt+1);
                    ans.push_back(i+1);
                    break;
                }
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        string s;
        cin >> s;
        Solution ob;
        auto ans = ob.findRange(s, n);

        if (ans.size() == 1) {
            cout << ans[0] << "\n";
        } else {
            cout << ans[0] << " " << ans[1] << "\n";
        }
    }
    return 0;
}
// } Driver Code Ends
