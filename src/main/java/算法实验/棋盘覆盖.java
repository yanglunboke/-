package 算法实验;

public class 棋盘覆盖 {
    int tile=1;
    int [][]board;
    public void chessBoard(int tr,int tc,int dr,int dc,int size){
        if(size==1){
            return;
        }
        int s=size/2;
        int t=tile++;
        //如果特殊方格在左上角
        if(dr<tr+s&&dc<tc+s){
            chessBoard(tr,tc,dr,dc,s);
        }else{
            //如果特殊方格不在左上方，则用特殊方格覆盖它的右下角使它成为特殊棋盘后递归
            board[tr+s-1][tc+s-1]=t;
            chessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }
        //判断特殊方格在不在右上方
        if(dr<tr+s&&dc>=tc+s){
            chessBoard(tr,tc+s,dr,dc,s);
        }else {
            board[tr+s-1][tc+s]=t;
            chessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }
        //判断特殊方格在不在左下方
        if(dr>=tr+s&&dc<tc+s){
            chessBoard(tr+s,tc,dr,dc,s);
        }else {
            board[tr+s][tc+s-1]=t;
            chessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }
        //判断特殊方格在不在右下方
        if(dr>=tr+s&&dc>=tc+s){
            chessBoard(tr+s,tc+s,dr,dc,s);
        }else {
            board[tr+s][tc+s]=t;
            chessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }
}
