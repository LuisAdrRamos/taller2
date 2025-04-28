package hilos.test;

import hilos.clase.*;
import hilos.clase.FormularioAuto;

public class test {
    public static void main(String[] args) {
        ProcesoA pA = new ProcesoA("lUCHO");
        ProcesoB pB = new ProcesoB(10);
        ProcesoC pC = new ProcesoC(10);
        ProcesoD pD = new ProcesoD(100);

        pA.start();
        pB.start();
        pC.start();
        pD.start();

        FormularioAuto formularioAuto = new FormularioAuto();
        Thread threadFormulario = new Thread(formularioAuto);
        threadFormulario.start();


        Persona pe = new Persona();

        pe.setNombre("Pe Causatron");
        pe.setFechaNacimiento("12 del 12 del 12");
        pe.setDireccion("Chillopollo");

        System.out.println("Nombre: " + pe.getNombre());
        System.out.println("Fecha de nacimiento: " + pe.getFechaNacimiento());
        System.out.println("Direccion: " + pe.getDireccion());
    }
}
