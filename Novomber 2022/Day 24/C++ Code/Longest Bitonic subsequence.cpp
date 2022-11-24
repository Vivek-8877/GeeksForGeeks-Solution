//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    
// 	Time Complexity :- O(n^2);
// 	Space Complexity :- O(n);
	public:
	int LongestBitonicSequence(vector<int>nums)
	{
	    // code here
	    int n = nums.size();
	    vector<int> right(n,0);
        for(int i=n-1;i>=0;i--) {
            for(int j=i+1;j<n;j++) {
                if(nums[i]>nums[j]) right[i] = max(right[i],right[j]);
            }
            right[i]++;
        }
        
        vector<int> left(n,0);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) left[i] = max(left[i],left[j]);
            }
            left[i]++;
        }
        
        int ans=0;
        for(int i=0;i<n;i++) {
            ans = max(ans,left[i]+right[i]-1);
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
		for(int i = 0; i < n; i++)
			cin >> nums[i];
		Solution ob;
		int ans = ob.LongestBitonicSequence(nums);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends
