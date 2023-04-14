package 算法实验;

import static org.junit.jupiter.api.Assertions.*;

class 棋盘覆盖Test {
    public static void main(String[] args) {
        棋盘覆盖 棋盘覆盖 = new 棋盘覆盖();
        棋盘覆盖.board=new int[4][4];
        棋盘覆盖.chessBoard(0,0,3,3,4);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(棋盘覆盖.board[i][j]);
            }
            System.out.println();
        }
    }
}