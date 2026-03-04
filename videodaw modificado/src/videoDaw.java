import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class videoDaw {

    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;

    private ArrayList <Articulo> articulosRegistrados;
    private ArrayList <Cliente> clientesRegistrados;

    public videoDaw() {
        this.CIF = "A00000000";
        this.direccion = "Sin dirección";
        this.fechaAlta = LocalDate.now();
        this.articulosRegistrados = new ArrayList<Articulo>();
        this.clientesRegistrados = new ArrayList<Cliente>();
    }

    private Articulo buscarArticulo(String cod) {
        for (Articulo p : articulosRegistrados) {
            if (p != null && p.getCod().equals(cod)) return p;
        }
        return null;
    }

    private Cliente buscarCliente(String dni) {
        for (Cliente c : clientesRegistrados) {
            if (c != null && c.getDNI().equals(dni)) return c;
        }
        return null;
    }

    public void registrarArticulo(Articulo p) {
        articulosRegistrados.add(p);
    }

    public void registrarCliente(Cliente c) {
        clientesRegistrados.add(c);
    }

    public void mostrarArticulosRegistradas() {
        for (Articulo p : articulosRegistrados) {
            if (p != null) p.toString();
        }
    }

    public void mostrarClientesRegistrados() {
        for (Cliente c : clientesRegistrados) {
            if (c != null) c.mostrarInfoCliente();
        }
    }

    public void mostrarInfoVideoClub() {
        System.out.println("\n--- VIDEOCLUB ---");
        System.out.println("CIF: " + CIF);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha Alta: " + fechaAlta);
    }

    public void alquilarPelicula(String cod, String dni) {
        Articulo a = buscarArticulo(cod);
        Cliente c = buscarCliente(dni);

        if (a == null || c == null) {
            System.out.println("Película no existe.");
            return;
        }

        if (a.isAlquilada()) {
            System.out.println("La articulo ya está alquilada.");
            return;
        }

        a.setAlquilada(true);
        a.setFechaAlquiler(LocalDateTime.now());
        c.alquilarArticulo(a);

        System.out.println("Película alquilada.");
    }

    public void devolverArticulo(String cod, String dni) {
        Articulo a = buscarArticulo(cod);
        Cliente c = buscarCliente(dni);

        if (a == null || c == null) {
            System.out.println("Película o cliente no existe.");
            return;
        }

        if (a.isAlquilada()) {
            System.out.println("El articulo no está disponible.");
            return;
        }

        if (a.getFechaAlquiler().plusHours(48).isBefore(LocalDateTime.now())) {
            System.out.println("Advertencia: más de 48 horas.");
        }

        a.setAlquilada(false);
        a.setFechaAlquiler(null);
        c.devolverArticulo(a);

        System.out.println("Película devuelta.");
    }

    public void darBajaCliente(String dni) {
        for (int i = 0; i < clientesRegistrados.size(); i++) {
            if (clientesRegistrados.get(i) != null &&
                    clientesRegistrados.get(i).getDNI().equals(dni)) {
                clientesRegistrados.get(i).setFechaBaja(LocalDate.now());
                clientesRegistrados.remove(i);
                System.out.println("Cliente dado de baja.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void darBajaArticulo(String cod) {
        for (int i = 0; i < articulosRegistrados.size(); i++) {
            if (articulosRegistrados.get(i) != null &&
                    articulosRegistrados.get(i).getCod().equals(cod)) {
                articulosRegistrados.get(i).setFechabaja(LocalDate.now());
                articulosRegistrados.remove(i);

                System.out.println("Película dada de baja.");
                return;
            }
        }
        System.out.println("Película no encontrada.");
    }
}
