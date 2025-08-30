public class num36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] row = new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }else {
                    if(row[board[i][j]-'1']){
                        return false;
                    }
                    row[board[i][j]-'1']=true;
                }
            }
        }
        for(int j=0;j<9;j++){
            boolean[] col = new boolean[9];
            for(int i=0;i<9;i++){
                if(board[i][j]=='.'){
                    continue;
                }else {
                    if(col[board[i][j]-'1']){
                        return false;
                    }
                    col[board[i][j]-'1']=true;
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean[] block = new boolean[9];
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(board[x][y]=='.'){
                            continue;
                        }else {
                            if(block[board[x][y]-'1']){
                                return false;
                            }
                            block[board[x][y]-'1']=true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
