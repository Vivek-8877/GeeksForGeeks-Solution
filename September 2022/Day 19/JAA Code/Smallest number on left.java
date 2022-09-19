//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        
        //code here
        Stack<Integer> stack = new Stack<>();
        int i=0;
        List<Integer> ans = new ArrayList<>();
        
        // for(int i=0;i<n;i++) {
        //     int val=-1;
        //     for(int j=i-1;j>=0;j--) {
        //         if(a[j]<a[i]) {
        //             val=a[j];
        //             break;
        //         }
        //     }
        //     ans.add(val);
        // }
        
        while(i<n) {
            while(stack.size()>0 && stack.peek()>=a[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            stack.push(a[i]);
            i++;
        }
        return ans;
    }
}
