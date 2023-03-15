//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++
class Solution{
    //Complete the function and return minimum number of operations
    public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1); 
    int specialPalindrome(string a, string b){
        //Code Here
        int ans=INT_MAX;
        for(int i=0;i<=a.length()-b.length();i++) {
            int val = f(a,b,i,i+b.length()-1);
            if(val!=-1) ans=min(ans,val);
        }
        if(ans==INT_MAX) ans=-1;
        return ans;
    }
    int f(string a,string b,int strt,int end) {
        int ans=0;
        for(int i=0,j=a.length()-1;i<=j;i++,j--) {
            if(i>=strt && i<=end) {
                if(j>=strt && j<=end) {
                    if(b[i-strt]!=b[j-strt]) return -1;
                    if(a[i]!=b[i-strt]) ans++;
                    if(a[j]!=b[j-strt] && i!=j) ans++;
                } else {
                    if(a[i]!=b[i-strt]) ans++;
                    if(b[i-strt]!=a[j] && i!=j) ans++;
                }
            } else {
                if(j>=strt && j<=end) {
                    if(a[j]!=b[j-strt]) ans++;
                    if(b[j-strt]!=a[i] && i!=j) ans++;
                } else {
                    if(a[i]!=a[j]) ans++;
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
        string s1,s2;
        cin>>s1>>s2;
        Solution obj;
        int ans = obj.specialPalindrome(s1,s2);
        
        cout<<ans<<endl;
    }
}
// } Driver Code Ends