//{ Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution
{
    public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1);
    int countSubstring(string S)
    {
        // code here
        int ans=0;
        for(int i=0;i<S.length();i++) {
            int l=0,u=0;
            for(int j=i;j<S.length();j++) {
                if(S[j]>='A' && S[j]<='Z') {
                    u++;
                } else {
                    l++;
                }
                if(l==u) ans++;
            }
        }
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
        string S;
        cin>>S;
        Solution obj;
        cout<<obj.countSubstring(S)<<endl;
    }
}  
// } Driver Code Ends