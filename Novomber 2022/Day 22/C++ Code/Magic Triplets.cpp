// Problem Link :- https://practice.geeksforgeeks.org/problems/magic-triplets4003/1
// Video Solution Link :- https://youtu.be/z3ZsDoRg4uw

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1);
	
	public:
	int countTriplets(vector<int>nums){
	    // Code here.
	    int ans=0;
	    for(int j=0;j<nums.size();j++) {
	        int small =0;
	        for(int i=0;i<j;i++) {
	            if(nums[i]<nums[j]) small++;
	        }
	        
	        int large =0;
	        for(int k=j+1;k<nums.size();k++) {
	            if(nums[j]<nums[k]) large++;
	        }
	        ans+=(small*large);
	    }
	    return ans;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)cin >> nums[i];
		Solution ob;
		int ans = ob.countTriplets(nums);
		cout << ans << "\n";
	}  
	return 0;
}
// } Driver Code Ends
