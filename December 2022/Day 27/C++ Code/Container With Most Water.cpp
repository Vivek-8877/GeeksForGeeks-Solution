// Problem Link :- https://practice.geeksforgeeks.org/problems/container-with-most-water0535/1
// Video Solution Link :- https://youtu.be/9IS2erZcotg

//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;
// int maxArea(int A[], int len);

// } Driver Code Ends
//User function template for C++

// Time Complexity :- O(100*N) => O(n);
// Space Complexity :- O(1);
long long maxArea(long long A[], int len)
{
    // Your code goes here
    long long ans=0;
    long long left,right,width;
    for(int height=1;height<=100;height++) {
        left=0;
        for(int i=0;i<len;i++) {
            if(A[i]>=height) {
                left=i;
                break;
            }
        }
        
        right=0;
        for(int i=len-1;i>=0;i--) {
            if(A[i]>=height) {
                right=i;
                break;
            }
        }
        width = right-left;
        ans = max(ans,height*width);
    }
    
    return ans;
}

//{ Driver Code Starts.

// Driver code
int main()
{
	int t;
	cin>>t;
	while(t--)
    {
        int n;
        cin>>n;
        long long arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        cout<<maxArea(arr,n)<<endl;
    }
return 0;
}

// } Driver Code Ends
