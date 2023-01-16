//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User Function Template for C++ solution

class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    #define ll long long int
    vector<long long> nextLargerElement(vector<long long> &arr, int n){
        // Your code here
        vector<ll> ans(n,0);
        stack<ll> stk;
        for(int i=n-1;i>=0;i--) {
            while(stk.size()>0 && stk.top()<arr[i]) {
                stk.pop();
            }
            if(stk.size()==0) {
                ans[i]=-1;
            } else {
                ans[i]=stk.top();
            }
            stk.push(arr[i]);
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        
        int n;
        cin>>n;
        vector<long long> arr(n);
        for(int i=0;i<n;i++)
            cin>>arr[i];
        
        Solution ob;
        
        vector <long long> res = ob.nextLargerElement(arr, n);
        for (long long i : res) cout << i << " ";
        cout<<endl;
    }
	return 0;
}

// } Driver Code Ends