//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
typedef long long int ll;
class Solution{
    public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    
    vector<long long int> twoOddNum(long long int Arr[], long long int N)  
    {
        // code here
        ll aXORb=0;
        for(int i=0;i<N;i++) aXORb^=Arr[i];
        
        ll rightMostSetBit = aXORb & (-aXORb);
        
        ll a=0,b=0;
        for(int i=0;i<N;i++) {
            if((Arr[i] & rightMostSetBit)==0) {
                a^=Arr[i];
            } else {
                b^=Arr[i];
            }
        }
        if(a<b) {
            ll temp =a;
            a=b;
            b=temp;
        }
        vector<ll> ans{a,b};
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
        long long int N;
        cin>>N;
        long long int Arr[N];
        for(long int i = 0;i < N;i++)
        cin>>Arr[i];
        Solution ob;
        vector<long long int>ans=ob.twoOddNum(Arr,N);
        for(long long int i=0;i<ans.size();i++)cout<<ans[i]<<" ";
        cout<<endl;
    }
    return 0;
}
// } Driver Code Ends
