import java.util.Scanner;

public class FiveInARowGame {
    private static final int BOARD_SIZE = 15;
    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private char[][] board;

    public FiveInARowGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY) {
            return false;
        }
        board[row][col] = player;
        return true;
    }

    public boolean checkWin(int row, int col, char player) {
        // Check horizontally
        int count = 0;
        for (int i = Math.max(0, col - 4); i <= Math.min(BOARD_SIZE - 1, col + 4); i++) {
            if (board[row][i] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check vertically
        count = 0;
        for (int i = Math.max(0, row - 4); i <= Math.min(BOARD_SIZE - 1, row + 4); i++) {
            if (board[i][col] == player) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonally (top-left to bottom-right)
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col + i;
            if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
                if (board[r][c] == player) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonally (top-right to bottom-left)
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col - i;
            if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
                if (board[r][c] == player) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FiveInARowGame game = new FiveInARowGame();
        Scanner scanner = new Scanner(System.in);

        char currentPlayer = PLAYER_X;
        while (true) {
            game.printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column (e.g., 3 5): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col, currentPlayer)) {
                if (game.checkWin(row, col, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                if (currentPlayer == PLAYER_X) {
                    currentPlayer = PLAYER_O;
                } else {
                    currentPlayer = PLAYER_X;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
