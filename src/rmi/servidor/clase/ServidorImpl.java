
package rmi.servidor.clase;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{

    private static ArrayList<Persona> listaPersonas() {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Adrian", "adrian@empresa.com", "Gerente", 100000.00));
        lista.add(new Persona(2, "Pepe", "pepe@empresa.com", "Limpieza", 100000.00));
        lista.add(new Persona(3, "Juan", "juan@empresa.com", "Bodega", 100000.00));
        lista.add(new Persona(4, "Maria", "maria@empresa.com", "Vendedora", 100000.00));
        lista.add(new Persona(5, "Ana", "ana@empresa.com", "Vendedora", 100000.00));
        lista.add(new Persona(6, "Jose", "jose@empresa.com", "Mantenimiento", 100000.00));
        lista.add(new Persona(7, "Mario", "mario@empresa.com", "Mantenimiento", 100000.00));
        lista.add(new Persona(8, "Carla", "carla@empresa.com", "Marketing", 100000.00));
        lista.add(new Persona(9, "Samy", "samy@empresa.com", "Marketing", 100000.00));
        lista.add(new Persona(10, "Josue", "josue@empresa.com", "Dev. Senior Software", 100000.00));

        return lista;
    }

    private static String getPersonas(int id) {
        return "Nombre: " + listaPersonas().get(id - 1).getNombre() + "\n" +
                "Correo: " + listaPersonas().get(id - 1).getCorreo() + "\n" +
                "Cargo: " + listaPersonas().get(id - 1).getCargo() + "\n" +
                "Sueldo: " + listaPersonas().get(id - 1).getSueldo();
    }

    public ServidorImpl() throws RemoteException { super(); }

    @Override
    public String consultar(int id) throws RemoteException {
        if (id < listaPersonas().size() + 1) {
            return getPersonas(id);
        } else{
            return "No existe datos del Empleado";
        }
    }
}