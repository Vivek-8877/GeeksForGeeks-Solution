//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    
    class TrieNode{
        public: TrieNode* node[26];
        public: set<string> list;
        public: TrieNode(){
            for(int i=0;i<26;i++) {
                node[i]=NULL;
            }
        }
    };
    
    void add(TrieNode* root,string s) {
        for(int i=0;i<s.length();i++) {
            int idx = s[i]-'a';
            if(root->node[idx]==NULL) {
                root->node[idx]=new TrieNode();
            }
            root=root->node[idx];
            root->list.insert(s);
        }
    }
    
    set<string> find(TrieNode* root,string s,int last) {
        for(int i=0;i<=last;i++) {
            int idx = s[i]-'a';
            if(root->node[idx]==NULL) {
                set<string> list({"0"});
                return list;
            }
            root=root->node[idx];
        }
        return root->list;
    }
    
    
    
    vector<vector<string>> displayContacts(int n, string contact[], string s)
    {
        // code here
        TrieNode* root = new TrieNode();
        for(int i=0;i<n;i++) add(root,contact[i]);
        
        vector<vector<string>> ans;
        for(int i=0;i<s.length();i++) {
            set<string> st = find(root,s,i);
            vector<string> list;
            for(string str : st) list.push_back(str);
            ans.push_back(list);
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string contact[n], s;
        for(int i = 0;i < n;i++)
            cin>>contact[i];
        cin>>s;
        
        Solution ob;
        vector<vector<string>> ans = ob.displayContacts(n, contact, s);
        for(int i = 0;i < s.size();i++){
            for(auto u: ans[i])
                cout<<u<<" ";
            cout<<"\n";
        }
    }
    return 0;
}
// } Driver Code Ends
