//{ Driver Code Starts
//Initial Template for CPP

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    long long maxTripletProduct(long long arr[], int n)
    {
    	// Complete the function
    	long long mx1=INT_MIN;
        long long mx2=mx1,mx3=mx1;
        long long mn1=INT_MAX;
        long long mn2=mn1;
        for(int i=0;i<n;i++) {
            long long val = arr[i];
            if(mx1<=val) {
                mx3=mx2;
                mx2=mx1;
                mx1=val;
            } else if(mx2<=val) {
                mx3=mx2;
                mx2=val;
            } else if(mx3<=val) {
                mx3=val;
            }
            
            if(mn1>=val) {
                mn2=mn1;
                mn1=val;
            } else if(mn2>=val) {
                mn2=val;
            }
        }
        return max(mn1*mn2*mx1,mx1*mx2*mx3);
    }
};

//{ Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n,i;
	    cin>>n; long long arr[n];
	    for(i=0;i<n;i++)
	    cin>>arr[i];
	    Solution ob;
	    cout <<ob.maxTripletProduct(arr, n);
	    cout<<"\n";
	}
    return 0;
}
// } Driver Code Ends
