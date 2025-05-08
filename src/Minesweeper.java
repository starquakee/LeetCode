import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Minesweeper extends JFrame {
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 50;
    private static final int MINES_COUNT = 15;

    private JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
    private boolean[][] mines = new boolean[GRID_SIZE][GRID_SIZE];
    private boolean[][] revealed = new boolean[GRID_SIZE][GRID_SIZE];
    private boolean[][] flagged = new boolean[GRID_SIZE][GRID_SIZE];
    private int remainingCells;
    private JLabel statusLabel;
    private boolean gameOver = false;

    public Minesweeper() {
        setTitle("扫雷游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 创建状态栏
        statusLabel = new JLabel("剩余地雷: " + MINES_COUNT);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        // 创建游戏面板
        JPanel gamePanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        initializeButtons(gamePanel);
        add(gamePanel, BorderLayout.CENTER);

        // 创建重新开始按钮
        JButton restartButton = new JButton("重新开始");
        restartButton.addActionListener(e -> restartGame());
        add(restartButton, BorderLayout.SOUTH);

        // 初始化游戏
        initializeGame();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeButtons(JPanel panel) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setBackground(new Color(230, 230, 255)); // 设置未点击按钮为浅蓝色
                button.setFocusPainted(false); // 去除焦点边框

                final int r = row;
                final int c = col;

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (gameOver) return;

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            // 左键点击
                            handleCellClick(r, c);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            // 右键点击
                            toggleFlag(r, c);
                        }
                    }
                });

                buttons[row][col] = button;
                panel.add(button);
            }
        }
    }

    private void initializeGame() {
        // 重置所有状态
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                mines[row][col] = false;
                revealed[row][col] = false;
                flagged[row][col] = false;
                buttons[row][col].setText("");
                buttons[row][col].setBackground(new Color(230, 230, 255)); // 设置回初始浅蓝色
                buttons[row][col].setEnabled(true);
            }
        }

        // 随机放置地雷
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < MINES_COUNT) {
            int row = random.nextInt(GRID_SIZE);
            int col = random.nextInt(GRID_SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                minesPlaced++;
            }
        }

        remainingCells = GRID_SIZE * GRID_SIZE - MINES_COUNT;
        gameOver = false;
        updateStatusLabel();
    }

    private void handleCellClick(int row, int col) {
        // 如果单元格已经被揭示或被标记为地雷，则忽略点击
        if (revealed[row][col] || flagged[row][col]) {
            return;
        }

        // 如果点击到地雷，游戏结束
        if (mines[row][col]) {
            revealAllMines();
            buttons[row][col].setBackground(Color.RED);
            gameOver = true;
            JOptionPane.showMessageDialog(this, "游戏结束！你踩到地雷了！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // 揭示单元格
        revealCell(row, col);

        // 检查是否获胜
        if (remainingCells == 0) {
            gameOver = true;
            JOptionPane.showMessageDialog(this, "恭喜你赢了！", "胜利", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void revealCell(int row, int col) {
        // 如果单元格已经被揭示，则返回
        if (revealed[row][col]) {
            return;
        }

        // 揭示当前单元格
        revealed[row][col] = true;
        remainingCells--;

        // 计算周围地雷数量
        int minesCount = countAdjacentMines(row, col);

        // 设置已点击格子的背景色为浅灰色
        buttons[row][col].setBackground(new Color(220, 220, 220));
        buttons[row][col].setEnabled(false);

        if (minesCount > 0) {
            // 显示数字
            buttons[row][col].setText(String.valueOf(minesCount));
            setNumberColor(buttons[row][col], minesCount);
        } else {
            // 如果周围没有地雷，显示空白并递归揭示周围单元格
            // 揭示周围的八个单元格
            for (int r = Math.max(0, row - 1); r <= Math.min(GRID_SIZE - 1, row + 1); r++) {
                for (int c = Math.max(0, col - 1); c <= Math.min(GRID_SIZE - 1, col + 1); c++) {
                    if (r != row || c != col) {
                        revealCell(r, c);
                    }
                }
            }
        }
    }

    private void toggleFlag(int row, int col) {
        // 只有未揭示的单元格才能标记或取消标记
        if (!revealed[row][col]) {
            flagged[row][col] = !flagged[row][col];
            if (flagged[row][col]) {
                buttons[row][col].setText("🚩");
            } else {
                buttons[row][col].setText("");
            }
            updateStatusLabel();
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int r = Math.max(0, row - 1); r <= Math.min(GRID_SIZE - 1, row + 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(GRID_SIZE - 1, col + 1); c++) {
                if (mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void setNumberColor(JButton button, int number) {
        Color[] colors = {
                null,       // 0 - 不使用
                Color.BLUE, // 1
                new Color(0, 128, 0), // 2 - 深绿色
                Color.RED,  // 3
                new Color(0, 0, 128), // 4 - 深蓝色
                new Color(128, 0, 0), // 5 - 深红色
                new Color(0, 128, 128), // 6 - 青色
                Color.BLACK, // 7
                Color.GRAY   // 8
        };

        if (number > 0 && number <= 8) {
            button.setForeground(colors[number]);
        }
    }

    private void revealAllMines() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (mines[row][col]) {
                    if (!flagged[row][col]) {
                        buttons[row][col].setText("💣");
                    }
                } else if (flagged[row][col]) {
                    // 标记错误
                    buttons[row][col].setText("❌");
                }
            }
        }
    }

    private void updateStatusLabel() {
        int flagCount = 0;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (flagged[row][col]) {
                    flagCount++;
                }
            }
        }
        statusLabel.setText("剩余地雷: " + (MINES_COUNT - flagCount));
    }

    private void restartGame() {
        initializeGame();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Minesweeper());
    }
}