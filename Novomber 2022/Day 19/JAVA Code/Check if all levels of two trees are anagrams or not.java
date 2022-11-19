// Problem Link :- https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1
// Video Solution Link :- https://youtu.be/yTy2MGkJmMc

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        ArrayDeque<Node> dq1 = new ArrayDeque<>();
        ArrayDeque<Node> dq2 = new ArrayDeque<>();
        dq1.add(node1);
        dq2.add(node2);
        while(dq1.size()>0 && dq2.size()>0) {
            int s1 = dq1.size();
            int s2 = dq2.size();
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            
            if(s1!=s2) return false;
            for(int i=0;i<s1;i++) {
                Node n1 = dq1.pop();
                Node n2 = dq2.pop();
                list1.add(n1.data);
                list2.add(n2.data);
                
                if(n1.left!=null) dq1.add(n1.left);
                if(n2.left!=null) dq2.add(n2.left);
                
                if(n1.right!=null) dq1.add(n1.right);
                if(n2.right!=null) dq2.add(n2.right);
            }
            
            Collections.sort(list1);
            Collections.sort(list2);
            
            for(int i=0;i<s1;i++) {
                // if(list1.get(i)!=list2.get(i)) return false;
                int v1 = list1.get(i);
                int v2 = list2.get(i);
                if(v1!=v2) return false;
            }
        }
        
        if(dq1.size()!=0 || dq2.size()!=0) return false;
        return true;
    }
}
        
