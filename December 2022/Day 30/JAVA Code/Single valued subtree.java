// Probelm Link :- https://practice.geeksforgeeks.org/problems/single-valued-subtree/1
// Video Solution Link :- 

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
                System.out.println(g.singlevalued(root));
                    
                t--;
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution
{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public int singlevalued(Node root)
    {
        //code here
        return f(root)[1];
    }
    public static int[] f(Node root) {
        int status=0,value=0;
        if(root.left==null && root.right==null) {
            status=1;
            value=1;
        } else if(root.left==null) {
            int[] v1 = f(root.right);
            value=v1[1];
            if(v1[0]==1 && root.data==root.right.data) {
                status=1;
                value++;
            }
        } else if(root.right==null) {
            int[] v1 = f(root.left);
            value=v1[1];
            if(v1[0]==1 && root.data==root.left.data) {
                status=1;
                value++;
            }
        } else {
            int[] v1 = f(root.left);
            int[] v2 = f(root.right);
            value=v1[1]+v2[1];
            if(v1[0]==1 && v2[0]==1 && root.data==root.left.data && root.data==root.right.data) {
                status=1;
                value++;
            }
        }
        return new int[]{status,value};
    }
}