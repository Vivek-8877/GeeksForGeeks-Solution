//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(n^2);
    vector<int> solveQueries(int N, int num, vector<int> &A, vector<vector<int>> &Q) {
        // code here
        vector<int> fre(N,0);
        for(int i=0;i<N;i++) {
            for(int j=i;j<N;j++) if(A[i]==A[j]) fre[i]++;
        }
        vector<int> list;
        for(vector<int> q : Q) {
            int f=0;
            for(int i=q[0];i<=q[1];i++) {
                if(fre[i]==q[2]) f++;
            }
            list.push_back(f);
        }
        return list;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int num;
        cin>>num;
        vector<int> A(N);
        for(int i=0;i<N;i++){
            cin>>A[i];
        }
        vector<vector<int>> Q(num, vector<int>(3));
        for(int i=0;i<num;i++){
            for(int j=0;j<3;j++){
                cin>>Q[i][j];
            }
        }
        Solution obj;
        vector<int> res = obj.solveQueries(N, num, A, Q);
        
        for(auto ele:res){
            cout<<ele<<" ";
        }
        cout<<endl;
    }
}

// } Driver Code Ends