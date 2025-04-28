import hilos.clase.Persona;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona pe = new Persona();

        pe.setNombre("Pe Causatron");
        pe.setFechaNacimiento("12 del 12 del 12");
        pe.setDireccion("Chillopollo");

        System.out.println("Nombre: " + pe.getNombre());
        System.out.println("Fecha de nacimiento: " + pe.getFechaNacimiento());
        System.out.println("Direccion: " + pe.getDireccion());
    }
}