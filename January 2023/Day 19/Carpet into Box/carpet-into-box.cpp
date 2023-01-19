//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    // Time Complexity :- O(max(log(A),log(B)));
    // Space Complexity :- O(1);
    public:
    int carpetBox(int A, int B, int C, int D){
        //code here
        int step=0;
        int l1=max(A,B),b1=min(A,B),l=max(C,D),b=min(C,D);
        while(l1>l || b1>b) {
            if(l1>l && b1>b) {
                l1/=2;
            } else if(l1>l) {
                l1/=2;
            } else {
                b1/=2;
            }
            
            A=l1;
            B=b1;
            l1 = max(A,B);
            b1 = min(A,B);
            
            step++;
        }
        
        return step;
    }
};


//{ Driver Code Starts.


int main(){
    int t;
    cin>>t;
    while(t--){
        int A,B,C,D;
        cin>>A>>B>>C>>D;
        
        Solution ob;

        int ans = ob.carpetBox(A,B,C,D);
        
        cout<<ans<<endl;
    }
}
// } Driver Code Ends