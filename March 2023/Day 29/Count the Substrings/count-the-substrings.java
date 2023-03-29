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
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    // Time Complexity :- O(n^2);
    // Space Complexity :- O(1);
    int countSubstring(String S) 
    { 
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0,ans=0;
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i)>='A' && S.charAt(i)<='Z') {
                sum++;
            } else {
                sum--;
            }
            
            if(map.containsKey(sum)) {
                ans+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }
        return ans;
    }
} 
