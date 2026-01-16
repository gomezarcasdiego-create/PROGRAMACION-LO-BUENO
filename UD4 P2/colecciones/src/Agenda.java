import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agenda {

    private ArrayList<Contacto> contactos;
    private Scanner sc;

    public Agenda() {
        contactos = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void anadeContacto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (existeContacto(nombre)) {
            System.out.println("Ya existe un contacto con ese nombre.");
            return;
        }

        boolean valido = true;

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        if (!correoValido(correo)) {
            System.out.println("Correo no válido.");
            valido = false;
        }

        if(!telefonoValido(telefono)) {
            System.out.println("telefono no valido.");
            valido = false;
        }


        if(valido){
            Contacto nuevo = new Contacto(nombre, telefono, correo);
            contactos.add(nuevo);
            System.out.println("Contacto añadido correctamente.");
        }

    }

    public void buscaContacto() {
        System.out.print("Nombre del contacto a buscar: ");
        String nombre = sc.nextLine();

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void eliminaContacto() {
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = sc.nextLine();

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(c);
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public void visualizaAgenda() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }

    private boolean existeContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private boolean correoValido(String correo) {
        String regex = "^[a-z0-9_.-]+@[a-z]+\\.[a-z]{2,4}$";
        return correo.matches(regex);
    }

    private boolean telefonoValido(String telefono) {
        String regex = "^[0-9]{9}$";
        return telefono.matches(regex);
    }

    public String numeroContactos() {
        return contactos.stream().map(Contacto::getNombre).collect(Collectors.joining(","));
    }
}