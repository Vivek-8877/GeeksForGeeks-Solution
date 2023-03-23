//{ Driver Code Starts
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

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        return search(root,target,0);
    }
    
    public static int search(Node root,int target,int sum) {
        if(root==null) return -1;
        if(root.data<target) {
            return search(root.right,target,sum+root.data);
        } else if(root.data>target) {
            return search(root.left,target,sum+root.data);
        } else {
            int min = Math.min(minimumSum(root.left),minimumSum(root.right));
            if(min==Integer.MAX_VALUE) min=0;
            return sum-min;
        }
    }
    
    public static int minimumSum(Node root) {
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) {
            return root.data;
        } else if(root.left==null) {
            return minimumSum(root.right)+root.data;
        } else if(root.right==null) {
            return minimumSum(root.left)+root.data;
        } else {
            return Math.min(minimumSum(root.left),minimumSum(root.right))+root.data;
        }
    }
}