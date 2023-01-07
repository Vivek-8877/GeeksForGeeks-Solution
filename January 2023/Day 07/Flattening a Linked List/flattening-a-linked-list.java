//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	Node ans = null;
	Node temp,temp1,temp2,prev;
	while(root!=null) {
	    temp=root;
	    root=root.next;
	    temp.next=null;
	    
	    // merge temp, ans
	    
	    temp1 = ans;
	    prev=null;
	    while(temp1!=null && temp!=null) {
	        if(temp1.data<temp.data) {
	            prev=temp1;
	            temp1=temp1.bottom;
	        } else {
	            if(prev==null) {
	                ans=temp;
	                prev=temp;
	                temp=temp.bottom;
	                prev.bottom=temp1;
	            } else {
	                prev.bottom=temp;
	                prev=temp;
	                temp2 = temp.bottom;
	                temp.bottom=temp1;
	                temp=temp2;
	            }
	        }
	    }
	    
	    if(temp!=null) {
	        if(prev==null) {
	            ans=temp;
	        } else {
	            prev.bottom=temp;
	        }
	    }
	    
	}
	return ans;
    }
}