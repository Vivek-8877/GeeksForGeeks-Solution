#User function Template for python3

class Solution():
    # Time Complexity :- O(n);
    # Space Compleixty :- O(1);
    def no_of_subarrays(self, n,arr):
        #your code goes here
        ct=0;
        ans=0;
		for v in arr :
		    if v==0 :
		        ct+=1;
		    else :
		        ans+=(ct*(ct+1)//2);
		        ct=0;
		ans+=(ct*(ct+1)//2);
		return ans;


#{ 
 # Driver Code Starts
#Initial Template for Python 3


for _ in range(int(input())):
    n = int(input())
    arr = [int(i) for i in input().split()]
    print(Solution().no_of_subarrays(n, arr))
# } Driver Code Ends