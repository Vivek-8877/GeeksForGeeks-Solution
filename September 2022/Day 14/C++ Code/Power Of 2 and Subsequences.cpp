//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution{   
public:
    long long int mod = 1000000007;
    long long numberOfSubsequences(int N, long long A[]){
        // code here
        long long count =0;
        for(int i=0;i<N;i++) {
            if(number_of_set_bit(A[i])==1) {
                count++;
            }
        }
        // 2^count -1;
        return subtract(power(2,count),1);
    }
    long long power(long long int a,long long int b) {
        if(b==0) return 1;
        
        long long int p = power(a,b/2)%mod;
        
        if(b%2==1) {
            // p = p*p*a
            p = multiply(p,multiply(p,a));
        } else {
            // p = p*p
            p = multiply(p,p);
        }
        
        return p;
    }
    
    int number_of_set_bit(long long int n) {
        int ct=0;
        while(n>0) {
            long long rsbm = n&(-n);
            ct++;
            n-=rsbm;
        }
        return ct;
    }
    
    long long multiply(long long int a,long long int b) {
        return ((a%mod)*(b%mod))%mod;
    }
    
    long long subtract(long long int a,long long int b) {
        // from a to b
        return ((a%mod)-(b%mod)+mod)%mod;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin >> N;
        long long A[N];
        for(int i=0;i<N;++i){
            cin >> A[i];
        }
        Solution ob;
        cout << ob.numberOfSubsequences(N,A) << endl;
    }
    return 0; 
} 
// } Driver Code Ends
