// Problem Link :- https://practice.geeksforgeeks.org/problems/af49b143a4ead583e943ca6176fbd7ea55b121ae/1
// Video Solution Link :- https://youtu.be/HZkFMpu4EJs

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    // Time Complexity :- O(2n.log(2n)) + O(n.log(n)) + O(n.log(n)) + O(2n.log(n)) => O(n.log(n));
    // Space Complexity :- O(2n) => O(n);
    int minLaptops(int N, int start[], int end[]) {
        // Code here
        vector<int> list;
        for(int i=0;i<N;i++) {
            list.push_back(start[i]);
            list.push_back(end[i]);
        }
        
        sort(list.begin(),list.end());
        sort(start,start+N);
        sort(end,end+N);
        
        int ans=0;
        for(int i=0;i<list.size()-1;i++) {
            int user = startedBefore(start,list[i+1],N)-endedBeforeOrEqualTo(end,list[i],N);
            ans = max(ans,user);
        }
        
        return ans;
    }
    
    int startedBefore(int a[],int val,int N) {
        int lo=0,hi=N-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<val) {
                lo=mid+1;
                ans = max(ans,lo);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
    
    int endedBeforeOrEqualTo(int a[],int val,int N) {
        int lo=0,hi=N-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<=val) {
                lo=mid+1;
                ans = max(ans,lo);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        int start[N], end[N];
        for(int i=0; i<N; i++)
            cin>>start[i];
        for(int i=0; i<N; i++)
            cin>>end[i];
            
        Solution ob;
        cout << ob.minLaptops(N, start, end) << endl;
    }
}
// } Driver Code Ends
