//{ Driver Code Starts
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
    static void postOrder(Node root)
    {
        if(root == null)
            return;
            
        postOrder(root.left);
         postOrder(root.right);
        System.out.print(root.data+" ");
    
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
                g.convertToMaxHeapUtil(root);
                postOrder(root);
                
                System.out.println();
                    
                t--;
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static class TreeNode{
        Node node;
        int lft;
        int rt;
        TreeNode(Node node,int lft,int rt) {
            this.node=node;
            this.lft=lft;
            this.rt=rt;
        }
    }
    
    public static void convertToMaxHeapUtil(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        In_Order(root,list);
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        
        root.data=list.get(list.size()-1);
        root.left=null;
        root.right=null;
        dq.add(new TreeNode(root,0,list.size()-2));
        while(dq.size()>0) {
            TreeNode t = dq.pop();
            int mid = t.lft+(t.rt-t.lft)/2;
            if(t.lft>t.rt || t.lft<0 || t.rt<0 || t.lft>=list.size() || t.rt>=list.size()) continue;
            if(mid>=0) {
                t.node.left = new Node(list.get(mid));
                dq.add(new TreeNode(t.node.left,t.lft,mid-1));
            }
            if(t.rt>=0 && mid!=t.rt) {
                t.node.right = new Node(list.get(t.rt));
                dq.add(new TreeNode(t.node.right,mid+1,t.rt-1));
            }
        }
    }
    
    public static void In_Order(Node root,ArrayList<Integer> list) {
        if(root==null) return;
        In_Order(root.left,list);
        list.add(root.data);
        In_Order(root.right,list);
    }
    
}
