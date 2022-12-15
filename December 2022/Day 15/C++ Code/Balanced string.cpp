// Problem Link :- https://practice.geeksforgeeks.org/problems/balanced-string1627/1
// Video Solution Link Coming Soon :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
// Initial template for c++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for c++

class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    string BalancedString(int N) {
        // code here
        string sb ="";
        int val = sum(N);   // store sum of digit of N for future use
        while(N>0) {
            if(N>=26) {
                sb+=find(26,0);
                N-=26;
            } else {
                if(N%2==0) {
                    sb+=find(N/2,0);
                    sb+=find(N/2,1);
                } else {
                    if(val%2==0) {
                        sb+=find((N+1)/2,0);
                        sb+=find((N-1)/2,1);
                    } else {
                        sb+=find((N-1)/2,0);
                        sb+=find((N+1)/2,1);
                    }
                }
                N=0;
            }
        }
        return sb;
    }
    // find sum of digit of n
    int sum(int n) {
        int s=0;
        while(n>0) {
            s+=(n%10);
            n/=10;
        }
        return s;
    }
    // return a string of length v according to status
    // status -> 0 from starting i.e a.......
    // status -> 1 from ending i.e  ........z
    string find(int v,int status) {
        string sb="";
        if(status==0) {
            for(char i='a';v>0;v--,i++) {
                sb+=i;
            }
        } else {
            for(char i='z';v>0;v--,i--) {
                sb+=i;
            }
            reverse(sb.begin(), sb.end());
        }
        return sb;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.BalancedString(N) << endl;
    }
    return 0;
}

// } Driver Code Ends
