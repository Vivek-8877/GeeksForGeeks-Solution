// Problem Link :- https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
// Video Solution Link :- https://www.youtube.com/watch?v=-gI6II7eTfc

//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    
    // Time Complexity :- O(32.r.log(c));
    // Space Complexity :- O(1);
    
    int median(vector<vector<int>> &matrix, int R, int C){
        // code here  
        int lo = INT_MAX,hi=INT_MIN;
        
        for(int i=0;i<R;i++) {
            lo = min(lo,matrix[i][0]);
            hi = max(hi,matrix[i][C-1]);
        }
        int required_value=((R*C)/2);
        if(R%2==0 || C%2==0) required_value--;
        int ans=hi;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            
            int count=0;
            for(int i=0;i<R;i++) {
                count+=search(matrix[i],mid);
            }
            
            if(count<=required_value) {
                lo=mid+1;
            } else {
                hi=mid-1;
                ans=min(ans,mid);
            }
        }
        return ans;
    }
    
    int search(vector<int> a,int v) {
        int lo=0,hi=a.size()-1;
        int ans=-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid]<=v) {
                lo=mid+1;
                ans=max(ans,mid);
            } else {
                hi=mid-1;
            }
        }
        return ans+1;
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int r, c;
        cin>>r>>c;
        vector<vector<int>> matrix(r, vector<int>(c));
        for(int i = 0; i < r; ++i)
            for(int j = 0;j < c; ++j)
                cin>>matrix[i][j];
        Solution obj;
        cout<<obj.median(matrix, r, c)<<endl;        
    }
    return 0;
}
// } Driver Code Ends
