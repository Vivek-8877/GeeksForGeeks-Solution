#User function Template for python3

class Solution:
    # Time Complexity :- O(1);
    # Space Complexity :- O(1);
    def minOperations(self, n):
        # Code here
        return (n//2) * (n - (n//2));


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    
    T = int(input())
    while T > 0: 
        N =int(input())
        ob = Solution()
        print(ob.minOperations(N))
        
        T -= 1

# } Driver Code Ends