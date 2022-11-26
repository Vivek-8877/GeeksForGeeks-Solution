//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

/* A binary tree node has data, pointer to left
child and a pointer to right child */
class Node
{
public:
    int data;
    Node *left, *right;
    Node(int data)
    {
        this->data = data;
        this->left = this->right = NULL;
    }
};

/* This function is to print the inorder of the tree  */
void inorder(Node *root)
{
    if (root == NULL)
        return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}



// } Driver Code Ends
//User function Template for C++

/*
class Node
{
public:
    int data;
    Node *left, *right;
    Node(int data)
    {
        this->data = data;
        this->left = this->right = NULL;
    }
};
*/


class Solution{
public:
    // function to construct tree from string
    Node *treeFromString(string str){
        // code here
        return f(str,0,str.length()-1);
    }
    
    Node* f(string s,int lft,int rt) {
        // System.out.println(s+" "+lft+" "+rt);
        if(lft>rt) return NULL;
        
        int i=lft;
        while(i<=rt) {
            char c = s[i];
            if(c>='0' && c<='9') {
                i++;
            } else {
                break;
            }
        }
        
        Node* ans = new Node(stoi(s.substr(lft,i-lft)));
        
        int j=i;
        stack<char> stk;
        while(j<=rt) {
            char c = s[j];
            if(c==')') {
                stk.pop();
            } else if(c=='(') {
                stk.push('(');
            }
            if(stk.size()==0) break;
            j++;
        }
        
        ans->left = f(s,i+1,j-1);
        if(j+2<rt) ans->right = f(s,j+2,rt-1);
        return ans;
    }
    
};

//{ Driver Code Starts.

// Driver Code
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string str;
        cin >> str;
        Solution obj;
        Node *root = obj.treeFromString(str);
        inorder(root);
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends
