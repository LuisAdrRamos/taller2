package clase.test;

import clase.impl.operaciones_impl;
import clase.interfaz.operaciones;

import javax.swing.*;
import java.util.Scanner;

public class operacioesTest {
    public static void main(String[] args) {
        operaciones op = new operaciones_impl();

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        double x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primer numero"));

        System.out.println("Ingrese otro numero: ");
        double y = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primer numero"));

        JOptionPane.showMessageDialog(null, "La suma es " + op.sumar(x,y));

        sc.close();
    }
}
