from typing import List

import sys
class Solution:
    def minimumInteger(self, N : int, A : List[int]) -> int:
        # code here
        sum=0;
        for a in A :
            sum+=a;
        mn = sys.maxsize;
        for a in A :
            if sum<=N*a :
                mn = min(mn,a);
        return mn;
    


#{ 
 # Driver Code Starts
class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        N = int(input())
        
        
        A=IntArray().Input(N)
        
        obj = Solution()
        res = obj.minimumInteger(N, A)
        
        print(res)
        

# } Driver Code Ends