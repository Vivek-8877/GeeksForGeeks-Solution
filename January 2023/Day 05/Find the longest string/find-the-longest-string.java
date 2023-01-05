//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static class TrieNode{
        TrieNode[] node;
        boolean isWord=false;
        TrieNode() {
            node = new TrieNode[26];
        }
    }
    
    public static void add(TrieNode root,String s) {
        int idx;
        for(int i=0;i<s.length();i++) {
            idx = s.charAt(i)-'a';
            if(root.node[idx]==null) root.node[idx] = new TrieNode();
            root = root.node[idx];
        }
        root.isWord=true;
    }
    
    public static boolean isValid(TrieNode root,String s) {
        int idx;
        for(int i=0;i<s.length();i++) {
            idx = s.charAt(i)-'a';
            // if(root.node[idx]==null) return false;
            root = root.node[idx];
            if(!root.isWord) return false;
        }
        return true;
    }
    
    public static String longestString(int n, String[] arr) {
        // code here
        TrieNode root = new TrieNode();
        for(String s : arr) {
            add(root,s);
        }
        String ans ="";
        for(String s : arr) {
            if(isValid(root,s)) {
                if(ans.length()<s.length()) {
                    ans=s;
                } else if(ans.length()==s.length()) {
                    if(ans.compareTo(s)>0) ans=s;
                }
            }
        }
        return ans;
    }
}
        
