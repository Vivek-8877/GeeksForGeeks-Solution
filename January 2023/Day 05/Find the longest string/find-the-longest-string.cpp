//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    // Time Complexity :- O(n.(length of String)) => O(n);
    // Space Complexity :- O(n);
    string longestString(vector<string> &words)
    {
        // code here
        unordered_set <string> set;
        for(string word : words) {
            set.insert(word);
        }
        string ans ="";
        bool isValid;
        for(string word : words) {
            isValid=true;
            for(int l=1;l<=word.length() && isValid;l++) {
                if(set.find(word.substr(0,l))==set.end()) {
                    isValid=false;
                }
            }
            if(isValid) {
                if(ans.length()<word.length()) {
                    ans=word;
                } else if(ans.length()==word.length()) {
                    if(ans>word) ans=word;
                }
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
    while (t--)
    {
        int n;
        cin >> n;
        vector<string> v(n);
        for (int i = 0; i < n; i++)
        {
            cin >> v[i];
        }
        Solution obj;
        string w = obj.longestString(v);
        cout << w << "\n";
    }
    return 0;
}

// } Driver Code Ends