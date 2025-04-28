package hilos.clase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hilos.clase.VistaAuto;

public class FormularioAuto implements Runnable {
    private JTextField marcaInput;
    private JTextField modeloInput;
    private JTextField precioInput;
    private JButton button1;

    private Auto auto = new Auto();

    @Override
    public void run() {
        JFrame frame = new JFrame("Formulario de Auto");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2)); // 4 filas y 2 columnas

        // Inicializar los componentes
        marcaInput = new JTextField();
        modeloInput = new JTextField();
        precioInput = new JTextField();
        button1 = new JButton("Guardar");

        // Agregar los componentes al panel
        panel.add(new JLabel("Marca:"));
        panel.add(marcaInput);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloInput);
        panel.add(new JLabel("Precio:"));
        panel.add(precioInput);
        panel.add(button1);

        // Agregar el panel al frame
        frame.add(panel);

        // Configurar el frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Agregar los FocusListeners
        marcaInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // No hacer nada
            }

            @Override
            public void focusLost(FocusEvent e) {
                auto.setMarca(marcaInput.getText());
            }
        });
        modeloInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // No hacer nada
            }

            @Override
            public void focusLost(FocusEvent e) {
                auto.setModelo(modeloInput.getText());
            }
        });
        precioInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // No hacer nada
            }

            @Override
            public void focusLost(FocusEvent e) {
                auto.setPrecio(Integer.parseInt(precioInput.getText()));
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para guardar el auto
                VistaAuto vistaAuto = new VistaAuto(auto);
                vistaAuto.mostrar();
            }
        });
    }
}
