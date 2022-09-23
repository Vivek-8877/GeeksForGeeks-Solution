//{ Driver Code Starts
//Initial template for C++
 
#include<bits/stdc++.h>
using namespace std; 

// } Driver Code Ends
//User function template for C++

class Solution{
public:
    int minLength(string s, int n) {
        // code here
        stack<char> stack;
    	string str[10] = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
    	
    	for(int i=0;i<n;i++) {
    	    char c = s[i];
    	    
    	    if(stack.size()==0) {
    	        stack.push(c);
    	    } else {
    	        char p = stack.top();
    	        
    	        bool isValid = false;
    	        for(int j=0;j<10 && !isValid;j++) {
    	            if(str[j][0]==p && str[j][1]==c) isValid = true;
    	        }
    	        
    	        if(isValid) {
    	            stack.pop();
    	        } else{
    	            stack.push(c);
    	        } 
    	    }
    	}
    	return stack.size();
    } 
};


//{ Driver Code Starts.

int32_t main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--)
    {
        int n;
        cin >> n;

        string s;
        cin >> s;

        Solution obj;
        cout << obj.minLength(s, n) << "\n";
    }
    return 0;
}
// } Driver Code Ends
