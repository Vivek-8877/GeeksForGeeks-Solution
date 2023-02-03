//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    pair<int,int> endPoints(vector<vector<int>> matrix){
        //code here
            return f(matrix,0,0,0,-1,-1);
    }
    // 0 -> right , 1 -> down , 2 -> left , 3 -> up;
    pair<int,int> f(vector<vector<int>>& a,int i,int j,int dir,int pi,int pj) {
        if(i<0 || j<0 || i>=a.size() || j>=a[i].size()) {
            pair<int,int> p1(pi,pj);
            return p1;
        }
        pair<int,int> ans;
        if(dir==0) {
            if(a[i][j]==0) {
                ans = f(a,i,j+1,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i+1,j,1,i,j);
            }
        } else if(dir==1) {
            if(a[i][j]==0) {
                ans = f(a,i+1,j,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i,j-1,2,i,j);
            }
        } else if(dir==2) {
            if(a[i][j]==0) {
                ans = f(a,i,j-1,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i-1,j,3,i,j);
            }
        } else {
            if(a[i][j]==0) {
                ans = f(a,i-1,j,dir,i,j);
            } else {
                a[i][j]=0;
                ans = f(a,i,j+1,0,i,j);
            }
        }
        return ans;
    }

};

//{ Driver Code Starts.


int main()
{
    int tc;
	scanf("%d", &tc);
	while(tc--){
		int row, col;
		scanf("%d", &row);
		scanf("%d", &col);
		vector<vector<int>> matrix(row , vector<int> (col));
	 
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
			    cin>>matrix[i][j];
			}
		}
		Solution obj;
		pair<int,int> p = obj.endPoints(matrix);
		
		cout << "(" << p.first << ", " << p.second << ")" << endl;
	}
	return 0;
}
// } Driver Code Ends