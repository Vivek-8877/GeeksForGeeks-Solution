//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		int previousIndex=0;
		for(int i=0;i<n;i++) {
		    if(arr[i]%2!=arr[previousIndex]%2) {
		        Arrays.sort(arr,previousIndex,i);
		        reverse(arr,previousIndex,i-1);
		        previousIndex=i;
		    }
		}
		Arrays.sort(arr,previousIndex,n);
		reverse(arr,previousIndex,n-1);
		return arr;
	}
	
	void reverse(int[] a,int strt,int end) {
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int i=strt;i<=end;i++) list.add(a[i]);
	    for(int i=strt,j=list.size()-1;i<=end;i++,j--) a[i]=list.get(j);
	}
}