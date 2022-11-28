// Probelm Link :- https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1
// Video Solution Link :- https://youtu.be/xQ7_Iu4HETw

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	// Time Complexity :- O(max(|A|, |B|));
    // Space Complexity :- O(max(|A|, |B|)) (for output string);
    
	string addBinary(string A, string B)
	{
	    // your code here
	    int i=A.length()-1,j=B.length()-1;
        int c=0;
        string s="";
        while(i>=0 && j>=0) {
            int a1 = A[i]-'0';
            int b1 = B[j]-'0';
            addBit(a1,b1,c);
            s+=to_string(a1);
            i--;
            j--;
        }
        
        while(i>=0) {
            int a1 = A[i]-'0';
            addBit(a1,0,c);
            s+=to_string(a1);
            i--;
        }
        
        while(j>=0) {
            int b1 = B[j]-'0';
            addBit(b1,0,c);
            s+=to_string(b1);
            j--;
        }
        s+=to_string(c);
        i = s.length()-1;
        string ans ="";
        bool valid=false;
        while(i>=0) {
            if(s[i]-'0'==1) valid=true;
            if(valid) {
                ans+=s[i];
            }
            i--;
        }
        return ans;
	}
	
	void addBit(int& a,int b,int& c) {
	    if(c==0) {
	        if(a==0) {
	            if(b==0) {
	                a=0;
	                c=0;
	            } else {
	                a=1;
	                c=0;
	            }
	        } else {
	            if(b==0) {
	                a=1;
	                c=0;
	            } else {
	                a=0;
	                c=1;
	            }
	        }
	    } else {
	        if(a==0) {
	            if(b==0) {
	                a=1;
	                c=0;
	            } else {
	                a=0;
	                c=1;
	            }
	        } else {
	            if(b==0) {
	                a=0;
	                c=1;
	            } else {
	                a=1;
	                c=1;
	            }
	        }
	    }
	}
};

//{ Driver Code Starts.

int main()
{
	int t; cin >> t;
	while (t--)
	{
		string A, B; cin >> A >> B;
		Solution ob;
		cout << ob.addBinary (A, B);
		cout << "\n";
	}
}

// Contributed By: Pranay Bansal

// } Driver Code Ends
