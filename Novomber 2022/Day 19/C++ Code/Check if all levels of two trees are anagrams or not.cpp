// Problem Link :- https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1
// Video Solution Link :- https://youtu.be/yTy2MGkJmMc

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};
Node* newNode(int val) {
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    return temp;
}
Node* buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size()) break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
//User function Template for C++

class Solution{
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    
    public:
    bool areAnagrams(Node *root1, Node *root2)
    {
        list<Node*> dq1;
        list<Node*> dq2;
        dq1.push_back(root1);
        dq2.push_back(root2);
        
        while(dq1.size()>0 || dq2.size()>0) {
            int s1 = dq1.size();
            int s2 = dq2.size();
            if(s1!=s2) return false;
            
            vector<int> list1;
            vector<int> list2;
            for(int i=0;i<s1;i++) {
                Node* n1 = dq1.front();
                Node* n2 = dq2.front();
                dq1.pop_front();
                dq2.pop_front();
                
                list1.push_back(n1->data);
                list2.push_back(n2->data);
                
                if(n1->left!=NULL) dq1.push_back(n1->left);
                if(n2->left!=NULL) dq2.push_back(n2->left);
                
                if(n1->right!=NULL) dq1.push_back(n1->right);
                if(n2->right!=NULL) dq2.push_back(n2->right);
            }
            
            sort(list1.begin(),list1.end());
            sort(list2.begin(),list2.end());
            
            for(int i=0;i<s1;i++) {
                if(list1[i]!=list2[i]) return false;
            }
        }
        
        if(dq1.size()!=0 || dq2.size()!=0) return false;
        return true;
    }
};

//{ Driver Code Starts.

/* Driver program to test size function*/
int main() {
    int t;
    scanf("%d\n", &t);
    while (t--) {
        string treeString1, treeString2;
        getline(cin, treeString1);
        Node *root1 = buildTree(treeString1);
        getline(cin, treeString2);
        Node *root2 = buildTree(treeString2);
        Solution ob;
        cout << ob.areAnagrams(root1, root2) << endl;
    }
    return 0;
}

// } Driver Code Ends
