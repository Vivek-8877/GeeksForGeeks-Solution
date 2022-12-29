//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    vector<int> asteroidCollision(int N, vector<int> &asteroids) {
        // code here
        stack<int> stk;
        for(int i=0;i<N;i++) {
            while(stk.size()>0 && asteroids[i]!=0) {
                int idx = stk.top();
                if(asteroids[i]<0 && asteroids[idx]>0) {
                    // left-movement - right-movement
                    if(-asteroids[i]<asteroids[idx]) {
                        asteroids[i]=0;
                    } else if(-asteroids[i]==asteroids[idx]) {
                        asteroids[i]=0;
                        asteroids[idx]=0;
                        stk.pop();
                    } else {
                        asteroids[idx]=0;
                        stk.pop();
                    }
                } else {
                    break;
                }
            }
            
            if(asteroids[i]!=0) {
                stk.push(i);
            }
        }
        
        vector<int> ans(stk.size());
        int idx=ans.size()-1;
        while(stk.size()>0) {
            ans[idx]=asteroids[stk.top()];
            stk.pop();
            idx--;
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
        cin >> N;

        vector<int> asteroids(N);
        for (int i = 0; i < N; i++) cin >> asteroids[i];

        Solution obj;
        vector<int> ans = obj.asteroidCollision(N, asteroids);
        for (auto &it : ans) cout << it << ' ';
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends