from typing import List


class Solution:
    def getDistinctDifference(self, N : int, A : List[int]) -> List[int]:
        # code here
        st = set()
        l=[]
        for i in range(N-1,-1,-1) :
            l.append(len(st));
            st.add(A[i]);
        st1 = set()
        ans=[]
        for i in range(0,N) :
            ans.append(len(st1)-l[N-i-1]);
            st1.add(A[i]);
        return ans



#{ 
 # Driver Code Starts
# class IntArray:

#     def __init__(self) -> None:
#         pass
    
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        N = int(input())
        
        A=[int(i) for i in input().split()]
        
        obj = Solution()
        res = obj.getDistinctDifference(N, A)
        
        print(*res)
        

# } Driver Code Ends