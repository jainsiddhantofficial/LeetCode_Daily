class Solution {

    public void dfs(int r,int c,int[][] visited,char[][] board,int row,int col){
        visited[r][c]=1;
        if(c+1<col && board[r][c+1]=='O'&&visited[r][c+1]==0){
            dfs(r,c+1,visited,board,row,col);
        }
        if(c>0 && board[r][c-1]=='O'&&visited[r][c-1]==0){
            dfs(r,c-1,visited,board,row,col);
        }
        if(r+1<row && board[r+1][c]=='O'&&visited[r+1][c]==0){
            dfs(r+1,c,visited,board,row,col);
        }
        if(r>0 && board[r-1][c]=='O'&&visited[r-1][c]==0){
            dfs(r-1,c,visited,board,row,col);
        }
    }

    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        int[][] visited=new int[r][c];

        for(int j=0;j<c;j++){
            if(board[0][j]=='O'&&visited[0][j]==0){
                dfs(0,j,visited,board,r,c);
            }
            if(board[r-1][j]=='O' && visited[r-1][j]==0){
                dfs(r-1,j,visited,board,r,c);
            }
        }
        for(int i=0;i<r;i++){
            if(board[i][0]=='O'&&visited[i][0]==0){
                dfs(i,0,visited,board,r,c);
            }
            if(board[i][c-1]=='O'&&visited[i][c-1]==0){
                dfs(i,c-1,visited,board,r,c);
            }
        }
        for(int i=1;i<r-1;i++){
            for(int j=1;j<c-1;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }
}