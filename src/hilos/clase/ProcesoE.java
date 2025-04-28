package hilos.clase;

import javax.swing.*;

public class ProcesoE implements Runnable {
    private String texto;

    public ProcesoE(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, texto);
    }
}
