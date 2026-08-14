class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {

        // All characters matched
        if (idx == word.length()) {
            return true;
        }

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        // Mark visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        boolean found =
                dfs(board, word, r + 1, c, idx + 1) ||
                dfs(board, word, r - 1, c, idx + 1) ||
                dfs(board, word, r, c + 1, idx + 1) ||
                dfs(board, word, r, c - 1, idx + 1);

        // Backtrack
        board[r][c] = temp;

        return found;
    }
}