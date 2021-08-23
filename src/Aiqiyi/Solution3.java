package Aiqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    public List<List<String>> solveNQueens(int n) {
        // 结果
        List<List<String>> res = new ArrayList<>();
        // 初始化棋盘
        // String不可变，StringBuilder可变
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                board[i][j] = ".";
            }
        }
        // 调用回溯算法
        backtrack(board, 0, res);
        return res;
    }
    // 回溯函数
    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    public void backtrack(String[][] board, int row, List<List<String>> res){
        int n = board.length;
        // 结束触发条件
        // 行到达边界
        if (row == n){
            // 将String[][]的board转换成ArrayList
            List<String> boardlist = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++){
                    s += board[i][j];
                }
                boardlist.add(s);
            }

            res.add(boardlist);
            return;
        }

        // 每一个列都可以尝试放一下
        for (int col = 0; col < n; col++){
            // 排除不合适的情况
            if (!isValid(board, row, col))
                continue;

            // 做选择，将col列的字符改为Q
            board[row][col] = "Q";
            // 进入下一次决策
            backtrack(board, row+1, res);
            // 撤销选择
            board[row][col] = ".";
        }
    }

    public boolean isValid(String[][] board, int row, int col){
        int n = board[row].length;
        // 检查列是否有冲突
        for (int i = 0; i < n; i ++){
            if (board[i][col] == "Q"){
                return false;
            }
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (board[i][j] == "Q")
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q")
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String s = sc.nextLine();
        int n = Integer.parseInt(s.substring(s.length()-1));
        List<List<String>> res = new Solution3().solveNQueens(n);
        System.out.println(res);
    }
}
