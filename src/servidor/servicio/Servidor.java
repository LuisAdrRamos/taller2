package servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public void servicio() {
        int puerto = 5000;
        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor ejecutado en el puerto: " + puerto);

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                String[] partes = mensaje.split(",");

                if (partes.length == 3) {
                    int numero1 = Integer.parseInt(partes[0]);
                    int numero2 = Integer.parseInt(partes[1]);
                    String operacion = partes[2].trim();

                    String respuesta;
                    switch (operacion) {
                        case "+":
                            respuesta = "Suma: " + (numero1 + numero2);
                            break;
                        case "-":
                            respuesta = "Resta: " + (numero1 - numero2);
                            break;
                        case "*":
                            respuesta = "Multiplicación: " + (numero1 * numero2);
                            break;
                        case "/":
                            respuesta = (numero2 != 0) ? "División: " + (numero1 / (double) numero2) : "Error: No se puede dividir por cero.";
                            break;
                        default:
                            respuesta = "Operación no válida.";
                    }

                    byte[] respuestaBytes = respuesta.getBytes();
                    DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                    socket.send(respuestaPacket);
                } else {
                    System.out.println("Mensaje no válido.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Servidor().servicio();
    }
}
