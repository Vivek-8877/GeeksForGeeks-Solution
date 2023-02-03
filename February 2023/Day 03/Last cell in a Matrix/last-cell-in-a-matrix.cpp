//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(1);
    // 0 -> right , 1 -> down , 2 -> left , 3 -> up;
    pair<int,int> endPoints(vector<vector<int>> matrix, int R, int C){
        //code here
        int i=0,j=0,dir=0;
        pair<int,int> ans;
        while(i<matrix.size() && j<matrix[i].size()) {
            ans.first=i;
            ans.second=j;
            if(dir==0) {
                if(matrix[i][j]==0) {
                    j++;
                } else {
                    matrix[i][j]=0;
                    i++;
                    dir=1;
                }
            } else if(dir==1) {
                if(matrix[i][j]==0) {
                    i++;
                } else {
                    matrix[i][j]=0;
                    j--;
                    dir=2;
                }
            } else if(dir==2) {
                if(matrix[i][j]==0) {
                    j--;
                } else {
                    matrix[i][j]=0;
                    i--;
                    dir=3;
                }
            } else {
                if(matrix[i][j]==0) {
                    i--;
                } else {
                    matrix[i][j]=0;
                    j++;
                    dir=0;
                }
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
		pair<int,int> p = obj.endPoints(matrix, row, col);
		
		cout << "(" << p.first << ", " << p.second << ")" << endl;
	}
	return 0;
}
// } Driver Code Ends