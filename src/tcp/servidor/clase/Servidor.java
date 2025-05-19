package tcp.servidor.clase;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

    private static final String RUTA = "C:/Users/APP DISTRIBUIDAS/IdeaProjects/taller1/src/tcp/servidor/registros";

    public static String getFecha(String nombre) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return nombre + " Fecha y hora registrada " + dateFormat.format(date);
    }

    public static void procesarSolicitud(int puerto) throws Exception {
        ServerSocket servidorTCP = new ServerSocket(puerto);
        System.out.println("Servidor ejecutado en el puerto: " + puerto);

        while (true) {
            Socket cliente = servidorTCP.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

            InputStream in = cliente.getInputStream();
            OutputStream out = cliente.getOutputStream();

            DataInputStream entrada = new DataInputStream(in);
            String nombre = entrada.readUTF();

            if(nombre.equals("x")) break;

            String mensaje = Servidor.getFecha(nombre);
            System.out.println("Mensaje recibido: " + mensaje);

            escribirRegistro(nombre, mensaje);

            DataOutputStream salida = new DataOutputStream(out);
            salida.writeUTF(mensaje);
            salida.close();
        }
        servidorTCP.close();
    }

    public static void escribirRegistro(String nombre, String mensaje) throws Exception {

        String ruta = "registro_horario_" + nombre + ".dat";
        FileOutputStream fos = new FileOutputStream(ruta, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(mensaje);
        oos.close();

        System.out.println("Registro de horario guardado en: " + ruta);
    }

    public static String leerRegistro(String nombre) throws Exception {
        String ruta = "registro_horario_" + nombre + ".dat";
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        String mensaje = (String) ois.readObject();
        ois.close();
        return mensaje;
    }
}
