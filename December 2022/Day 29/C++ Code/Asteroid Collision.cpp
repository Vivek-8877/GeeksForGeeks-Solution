// Problem Link :- https://practice.geeksforgeeks.org/problems/asteroid-collision/1
// Video Solution Link :- https://youtu.be/zVwsRvAgEhk

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
            while(stk.size()>0) {
                int idx = stk.top();
                if(asteroids[i]<0) {
                    // left-movement
                    if(asteroids[idx]>0) {
                        // right-movement
                        if(-asteroids[i]<asteroids[idx]) {
                            asteroids[i]=0;
                            break;
                        } else if(-asteroids[i]==asteroids[idx]) {
                            asteroids[i]=0;
                            asteroids[idx]=0;
                            stk.pop();
                            break;
                        } else {
                            asteroids[idx]=0;
                            stk.pop();
                        }
                    } else {
                        // left-movement
                        break;
                    }
                } else if(asteroids[i]==0) {
                    break;
                } else {
                    // right-movement
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
