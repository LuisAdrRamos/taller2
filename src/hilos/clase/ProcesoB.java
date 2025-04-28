package hilos.clase;

public class ProcesoB extends Thread{

    private int n;

    public ProcesoB(int n) {
        this.n = n;
    }

    public void contar( int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Iteracion: " + i);
        }
    }

    public void run() {
        contar(n);
    }
}
