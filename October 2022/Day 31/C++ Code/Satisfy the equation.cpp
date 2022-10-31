//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
  
//   Time Complexity :- O(n^4)
//   Space Complexity :- O(1)
    vector<int> satisfyEqn(int A[], int N) {
        // code here
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                for(int k=0;k<N;k++) {
                    for(int l=k+1;l<N;l++) {
                        if(k==i || k==j || l==i || l==j) continue;
                        if(A[i]+A[j]==A[k]+A[l]) {
                            vector<int> ans{i,j,k,l};
                            return ans;
                        }
                    }
                }
            }
        }
        vector<int> ans{-1,-1,-1,-1};
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        
        cin>>N;
        int A[N];
        
        for(int i=0; i<N; i++)
            cin>>A[i];

        Solution ob;
        vector<int> ptr = ob.satisfyEqn(A,N);
        
        cout<<ptr[0]<<" "<<ptr[1]<<" "<<ptr[2]<<" "<<ptr[3]<<endl;
    }
    return 0;
}
// } Driver Code Ends
