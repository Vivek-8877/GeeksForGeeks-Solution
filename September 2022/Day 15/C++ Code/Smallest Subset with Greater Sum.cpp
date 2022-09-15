//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int minSubset(vector<int> &Arr,int N){
        sort(Arr.begin(),Arr.end());
        long long int total_sum =0;
        for(long long int n : Arr) {
            total_sum+=n;
        }
        
        long long int included_sum =0;
        for(int i=N-1;i>=0;i--) {
            included_sum+=(long long int)(Arr[i]);
            long long int excluded_sum = total_sum-included_sum;
            if(included_sum>excluded_sum) {
                return N-i;
            }
        }
        return N;
    }
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<int> Arr(N);
        for(int i=0;i<N;i++){
            cin>>Arr[i];
        }
        Solution ob;
        cout<<ob.minSubset(Arr,N)<<endl;
    }
    return 0;
}
// } Driver Code Ends
