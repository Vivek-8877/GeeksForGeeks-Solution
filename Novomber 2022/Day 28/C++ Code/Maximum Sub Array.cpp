// Problem Link :- https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1
// Video Solution Link :- https://youtu.be/HxTo8vRl6R8

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:
// 	Time Complexity :- O(n);
// 	Space Complexity :- O(1);

	vector<int> findSubarray(int a[], int n) {
	    // code here
	    long long int sum=0;
        int l=0,idx=-1;
        
        long long int max = 0;
        int l1=0,idx1=-1;
        for(int i=0;i<n;i++) {
            if(a[i]>=0) {
                sum+=a[i];
                l++;
                if(idx==-1) {
                    idx=i;
                }
            } else {
                sum=0;
                l=0;
                idx=-1;
            }
            
            if(max<sum || (max==sum && l1<l)) {
                max=sum;
                idx1=idx;
                l1=l;
            }
        }
        vector<int> list;
        if(l1==0) {
            list.push_back(-1);
            return list;
        }
        for(int i=idx1;i<n && a[i]>=0;i++) list.push_back(a[i]);
        return list;
	}
};

//{ Driver Code Starts.

void printAns(vector<int> &ans) {
    for (auto &x : ans) {
        cout << x << " ";
    }
    cout << "\n";
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findSubarray(a, n);
        printAns(ans);
    }
    return 0;
}

// } Driver Code Ends
