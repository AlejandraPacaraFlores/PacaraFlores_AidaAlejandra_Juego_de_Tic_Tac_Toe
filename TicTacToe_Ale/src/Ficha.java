public class Ficha {
    private double posX, posY;    // Posición actual
    private double destX, destY;  // Destino
    private String tipo;          // "X" o "O"
    private boolean enMovimiento;

    public Ficha(double startX, double startY, String tipo) {
        this.posX = startX;
        this.posY = startY;
        this.tipo = tipo;
        this.enMovimiento = false;
    }

    public void setDestino(double x, double y) {
        this.destX = x;
        this.destY = y;
        this.enMovimiento = true;
    }

    public void actualizar() {
        if (enMovimiento) {
            posX += (destX - posX) * 0.1;
            posY += (destY - posY) * 0.1;
            if (Math.abs(posX - destX) < 1 && Math.abs(posY - destY) < 1) {
                posX = destX;
                posY = destY;
                enMovimiento = false;
            }
        }
    }

    public void dibujar(Graphics g) {
        g.drawString(tipo, (int) posX, (int) posY);
    }
}
