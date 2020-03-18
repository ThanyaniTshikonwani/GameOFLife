public class GameOfLife {
    int w ;
    int h;
    int [][] board;

    public GameOfLife(int w , int h) {
        this.w = w;
        this.h = h;
        this.board =new int[w][h];
    }

    public  void showBoard(){

        for (int y=0; y<h;y++){
            StringBuilder line = new StringBuilder ( "/" );
            for (int x =0;x<w;x++){
                if (this.board[x][y]==0){
                    line.append ( "+" );//Dead Cell
                }else {
                    line.append ( "#" );// Alive Cell
                }
            }
            System.out.println (line);
        }
    }

    public void deadCell(int x , int y) {
        this.board[x][y] = 0;
    }

    public void aliveCell(int x , int y) {
        this.board[x][y] = 1;
    }

    public int countNeighbours(int x , int y) {
        int count = 0;
        count += getState ( x - 1 , y-1 );
        count += getState ( x  , y );
        count += getState ( x - 1 , y-1 );

        count += getState ( x + 1 , y );
        count += getState ( x - 1 , y );

        count += getState ( x -1 , y +1);
        count += getState ( x  , y +1);
        count += getState ( x + 1 , y+1 );
        return count;

}
    public int getState(int x , int y) {
        if (x < 0 || x >= w) {
            return 0;
        }

        if (y < 0 || y >= h) {
            return 0;
        }
        return this.board[x][y];
    }
    public void generation() {

        int[][] newBoard = new int[w][h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int aliveNeighbours = countNeighbours ( x , y );

                if (this.board[x][y] == 1) {
                    if (aliveNeighbours < 2) {
                        newBoard[x][y] = 0;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    } else if (aliveNeighbours > 3) {
                        newBoard[x][y] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    }
                }
            }
        }
        this.board = newBoard;
    }
}
