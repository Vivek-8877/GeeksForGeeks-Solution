// Problem Link :- https://practice.geeksforgeeks.org/problems/break-a-number5913/1
// Video Solution Link :- https://youtu.be/gOvj1bBg-VI

//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++
class Solution{   
public:
    // Time Complexity :- O(1);
    // Space Complexity :- O(1);
    int waysToBreakNumber(int N){
        // code here
        long long int mod = 1000000007;
        long long int n =N;
        return (3*n+((n-1)*(n-2))/2)%mod;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.waysToBreakNumber(N) << endl;
    }
    return 0; 
} 
// } Driver Code Ends
