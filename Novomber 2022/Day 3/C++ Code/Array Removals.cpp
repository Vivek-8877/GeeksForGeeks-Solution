//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(n);
    
    int removals(vector<int>& arr, int k){
        //Code here
        sort(arr.begin(),arr.end());
        int ans=arr.size();
        for(int i=0;i<arr.size();i++) {
            for(int j=arr.size()-1;j>=i;j--) {
                if(arr[j]-arr[i]<=k) {
                    int required_length =i+(arr.size()-j-1);
                    ans = min(ans,required_length);
                    break;
                }
            }
        }
        return ans;
    }
};


//{ Driver Code Starts.


int main(){
    int t;
    cin>>t;
    
    while(t--){
        int n,k;
        cin>>n>>k;
        vector<int> arr(n);
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        
        Solution ob;
        int ans = ob.removals(arr,k);
        
        cout<<ans<<endl;
    }
}



// } Driver Code Ends
