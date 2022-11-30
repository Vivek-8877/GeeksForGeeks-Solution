// Problem Link :- https://practice.geeksforgeeks.org/problems/reorder-list/1
// Video Solution Link :- https://youtu.be/no3NIeoCamE

//{ Driver Code Starts
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
/* Linked list Node */
struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};



// } Driver Code Ends
/* Following is the Linked list node structure */

/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/

class Solution{ 
public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    
    void reorderList(Node* head) {
        // Your code here
        vector<Node*> list;
        while(head!=NULL) {
            list.push_back(head);
            head=head->next;
        }
        
        for(int i=0,j=list.size()-1;i<j;i++,j--) {
            if(list.size()%2==1 && i+2==j) {
                list[j]->next=list[i+1];
                list[i+1]->next=NULL;
            } else if(i+1!=j){
                list[j]->next=list[i+1];
            } else {
                list[j]->next=NULL;
            }
            
            list[i]->next=list[j];
        }
    }
};

//{ Driver Code Starts.



/* Function to create a new Node with given data */
struct Node* newNode(int data) {
    struct Node* new_Node = new Node(data);
    new_Node->data = data;
    new_Node->next = NULL;
    return new_Node;
}

void printList(struct Node* Node) {
    while (Node != NULL) {
        printf("%d ", Node->data);
        Node = Node->next;
    }
    printf("\n");
}

void freeList(struct Node* head) {
    struct Node* temp;
    while (head != NULL) {

        temp = head;
        head = head->next;
        free(temp);
    }
}

int main(void) {
    int t, n, m, i, x;

    cin >> t;
    while (t--) {
        struct Node* temp, *head;
        cin >> n;
        cin >> x;
        head = new Node(x);
        temp = head;
        for (i = 0; i < n - 1; i++) {
            cin >> x;
            temp->next = new Node(x);
            temp = temp->next;
        }
        
        Solution ob;
        
        ob.reorderList(head);
        printList(head);
        freeList(head);
    }
    return 0;
}

// } Driver Code Ends
