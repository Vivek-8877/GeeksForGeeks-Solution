#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3
class Solution:
    # Time Complexity :- O(n^2);
    # Space Complexity :- O(1);
    def countSubstring(self, S): 
        #code here
        ans=0;
        for i in range(0,len(S)) :
            l=0;
            u=0;
            for j in range(i,len(S)) :
                if S[j]>='A' and S[j]<='Z' :
                    u+=1;
                else :
                    l+=1;
                if l==u :
                    ans+=1;
        return ans;

#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input())
    for _ in range(t):
        S = input()
        ob = Solution()
        ans = ob.countSubstring(S)
        print(ans)

# } Driver Code Ends