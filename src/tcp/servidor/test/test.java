package tcp.servidor.test;

import tcp.servidor.clase.Servidor;

import java.sql.SQLOutput;

public class test {
    public static void main(String[] args) throws Exception {
        String nombre = "Luis Ramos";
        String mensaje = Servidor.getFecha(nombre);

//        System.out.println(mensaje);

        Servidor.escribirRegistro(nombre, mensaje);

        System.out.println(Servidor.leerRegistro(nombre));

        Servidor.procesarSolicitud(5000);
    }
}
