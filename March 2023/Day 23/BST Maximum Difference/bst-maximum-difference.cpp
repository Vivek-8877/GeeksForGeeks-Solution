//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;
#define MAX_HEIGHT 100000

// Tree Node
struct Node {
    int data;
    Node *right;
    Node *left;

    Node(int x) {
        data = x;
        right = NULL;
        left = NULL;
    }
};

Node *insert(Node *tree, int val) {
    Node *temp = NULL;
    if (tree == NULL) return new Node(val);

    if (val < tree->data) {
        tree->left = insert(tree->left, val);
    } else if (val > tree->data) {
        tree->right = insert(tree->right, val);
    }

    return tree;
}


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    int maxDifferenceBST(Node *root,int target){
        // Code here
        return search(root,target,0);
    }
    
    int search(Node* root,int target,int sum) {
        if(root==NULL) return -1;
        if(root->data<target) {
            return search(root->right,target,sum+root->data);
        } else if(root->data>target) {
            return search(root->left,target,sum+root->data);
        } else {
            int mn = min(minimumSum(root->left),minimumSum(root->right));
            if(mn==INT_MAX) mn=0;
            return sum-mn;
        }
    }
    
    int minimumSum(Node* root) {
        if(root==NULL) return INT_MAX;
        if(root->left==NULL && root->right==NULL) {
            return root->data;
        } else if(root->left==NULL) {
            return minimumSum(root->right)+root->data;
        } else if(root->right==NULL) {
            return minimumSum(root->left)+root->data;
        } else {
            return min(minimumSum(root->left),minimumSum(root->right))+root->data;
        }
    }
};

//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    while (T--) {
        Node *root = NULL;

        int N;
        cin >> N;
        for (int i = 0; i < N; i++) {
            int k;
            cin >> k;
            root = insert(root, k);
        }

        int target;
        cin >> target;
        Solution ob;
        cout << ob.maxDifferenceBST(root, target);
        cout << endl;
    }
}
// } Driver Code Ends