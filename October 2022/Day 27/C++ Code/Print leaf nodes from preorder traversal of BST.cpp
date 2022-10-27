//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    vector<int> leafNodes(int arr[],int N) {
        // code here
        return f(arr,0,N-1);
    }
    
    vector<int> f(int a[],int lo,int hi) {
        if(lo>hi) {
            vector<int> ans;
            return ans;
        }
        if(hi==lo) {
            vector<int> ans;
            ans.push_back(a[lo]);
            return ans;
        }
        
        
        int idx = lo;
        for(int i=lo+1;i<=hi;i++) {
            if(a[i]<a[lo]) {
                idx=i;
            } else {
                break;
            }
        }
        
        
        vector<int> left = f(a,lo+1,idx);
        vector<int> right = f(a,idx+1,hi);
        
        vector<int> ans;
        for(int val : left) {
            ans.push_back(val);
        }
        
        for(int val : right) {
            ans.push_back(val);
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
        int N;
        cin >> N;
        int arr[N];
        for(int i=0;i<N;i++)cin>>arr[i];
        Solution ob;
        vector<int>ans=ob.leafNodes(arr,N);
        for(int i=0;i<ans.size();i++)cout<<ans[i]<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends
