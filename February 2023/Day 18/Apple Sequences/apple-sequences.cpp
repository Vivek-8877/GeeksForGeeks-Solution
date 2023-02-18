//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    int appleSequences(int n, int m, string arr){
        // code here 
        int i=0,j=0,o=0,ans=0;
        while(j<n) {
            if(arr[j]=='O') {
                if(o<m) {
                    o++;
                    j++;
                } else {
                    if(arr[i]=='O') o--;
                    i++;
                }
            } else {
                j++;
            }
            ans = max(ans,j-i);
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
        int N, M;
        cin >> N >> M;
        string arr;
        cin >> arr;
        
        Solution ob;
        cout << ob.appleSequences(N, M, arr) << endl;
    }
    return 0; 
} 
// } Driver Code Ends