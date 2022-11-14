// Problem Link :- https://practice.geeksforgeeks.org/problems/find-patterns0606/1
// Video Solution Link :- https://youtu.be/X-qmx_2xuQs

//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(n);
    
    int numberOfSubsequences(string S, string W){
        // code here 
        int ans=0;
        vector<int> visit(S.length(),0);
        for(int i=0;i<S.length();i++) {
            int k=0;
            for(int j=0;j<S.length();j++) {
                if(S[j]==W[k] && visit[j]==0) {
                    k++;
                    visit[j]=1;
                }
                if(k>=W.length()) break;
            }
            if(k>=W.length()) ans++;
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
        string S,W;
        cin >> S >> W;
        Solution ob;
        cout << ob.numberOfSubsequences(S,W) << endl;
    }
    return 0; 
} 


// } Driver Code Ends
