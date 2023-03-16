//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 


// } Driver Code Ends
//User function Template for C++

class Solution{   
  public:
    // Time Complexity :- O(n);
    // Space Compleixty :- O(1);
    string secondSmallest(int S, int D){
        // code here 
        if(D==1 || S==1 || S>=9*D) return "-1";
        bool isChanged=false;
        string sb="";
        for(int i=0;i<D;i++) {
            int digit;
            if(S>9) {
                digit=9;
                S-=9;
            } else {
                if(i==D-1) {
                    digit=S;
                } else {
                    if(S>1) {
                        digit=S-1;
                        S=1;
                    } else {
                        digit=0;
                    }
                }
            }
            if(!isChanged && digit<9 && sb.length()>0) {
                digit++;
                char c = sb[sb.length()-1];
                sb[sb.length()-1] = --c;
                isChanged=true;
            }
            sb+=to_string(digit);
        }
        reverse(sb.begin(),sb.end());
        return sb;
    }
};

//{ Driver Code Starts.

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int S,D;
        cin >> S >> D;
        Solution ob;
        cout << ob.secondSmallest(S,D) << endl;
    }
    return 0; 
} 
// } Driver Code Ends