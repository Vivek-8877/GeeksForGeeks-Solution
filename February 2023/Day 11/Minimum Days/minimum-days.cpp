//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


class Array
{
public:
    template <class T>
    static void input(vector<T> &A,int n)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%d ",&A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A)
    {
        for (int i = 0; i < A.size(); i++)
        {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends
class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    int getMinimumDays(int N,string S, vector<int> &P) {
        // code here
        int ans=0;
        for(int i=0;i<N;i++) {
            int idx = P[i];
            if(idx==0) {
                if(idx+1<N && S[idx]!='?' && S[idx]==S[idx+1]) {
                    S[idx]='?';
                    ans = i+1;
                }
            } else if(idx==N-1) {
                if(idx-1>=0 && S[idx]!='?' && S[idx]==S[idx-1]) {
                    S[idx]='?';
                    ans = i+1;
                }
            } else {
                if(S[idx]!='?' && (S[idx]==S[idx-1] || S[idx]==S[idx+1])) {
                    S[idx]='?';
                    ans = i+1;
                }
            }
        }
        return ans;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        int N;
        scanf("%d",&N);
        string S;cin>>S;
        
        vector<int> P(N);
        Array::input(P,N);
        
        Solution obj;
        int res = obj.getMinimumDays(N,S, P);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends