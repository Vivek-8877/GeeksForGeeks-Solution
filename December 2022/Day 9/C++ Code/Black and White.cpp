// Problem Link :- https://practice.geeksforgeeks.org/problems/black-and-white-1587115620/1
// Video Solution Link :- https://youtu.be/kpVaUgVrn60

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

long long numOfWays(int n, int m);

int main() {
    // code
    int T;
    cin >> T;
    while (T--) {
        int n, m;
        cin >> n >> m;
        cout << numOfWays(n, m) << endl;
    }
    return 0;
}
// } Driver Code Ends


//Function to find out the number of ways we can place a black and a 
//white Knight on this chessboard such that they cannot attack each other.
int requiredMove(int i,int j,int n,int m) {
    int ans=0;
    if(i-1>0) {
        if(j-2>0) {
            ans++;
        }
        if(j+2<=m) {
            ans++;
        }
    }
    if(i-2>0) {
        if(j-1>0) {
            ans++;
        }
        if(j+1<=m) {
            ans++;
        }
    }
    if(i+1<=n) {
        if(j-2>0) {
            ans++;
        }
        if(j+2<=m) {
            ans++;
        }
    }
    if(i+2<=n) {
        if(j-1>0) {
            ans++;
        }
        if(j+1<=m) {
            ans++;
        }
    }
    return ans;
}
    // Time Complexity :- O(m*n);
    // Space Complexity :- O(1);
long long numOfWays(int N, int M)
{
    // write code here
    int mod = 1000000007;
    int ans =0;
    int totalPosition = N*M;
    for(int i=1;i<=N;i++) {
        for(int j=1;j<=M;j++) {
            ans+=((totalPosition-1)-requiredMove(i,j,N,M));
            ans%=mod;
        }
    }
    return ans;
}
