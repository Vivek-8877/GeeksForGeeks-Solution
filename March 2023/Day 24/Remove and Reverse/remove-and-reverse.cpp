//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution {
  public:
    string removeReverse(string S) {
        // code here
        vector<int> fre(26,0);
        for(int i=0;i<S.length();i++) fre[S[i]-'a']++;
        vector<int> isRemoved(S.length(),0);
        int i=0,j=S.length()-1,time=0;
        while(i<=j) {
            if(time%2==0) {
                if(fre[S[i]-'a']>1) {
                    time++;
                    isRemoved[i]=1;
                    fre[S[i]-'a']--;
                }
                i++;
            } else {
                if(fre[S[j]-'a']>1) {
                    time++;
                    isRemoved[j]=1;
                    fre[S[j]-'a']--;
                }
                j--;
            }
        }
        string sb="";
        for(i=0;i<S.length();i++) if(isRemoved[i]==0) sb+=S[i];
        if(time%2==1) reverse(sb.begin(),sb.end());
        return sb;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin>>S;
        Solution obj;
        auto ans = obj.removeReverse(S);
        cout<<ans<<endl;
    }
}
// } Driver Code Ends