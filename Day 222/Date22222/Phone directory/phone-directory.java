//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    
    public static class TrieNode{
        TrieNode[] node;
        TreeSet<String> list;
        TrieNode() {
            node = new TrieNode[26];
            list = new TreeSet<>();
        }
    }
    
    public static void add(TrieNode root,String s) {
        for(int i=0;i<s.length();i++) {
            int idx = s.charAt(i)-'a';
            if(root.node[idx]==null) {
                root.node[idx]=new TrieNode();
            }
            root=root.node[idx];
            root.list.add(s);
        }
    }
    
    public static TreeSet<String> find(TrieNode root,String s) {
        for(int i=0;i<s.length();i++) {
            int idx = s.charAt(i)-'a';
            if(root.node[idx]==null) return new TreeSet<>();
            root=root.node[idx];
        }
        return root.list;
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        TrieNode root = new TrieNode();
        for(int i=0;i<n;i++) {
            add(root,contact[i]);
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            TreeSet<String> set = find(root,s.substring(0,i+1));
            ArrayList<String> list = new ArrayList<>();
            for(String str : set) list.add(str);
            if(list.size()==0) list.add("0");
            ans.add(list);
        }
        return ans;
    }
}