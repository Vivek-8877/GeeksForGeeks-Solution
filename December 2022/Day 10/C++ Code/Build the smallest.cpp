// Probelm Link :- https://practice.geeksforgeeks.org/problems/build-the-smallest2841/1
// Video Solution Link :- https://www.youtube.com/channel/UC1P9bWDLTPS1Zp03m5PQEoQ

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string buildLowestNumber(string num, int k);
// Driver program to test above function
int main()
{
    int t,n;
    string str;
    cin>>t;
    while(t--)
    {
    cin>>n;
    cin>>str;
    cout << buildLowestNumber(str, n)<<endl;
    }
    return 0;
}

// } Driver Code Ends

// Time Complexity :- O(num.length);
// Space Complexity :- O(num.length);
string buildLowestNumber(string num, int k)
{
    //code here.
    stack<char> stk;
    for(int i=0;i<num.length();i++) {
        char c = num[i];
        while(stk.size()>0 && stk.top()>c && k>0) {
            k--;
            stk.pop();
        }
        stk.push(c);
    }
    // System.out.println(stack);
    string ans="";
    while(stk.size()>0) {
        char c = stk.top();
        stk.pop();
        if(k>0) {
            k--;
            continue;
        }
        ans+=c;
    }
    // To Reverse ans
    string ans1 ="";
    for(int i=ans.length()-1;i>=0;i--) {
        char c = ans[i];
        ans1+=c;
    }
    ans=ans1;
    for(int i=0;i<ans.length();i++) {
        if(ans[i]!='0') return ans.substr(i);
    }
    return "0";
}
