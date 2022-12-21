// Problem Link :- https://practice.geeksforgeeks.org/problems/absolute-list-sorting/1
// Video Solution Link :- https://youtu.be/Npt3aHziL6o

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Linked List Node
struct Node
{
	Node* next;
	int data;
};

// Utility function to insert a node at the
// beginning
void push(Node** head, int data)
{
	Node* newNode = new Node;
	newNode->next = (*head);
	newNode->data = data;
	(*head) = newNode;
}

// Utility function to print a linked list
void printList(Node* head)
{
	while (head != NULL)
	{
		cout << head->data;
		if (head->next != NULL)
			cout << " ";
		head = head->next;
	}
	cout << endl;
}


// } Driver Code Ends
/* The structure of the Linked list Node is as follows:
struct Node
{
    Node* next;
    int data;
}; */

/*Your method shouldn't print anything
 it should transform the passed linked list */
class Solution{
    
public:
// 	Time Complexity :- O(n);
// 	Space Complexity :- O(1);
    Node* sortList(Node* head)
    {
        // Your Code Here
        Node* temp = head->next;
		head->next=NULL;
		Node* tail = head;
		Node* temp1;
		while(temp!=NULL) {
		    temp1 = new Node();
		    temp1-> data = temp->data;
		    if(temp->data<0) {
		        // adding node at start
		        temp1->next=  head;
		        head = temp1;
		    } else {
		        // adding node at end
		        tail->next = temp1;
		        tail = temp1;
		    }
		    temp = temp->next;
		}
		return head;
    }
};


//{ Driver Code Starts.

// Driver code
int main()
{

	int t = 0;
	int n = 0;
	cin >> t;
	while (t--)
	{
		Node* head = NULL;
		cin >> n;
		int arr[n];
		for (int i = 0; i < n; i++)
		{
			cin >> arr[i];
			// push(&head, a);
		}
		for (int i = n - 1; i >= 0; i--)
		{
			push(&head, arr[i]);
		}
		// printList(head);
		
		Solution ob;
		head=ob.sortList(head);

		printList(head);

	}
	return 0;
}

// } Driver Code Ends
