#User function Template for python3

class Solution:
    def findMaxRow(self, mat, N):
        # Code here
        ans = [0]*2
        i=0
        j=N-1
        while i<N and j>=0 :
            while j>=0 and mat[i][j]==1 :
                j-=1
            if N-j-1>ans[1] :
                ans[1]=N-j-1
                ans[0]=i
            i+=1
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        mat = []
        for i in range(n):
            A = [int(x) for x in input().split()]
            mat.append(A)
        ob=Solution()
        ans = []
        ans = ob.findMaxRow(mat, n)
        for i in range(2):
            print(ans[i], end =" ")
        print()
# } Driver Code Ends
