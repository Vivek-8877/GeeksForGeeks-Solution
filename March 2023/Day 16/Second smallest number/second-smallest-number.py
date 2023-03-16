#User function Template for python3

class Solution:
    # Time Complexity :- O(n);
    # Space Compleixty :- O(1);
    def secondSmallest(self, S, D):
        # code here 
        if D==1 or S==1 or S>=9*D : return "-1";
        isChanged=False;
        sb=[]
        for i in range(0,D) :
            digit=0;
            if S>9 :
                digit=9;
                S-=9;
            else :
                if i==D-1 :
                    digit=S;
                else :
                    if S>1 :
                        digit=S-1;
                        S=1;
                    else :
                        digit=0;
                        
            if not(isChanged) and digit<9 and len(sb)>0 :
                digit+=1;
                c = sb[len(sb)-1];
                sb[len(sb)-1] = c-1;
                isChanged=True;
                
            sb.append(digit);
        s="";
        for i in range(len(sb)-1,-1,-1) : s+=str(sb[i]);
        return s;

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        
        S,D=map(int,input().strip().split(" "))

        ob = Solution()
        print(ob.secondSmallest(S,D))
# } Driver Code Ends
