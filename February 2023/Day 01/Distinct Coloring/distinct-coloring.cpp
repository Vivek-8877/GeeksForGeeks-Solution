//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    long long int distinctColoring(int N, int r[], int g[], int b[]){
        // code here
        long long int r1=0,g1=0,b1=0;
        long long int next_r1=0,next_g1=0,next_b1=0;
        for(int i=N-1;i>=0;i--) {
            r1=min(next_g1,next_b1)+r[i];
            g1=min(next_r1,next_b1)+g[i];
            b1=min(next_r1,next_g1)+b[i];
            next_r1=r1;
            next_g1=g1;
            next_b1=b1;
        }
        return min(r1,min(g1,b1));
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
        int r[N],g[N],b[N];
        for(int i = 0; i < N; i++)
            cin >> r[i];
        for(int i = 0; i < N; i++)
            cin >> g[i];
        for(int i = 0; i < N; i++)
            cin >> b[i];
        
        Solution ob;
        cout << ob.distinctColoring(N, r, g, b) << endl;
    }
    return 0; 
}
// } Driver Code Ends