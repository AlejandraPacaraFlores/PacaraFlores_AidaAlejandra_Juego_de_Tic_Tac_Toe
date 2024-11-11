import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe extends JPanel {
    private String[][] board = new String[3][3];
    private boolean xTurn = true; // Para alterna X y O
    private int tileSize = 100;

    public TicTacToe() {
        this.setPreferredSize(new Dimension(300, 300));
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / tileSize;
                int col = e.getX() / tileSize;
                if (board[row][col] == null) {
                    board[row][col] = xTurn ? "X" : "O";
                    xTurn = !xTurn;
                    repaint();
                    checkWinCondition();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar el tablero
        for (int i = 0; i < 4; i++) {
            g.drawLine(i * tileSize, 0, i * tileSize, 300);
            g.drawLine(0, i * tileSize, 300, i * tileSize);
        }
        // Dibujar las fichas
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] != null) {
                    g.drawString(board[row][col], col * tileSize + 45, row * tileSize + 55);
                }
            }
        }
    }

    private void checkWinCondition() {
       
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new TicTacToe());
        frame.pack();
        frame.setVisible(true);
    }
}


