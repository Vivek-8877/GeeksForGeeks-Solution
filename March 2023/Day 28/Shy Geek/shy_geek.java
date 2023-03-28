//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        

        while(t-->0){
            Shop shop = new Shop();

            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);

            s = br.readLine().trim().split(" ");

            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }
            
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }

    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        
        long ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(k>0) {
            long value = search(k,n,map);
            if(value==-1) break;
            ans+=(k/value);
            k%=value;
        }
        return ans;
    }
    
    public static int search(long val,int n,HashMap<Integer,Integer> map) {
        int lo=0,hi=n-1;
        int ans=-1;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int cost;
            if(map.get(mid)==null) {
                 cost = shop.get(mid);
                 map.put(mid,cost);
            } else {
                 cost=map.get(mid);
            }
            
            if(cost==-1) return -1;
            
            if(cost<val) {
                ans=cost;
                lo=mid+1;
            } else if(cost>val) {
                hi=mid-1;
            } else {
                return cost;
            }
        }
        return ans;
    }

}
