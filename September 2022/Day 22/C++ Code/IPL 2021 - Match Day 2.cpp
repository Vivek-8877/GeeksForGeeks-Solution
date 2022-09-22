//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
  
//   T.C :- O(n)
    vector<int> max_of_subarrays(vector<int> arr, int n, int k) {
        // your code here
        vector<int> ans;
        deque<int> list;
        for(int i=0;i<n;i++) {
            
            while(list.size()>0 && arr[list.back()]<=arr[i]) {
                list.pop_back();
            }
            
            list.push_back(i);
            
            if(list.front()<=i-k) list.pop_front();
            
            if(i-k+1>=0) ans.push_back(arr[list.front()]);
        }
        return ans;
    }
    
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;

    while (t--) {

        int n, k;
        cin >> n >> k;

        vector<int> arr(n);
        for (int i = 0; i < n; i++) cin >> arr[i];
        Solution ob;
        vector<int> res = ob.max_of_subarrays(arr, n, k);
        for (int i = 0; i < res.size(); i++) cout << res[i] << " ";
        cout << endl;
    }

    return 0;
}
// } Driver Code Ends
