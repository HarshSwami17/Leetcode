class Solution {

    public boolean isSafe(char[][] board, int rows, int col) {
        for (int j = 0; j < board.length; j++) {
            if (board[rows][j] == 'Q') {
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] == 'Q') {
                return false;
            }
        }
        for (int i = rows, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = rows, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = rows, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = rows, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void safeboard(char[][] board, List<List<String>> allboard) {
        String rows = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            rows = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    rows += 'Q';
                else
                    rows += '.';
            }
            newBoard.add(rows);
        }

        allboard.add(newBoard);

    }

    public void helper(char[][] board, List<List<String>> allboard, int col) {
        if (col == board.length) {
            safeboard(board, allboard);
            return;
        }
        for (int rows = 0; rows < board.length; rows++) {
            if (isSafe(board, rows, col)) {
                board[rows][col] = 'Q';
                helper(board, allboard, col + 1);
                board[rows][col] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
        List<List<String>> allboard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board , allboard , 0);
        int totalsize = allboard.size();
        return totalsize;
        
    }
}