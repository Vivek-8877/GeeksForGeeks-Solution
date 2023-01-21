//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minVal(int a, int b) {
        // code here
        vector<int> a1 = decimalToBinary(a);
        vector<int> b1 = decimalToBinary(b);
        int ans = a;
        if(a1[32]==b1[32]) {
            
        } else if(a1[32]<b1[32]) {
            for(int i=0;i<32 && a1[32]!=b1[32];i++) {
                if(a1[i]==0) {
                    ans+=(1<<i);
                    a1[32]++;
                }
            }
        } else {
            for(int i=0;i<32 && a1[32]!=b1[32];i++) {
                if(a1[i]==1) {
                    ans-=(1<<i);
                    a1[32]--;
                }
            }
        }
        return ans;
    }
    
    vector<int> decimalToBinary(int n) {
        vector<int> binary(33,0);
        for(int i=0;i<32;i++) {
            if((n&(1<<i))!=0) {
                binary[32]++;
                binary[i]=1;
            }
        }
        return binary;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;

        Solution ob;
        cout << ob.minVal(a, b);

        cout << "\n";
    }

    return 0;
}
// } Driver Code Ends