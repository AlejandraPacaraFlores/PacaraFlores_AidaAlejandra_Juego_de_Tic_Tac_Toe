import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class animacion extends JPanel {

    public animacion() {

        Timer timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Ficha ficha : fichas) {
                    ficha.actualizar();
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar el tablero y fichas en movimiento
        for (Ficha ficha : fichas) {
            ficha.dibujar(g);
        }
    }
}

