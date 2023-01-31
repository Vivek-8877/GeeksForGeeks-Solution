//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int minRepeats(string A, string B) {
        // code here
        int n = A.length(),m=B.length();
        int j=-1,ct=0;
        for(int i=0;i<n;i++) {
            if(n-i<=m) {
                if(A.substr(i)==B.substr(0,n-i)) {
                    j=n-i;
                    ct++;
                    break;
                }
            } else {
                if(A.substr(i,m)==B) {
                    return 1;
                }
            }
        }
        
        if(j==-1) return -1;
        for(int i=j;i<m;i+=n) {
            if(i+n<=m) {
                if(B.substr(i,n)==A) {
                    j=i+n;
                    ct++;
                } else {
                    return -1;
                }
            } else {
                if(B.substr(j)==A.substr(0,m-j)) {
                    ct++;
                    j=m;
                } else {
                    return -1;
                }
            }
        }
        return ct;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ",&t);
    while (t--) {
        string A,B;
        getline(cin,A);
        getline(cin,B);

        Solution ob;
        cout << ob.minRepeats(A,B) << endl;
    }
    return 0;
}
// } Driver Code Ends