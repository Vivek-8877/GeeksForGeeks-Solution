//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
};

/* Helper function that allocates a new node
with the given data and NULL left and right
pointers. */
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}

Node* buildTree(string str)
{
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str; )
        ip.push_back(str);

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
        if (i >= ip.size())
            break;
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
void postorderTraversal(Node* root)
{
    if (!root)
        return;

    // recur on left subtree
    postorderTraversal(root->left);

    // then recur on right subtree
    postorderTraversal(root->right);

    // print the root's data
    cout << root->data << " ";
}



// } Driver Code Ends
//User function Template for C++

class Solution{
  public:
    void convertToMaxHeapUtil(Node* root)
    {
        // Your code goes here
        
        vector<int> list;
        In_Order(root,list);
        queue<pair<Node*,pair<int,int>>> dq;
        
        root->data=list[list.size()-1];
        root->left=NULL;
        root->right=NULL;
        dq.push({root,{0,list.size()-2}});
        
        while(dq.size()>0) {
            pair<Node*,pair<int,int>> t = dq.front();
            dq.pop();
            pair<int,int> index = t.second;
            int mid = index.first+(index.second-index.first)/2;
            if(index.first>index.second || index.first<0 || index.second<0 || index.second>=list.size() || index.first>=list.size()) continue;
            if(mid>=0) {
                t.first->left = newNode(list[mid]);
                dq.push({t.first->left,{index.first,mid-1}});
            }
            if(index.second>=0 && mid!=index.second) {
                t.first->right = newNode(list[index.second]);
                dq.push({t.first->right,{mid+1,index.second-1}});
            }
        }
    }
    
    void In_Order(Node* root,vector<int>& list) {
        if(root==NULL) return;
        In_Order(root->left,list);
        list.push_back(root->data);
        In_Order(root->right,list);
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    getchar();
    while (t--)
    {
        string inp, ch;
        getline(cin, inp);
        struct Node* root = buildTree(inp);
        Solution ob;
        ob.convertToMaxHeapUtil(root);
 
