package hilos.clase;

public class ProcesoA extends Thread{

    private String nombre;

    public ProcesoA(String nombre) {
        this.nombre = nombre;
    }

    public void saludar(String nombre) {
        System.out.println("Hola " + nombre);
    }

    public void run() {
        saludar(nombre);
    }
}

