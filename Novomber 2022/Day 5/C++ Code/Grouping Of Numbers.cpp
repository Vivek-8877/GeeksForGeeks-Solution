// Problem Link :- https://practice.geeksforgeeks.org/problems/grouping-of-numbers0015/1
// Video Solution Link :- https://www.youtube.com/watch?v=MY2FOOm3wBg

//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(k);
    
    int maxGroupSize(int arr[], int N, int K) {
        // code here
        vector<int> fre(K,0);
        for(int i=0;i<N;i++) {
            fre[arr[i]%K]++;
        }
        
        int ans =0;
        for(int i=0;i<K;i++) {
            if(fre[i]==0) continue;
            int j = K-i;
            if(i==0 || i==j) {
                ans++;
            } else {
                if(fre[j]!=0) {
                    ans+=max(fre[i],fre[j]);
                    fre[j]=0;
                } else {
                    ans+=fre[i];
                }
                fre[i]=0;
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
        int N,K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution ob;
        cout << ob.maxGroupSize(arr,N,K) << endl;
    }
    return 0;
}
// } Driver Code Ends
