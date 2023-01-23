//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    string removePair(string s) {
        // code here
        string ans = "";
        for(int i=0;i<s.length();i++) {
            char c = s[i];
            if(ans.length()>0 && ans[ans.length()-1]==c) {
                ans = ans.substr(0,ans.length()-1);
            } else {
                ans+=c;
            }
        }
        if(ans.length()==0) return "-1";
        return ans;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        string s; 
        cin>>s;
        
        Solution obj;
        string res = obj.removePair(s);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends