// Problem Link :- https://practice.geeksforgeeks.org/problems/alternate-vowel-and-consonant-string2939/1
// Video Solution Link :- https://youtu.be/tfpmSfEzKCg

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // Time Complexity :- O(n);
    // Space Complexity :- O(26);
    private static final int[] vowel = new int[]{0,'e'-'a','i'-'a','o'-'a','u'-'a'};
    public String rearrange(String S, int N){
        int[] fre = new int[26];
        int ct_vl=0;
        for(int i=0;i<N;i++) {
            char c = S.charAt(i);
            for(int idx : vowel) {
                if(idx==c-'a') {
                    ct_vl++;
                    break;
                }
            }
            fre[c-'a']++;
        }
        
        int ct_non_vl = N-ct_vl;
        if(!(ct_non_vl==ct_vl || ct_non_vl==ct_vl+1 || ct_non_vl+1==ct_vl)) return "-1";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            if(i%2==0) {
                if(ct_non_vl==ct_vl || ct_non_vl+1==ct_vl) {
                    // vowel
                    add_vowel(fre,sb);
                } else {
                    // non_vowel
                    add_non_vowel(fre,sb);
                }
            } else {
                if(ct_non_vl==ct_vl || ct_non_vl+1==ct_vl) {
                    // non_vowel
                    add_non_vowel(fre,sb);
                } else {
                    // vowel
                    add_vowel(fre,sb);
                }
            }
        }
        return sb.toString();
    }
    
    public static void add_vowel(int[] fre,StringBuilder sb) {
        for(int idx : vowel) {
            if(fre[idx]>0) {
                fre[idx]--;
                sb.append(Character.toString((char)(idx+'a')));
                return;
            }
        }
    }
    
    public static void add_non_vowel(int[] fre,StringBuilder sb) {
        for(int i=0;i<26;i++) {
            if(fre[i]<=0) continue;
            boolean is_Vowel=false;
            for(int idx : vowel) {
                if(i==idx) is_Vowel=true;
            }
            if(!is_Vowel) {
                fre[i]--;
                sb.append(Character.toString((char)(i+'a')));
                return;
            }
        }
    }
}
