// Problem Link :- https://practice.geeksforgeeks.org/problems/f04fd67b26b4828b6180715d8b1700426b637247/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(N*log(sum(arr)));
    // Space Compexity :- O(1);
    int splitArray(int arr[] ,int N, int K) {
        // code here
        int totalSum =0,mx=INT_MIN;
        for(int i=0;i<N;i++) {
            totalSum+=arr[i];
            mx = max(mx,arr[i]);
        }
        
        int lo=mx,hi=totalSum,ans=INT_MAX;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(isValid(arr,mid,K,N)) {
                ans=min(ans,mid);
                hi=mid-1;   // To minimize our answer
            } else {
                lo=mid+1;   // To get Valid Range
            }
        }
        return ans;
    }
    // to check if requiredSum is possible to get by splitting array in k or less then k subarray
    bool isValid(int arr[],int requiredSum,int k,int n) {
        int sum=0,count=1;
        for(int i=0;i<n;i++) {
            if(sum+arr[i]<=requiredSum) {
                sum+=arr[i];
            } else {
                sum=arr[i];
                count++;
            }
        }
        return count<=k;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0 ; i<N ; i++)
            cin>>arr[i];

        Solution ob;
        cout<<ob.splitArray(arr,N,K);
        cout<<"\n";
    }
    return 0;
}
// } Driver Code Ends
