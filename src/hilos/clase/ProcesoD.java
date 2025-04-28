package hilos.clase;

public class ProcesoD extends Thread{

    private int n;

    public ProcesoD(int n) {
        this.n = n;
    }

    public void imprimir(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print("*");
        }
    }

    public void run() {
        imprimir(n);
    }
}
