//{ Driver Code Starts
//Initial Template for C++



#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
    public:
        // Function to return the length of the
        //longest subarray with ppositive product
        int maxLength(vector<int> &arr,int n){
           //code here
           int strt=0,first_negative=-1,count_negative=0;
            int ans=0;
            for(int i=0;i<n;i++) {
                if(arr[i]==0) {
                    strt=i+1;
                    first_negative=-1;
                    count_negative=0;
                    continue;
                } else if(arr[i]<0) {
                    count_negative++;
                    if(first_negative==-1) first_negative=i;
                }
                
                if(count_negative%2==0) {
                    ans = max(ans,i-strt+1);
                } else {
                    ans = max(ans,i-first_negative);
                }
            }
            return ans;
        }
};

//{ Driver Code Starts.

int main() {
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    vector<int> arr(n);
	    for(int i = 0;i<n;i++){
	        cin>>arr[i];
	    }
	    Solution ob;
	    int res = ob.maxLength(arr,n);
	    cout<<res<<"\n";
	}
	return 0;
}
// } Driver Code Ends