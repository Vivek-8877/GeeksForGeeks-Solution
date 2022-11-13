//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
	// Time Complexity :- O(n)
    // Space Complexity :- O(26)
	
	int characterReplacement(string s, int k){
	    // Code here
	    int i=0,j=0,ans=0;
        vector<int> fre(26,0);
        while(j<s.length()) {
            if(isValid(fre,k)) {
                ans = max(ans,j-i);
                fre[s[j]-'A']++;
                j++;
            } else {
                fre[s[i]-'A']--;
                i++;
            }
        }
        
        while(i<s.length()) {
            if(isValid(fre,k)) {
                ans = max(ans,j-i);
                break;
            } else {
                fre[s[i]-'A']--;
                i++;
            }
        }
        return ans;
	}
	
	bool isValid(vector<int> a,int k) {
        int mx =0,sum=0;
        for(int b :a) {
            sum+=b;
            mx = max(b,mx);
        }
        
        sum-=mx;
        
        if(sum<=k) return true;
        return false;
    }

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		int k;
		cin >> k;
		Solution obj;
		int ans = obj.characterReplacement(s, k);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends
