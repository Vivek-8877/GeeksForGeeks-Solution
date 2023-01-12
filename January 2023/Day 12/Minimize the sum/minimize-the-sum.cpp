//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
public:
    
    int minimizeSum(int N, vector<int> arr) {
        // code here
        priority_queue<int , vector<int>, greater<int>> pq;
        for(int a : arr) pq.push(a);
        int ans=0,sum=0;
        while(pq.size()>1) {
            sum = pq.top();
            pq.pop();
            sum+=pq.top();
            pq.pop();
            pq.push(sum);
            ans+=sum;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
	int t;
    cin>>t;
    while(t--) {
        int n;
        cin>>n;
        vector<int> arr(n);
        for(int i = 0; i < n; i++)
            cin>>arr[i];
        Solution obj;
        cout << obj.minimizeSum(n, arr) << "\n";
    }
}
// } Driver Code Ends