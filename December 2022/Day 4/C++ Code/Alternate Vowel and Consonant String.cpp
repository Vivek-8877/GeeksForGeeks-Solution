// Problem Link :- https://practice.geeksforgeeks.org/problems/alternate-vowel-and-consonant-string2939/1
// Video Solution Link :- https://youtu.be/tfpmSfEzKCg

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(26);
    public:
    vector<int> vowel{0,'e'-'a','i'-'a','o'-'a','u'-'a'};
    string rearrange (string S, int N)
    {
        // your code here
        vector<int> fre(26,0);
        int ct_vl=0;
        for(int i=0;i<N;i++) {
            char c = S[i];
            for(int idx : vowel) {
                if(idx==c-'a') {
                    ct_vl++;
                    break;
                }
            }
            fre[c-'a']++;
        }
        
        int ct_non_vl = N-ct_vl;
        if(!(ct_non_vl==ct_vl || ct_non_vl==ct_vl+1 || ct_non_vl+1==ct_vl)) return "-1";
        string ans="";
        for(int i=0;i<N;i++) {
            if(i%2==0) {
                if(ct_non_vl==ct_vl || ct_non_vl+1==ct_vl) {
                    // vowel
                    add_vowel(fre,ans);
                } else {
                    // non_vowel
                    add_non_vowel(fre,ans);
                }
            } else {
                if(ct_non_vl==ct_vl || ct_non_vl+1==ct_vl) {
                    // non_vowel
                    add_non_vowel(fre,ans);
                } else {
                    // vowel
                    add_vowel(fre,ans);
                }
            }
        }
        return ans;
    }
    
    void add_vowel(vector<int>& fre,string &s) {
        for(int idx : vowel) {
            if(fre[idx]>0) {
                fre[idx]--;
                char c = (char)(idx+'a');
                s+=c;
                return;
            }
        }
    }
    
    void add_non_vowel(vector<int>& fre,string &s) {
        for(int i=0;i<26;i++) {
            if(fre[i]<=0) continue;
            bool is_Vowel=false;
            for(int idx : vowel) {
                if(i==idx) is_Vowel=true;
            }
            if(!is_Vowel) {
                fre[i]--;
                char c = (char)(i+'a');
                s+=c;
                return;
            }
        }
    }
};

//{ Driver Code Starts.

int main()
{
	int t; cin >> t;
	while (t--)
	{
		int n; cin >> n;
		string s; cin >> s;
		Solution ob;
		cout << ob.rearrange (s, n) << endl;
	}
}
// Contributed By: Pranay Bansal

// } Driver Code Ends
