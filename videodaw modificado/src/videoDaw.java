import java.time.LocalDate;
import java.time.LocalDateTime;

public class videoDaw {

    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;

    private Clasepelicula[] peliculasRegistradas;
    private Clasecliente[] clientesRegistrados;

    public videoDaw() {
        this.CIF = "A00000000";
        this.direccion = "Sin dirección";
        this.fechaAlta = LocalDate.now();
        this.peliculasRegistradas = new Clasepelicula[100];
        this.clientesRegistrados = new Clasecliente[100];
    }

    private Clasepelicula buscarPelicula(String cod) {
        for (Clasepelicula p : peliculasRegistradas) {
            if (p != null && p.getCod().equals(cod)) return p;
        }
        return null;
    }

    private Clasecliente buscarCliente(String dni) {
        for (Clasecliente c : clientesRegistrados) {
            if (c != null && c.getDNI().equals(dni)) return c;
        }
        return null;
    }

    public void registrarPelicula(Clasepelicula p) {
        for (int i = 0; i < peliculasRegistradas.length; i++) {
            if (peliculasRegistradas[i] == null) {
                peliculasRegistradas[i] = p;
                System.out.println("Película registrada.");
                return;
            }
        }
        System.out.println("No hay espacio para más películas.");
    }

    public void registrarCliente(Clasecliente c) {
        if (buscarCliente(c.getDNI()) != null) {
            System.out.println("El cliente ya está registrado.");
            return;
        }

        for (int i = 0; i < clientesRegistrados.length; i++) {
            if (clientesRegistrados[i] == null) {
                clientesRegistrados[i] = c;
                System.out.println("Cliente registrado.");
                return;
            }
        }
        System.out.println("No hay espacio para más clientes.");
    }

    public void mostrarPeliculasRegistradas() {
        for (Clasepelicula p : peliculasRegistradas) {
            if (p != null) p.mostrarInfoPelicula();
        }
    }

    public void mostrarClientesRegistrados() {
        for (Clasecliente c : clientesRegistrados) {
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
        Clasepelicula p = buscarPelicula(cod);
        Clasecliente c = buscarCliente(dni);

        if (p == null || c == null) {
            System.out.println("Película o cliente no existe.");
            return;
        }

        if (p.isAlquilada()) {
            System.out.println("La película ya está alquilada.");
            return;
        }

        p.setAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());
        c.alquilarPelicula(p);

        System.out.println("Película alquilada.");
    }

    public void devolverPelicula(String cod, String dni) {
        Clasepelicula p = buscarPelicula(cod);
        Clasecliente c = buscarCliente(dni);

        if (p == null || c == null) {
            System.out.println("Película o cliente no existe.");
            return;
        }

        if (!p.isAlquilada()) {
            System.out.println("La película no está alquilada.");
            return;
        }

        if (p.getFechaAlquiler().plusHours(48).isBefore(LocalDateTime.now())) {
            System.out.println("Advertencia: más de 48 horas.");
        }

        p.setAlquilada(false);
        p.setFechaAlquiler(null);
        c.devolverPelicula(p);

        System.out.println("Película devuelta.");
    }

    public void darBajaCliente(String dni) {
        for (int i = 0; i < clientesRegistrados.length; i++) {
            if (clientesRegistrados[i] != null &&
                    clientesRegistrados[i].getDNI().equals(dni)) {
                clientesRegistrados[i].setFechaBaja(LocalDate.now());
                clientesRegistrados[i] = null;
                System.out.println("Cliente dado de baja.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void darBajaPelicula(String cod) {
        for (int i = 0; i < peliculasRegistradas.length; i++) {
            if (peliculasRegistradas[i] != null &&
                    peliculasRegistradas[i].getCod().equals(cod)) {

                peliculasRegistradas[i].setFechaBaja(LocalDate.now());
                peliculasRegistradas[i] = null;

                System.out.println("Película dada de baja.");
                return;
            }
        }
        System.out.println("Película no encontrada.");
    }
}