package hilos.clase;

import javax.swing.*;
import java.awt.*;

import hilos.clase.Auto;

public class VistaAuto {
    private Auto auto;

    public VistaAuto(Auto auto) {
        this.auto = auto;
    }

    public void mostrar() {
        JFrame frame = new JFrame("Vista de Auto");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // 3 filas y 2 columnas

        // Crear etiquetas para mostrar los datos del auto
        JLabel marcaLabel = new JLabel("Marca: " + auto.getMarca());
        JLabel modeloLabel = new JLabel("Modelo: " + auto.getModelo());
        JLabel precioLabel = new JLabel("Precio: " + auto.getPrecio());

        // Agregar las etiquetas al panel
        panel.add(marcaLabel);
        panel.add(modeloLabel);
        panel.add(precioLabel);

        // Agregar el panel al frame
        frame.add(panel);

        // Configurar el frame
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}