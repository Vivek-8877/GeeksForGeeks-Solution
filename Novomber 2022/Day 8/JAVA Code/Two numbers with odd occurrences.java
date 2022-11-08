//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        int aXORb=0;
        for(int num : Arr) aXORb^=num;
        
        int rightMostSetBit = aXORb & (-aXORb);
        
        int a=0,b=0;
        for(int num : Arr) {
            if((num & rightMostSetBit)==0) {
                a^=num;
            } else {
                b^=num;
            }
        }
        if(a<b) {
            int temp =a;
            a=b;
            b=temp;
        }
        return new int[]{a,b};
    }
}
