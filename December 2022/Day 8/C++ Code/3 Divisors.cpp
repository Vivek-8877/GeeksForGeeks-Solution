// Problem Link :- https://practice.geeksforgeeks.org/problems/3-divisors3942/1
// Video Solution Link :- https://youtu.be/Nv6NtSk4igU

//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:
    // Time Complexity :- O(q*N*log(log(N)));
    // Space Complexity :- O(N), where N is min(10^6,N);
    vector<int> threeDivisors(vector<long long> query, int q)
    {
        // Write your code here
        vector<int> prime = primeNumber(1000000);
        vector<int> ans;
        for(long q1 : query) {
            ans.push_back(solve(prime,q1));
        }
        return ans;
    }
    
    vector<int> primeNumber(int n) {
        vector<int> prime(n+1,1);
        prime[0]=0;
        prime[1]=0;
        
        for(int i=2;i<=n;i++) {
            if(prime[i]==1) {
                for(int j=i+i;j<=n;j+=i) {
                    prime[j]=0;
                }
            }
        }
        vector<int> list;
        for(int i=0;i<=n;i++) {
            if(prime[i]==1) list.push_back(i);
        }
        return list;
    }
    
    int solve(vector<int> prime,long long q) {
        int v1 = (int)sqrt(q);
        int lo=0,hi=prime.size()-1;
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(prime[mid]<=v1) {
                lo=mid+1;
                ans = max(ans,mid+1);
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while(t--){
        int q;cin>>q;
        vector<long long> query(q);
        for(int i=0;i<q;i++){
            cin>>query[i];
        }
        Solution ob;
            
        vector<int> ans = ob.threeDivisors(query,q);
        for(auto cnt : ans) {
            cout<< cnt << endl;
        }
    }
    return 0;
}
// } Driver Code Ends
