//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	#define ll long long int
	ll mod = 1000000007;
	int compute_value(int n)
	{
	    // Code here
	    vector<int> fact(n+1,0);
	    fact[0]=1;
        for(int i=1;i<=n;i++) fact[i] = multi(fact[i-1],i);
        
        int ans=0,val=0;
        for(int r=0;r<=n;r++) {
            val = divide(fact[n],multi(fact[r],fact[n-r]));
            ans = add(ans,multi(val,val));
        }
        
        return ans;
	}
	
	int power(ll a,ll b) {
        if(b==0) return 1;
        int p = power(a,b/2);
        p = multi(p,p);
        if(b%2==1) p = multi(p,a);
        return p;
    }
    
    int add(ll a,ll b) {
        return (int)(((a%mod)+(b%mod))%mod);
    }
    
    int multi(ll a,ll b) {
        return (int)(((a%mod)*(b%mod))%mod);
    }
    
    // {1/b}%mod => {b^(-1)}%mod => power(b,mod-2);
    int divide(ll a,ll b) {
        return multi(a,power(b,mod-2));
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		Solution ob;
		int ans = ob.compute_value(n);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends