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

#define ll long long int
class Solution {
  public:
    int minimumInteger(int N, vector<int> &A) {
        // code here
        ll sum=0;
        for(ll a : A) sum+=a;
        int mn=INT_MAX;
        for(ll a : A) if(sum<=N*a) mn = min(mn,(int)a);
        return mn;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        int N;
        scanf("%d",&N);
        
        
        vector<int> A(N);
        Array::input(A,N);
        
        Solution obj;
        int res = obj.minimumInteger(N, A);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends