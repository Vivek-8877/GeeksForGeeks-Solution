// Problem Link :- https://practice.geeksforgeeks.org/problems/akku-and-binary-numbers0902/1
// Video Solution Link :- 

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
public:
#define ll long long int
    void precompute()
    {
        // Code Here
    }
    // Time Complexity :- O(63^3);
    // Space Complexity :- O(1);
    long long solve(long long l, long long r){
        // Code Here
        return f(r,63,0,0)-f(l-1,63,0,0);
    }
    // function return count of number less then or equal to "n" having exactly number of
    // set bit 3.
    ll f(ll n,ll idx,int count_set_bit,int set) {
        if(count_set_bit==3) {
            return 1;
        }
        if(idx<0) return 0;
        
        ll ans=0;
        if(isSet(n,idx)) {
            ans+=f(n,idx-1,count_set_bit+1,set&1);
            ans+=f(n,idx-1,count_set_bit,1);
        } else {
            if(set==1) {
                ans+=f(n,idx-1,count_set_bit+1,set);
                ans+=f(n,idx-1,count_set_bit,set);
            } else {
                ans+=f(n,idx-1,count_set_bit,set);
            }
        }
        
        return ans;
    }
    // return true if "idx" bit from right to left is set in "n".
    bool isSet(ll n,ll idx) {
        ll one =1;
        ll mask = (one<<idx);
        return (n&mask)!=0;
    }
};



//{ Driver Code Starts.

int main()
{
    int t;
    Solution ob;
    ob.precompute();
    cin>>t;
    while(t--)
    {
        long long l,r;
        cin>>l>>r;
        cout << ob.solve(l, r) << endl; 
    }
    return 0;
}
// } Driver Code Ends
