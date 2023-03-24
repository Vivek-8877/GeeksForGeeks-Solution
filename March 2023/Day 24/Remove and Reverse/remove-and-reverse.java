//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        int[] fre = new int[26];
        for(int i=0;i<S.length();i++) fre[S.charAt(i)-'a']++;
        int i=0,j=S.length()-1,time=0;
        byte[] isRemoved = new byte[S.length()];
        while(i<=j) {
            if(time%2==0) {
                if(fre[S.charAt(i)-'a']>1) {
                    time++;
                    isRemoved[i]=1;
                    fre[S.charAt(i)-'a']--;
                }
                i++;
            } else {
                if(fre[S.charAt(j)-'a']>1) {
                    time++;
                    isRemoved[j]=1;
                    fre[S.charAt(j)-'a']--;
                }
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(i=0;i<S.length();i++) if(isRemoved[i]==0) sb.append(S.substring(i,i+1));
        if(time%2==1) sb.reverse();
        return sb.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends