#User function Template for python3
import sys
def f(a,b,strt,end) :
    ans=0;
    i=0
    j=len(a)-1
    while i<=j :
        if i>=strt and i<=end :
            if j>=strt and j<=end :
                if b[i-strt]!=b[j-strt] : return -1;
                if a[i]!=b[i-strt] : ans+=1
                if a[j]!=b[j-strt] and i!=j : ans+=1
            else :
                if a[i]!=b[i-strt] : ans+=1
                if b[i-strt]!=a[j] and i!=j : ans+=1
        else :
            if j>=strt and j<=end :
                if a[j]!=b[j-strt] : ans+=1
                if b[j-strt]!=a[i] and i!=j : ans+=1
            else :
                if a[i]!=a[j] : ans+=1
        i+=1
        j-=1
    return ans;
class Solution():
    def specialPalindrome(self,s1, s2):
        #your code goes here
        ans=sys.maxsize
        for i in range(0,len(s1)-len(s2)+1) :
            val = f(s1,s2,i,i+len(s2)-1)
            if val!=-1 : ans=min(ans,val)
            
        if ans==sys.maxsize : ans=-1
        return ans;

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    for _ in range(int(input())):
        s1, s2 = input().split()
        obj = Solution()
        print(obj.specialPalindrome(s1, s2))
# } Driver Code Ends