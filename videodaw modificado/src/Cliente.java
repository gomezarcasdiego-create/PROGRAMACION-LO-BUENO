import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona{

    private String numSocio;
    private LocalDate fechaBaja;
    private ArrayList <Articulo> articulosAlquilados;

    public Cliente(String DNI, String nombre, String numSocio, LocalDate fechaNacimiento, String direccion) throws Exception {
        super(DNI, nombre, fechaNacimiento, direccion);
        this.numSocio = numSocio;
        this.fechaBaja = null;
        this.articulosAlquilados = new ArrayList<Articulo>();
    }



    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void alquilarArticulo(Articulo a) {
        this.articulosAlquilados.add(a);
    }

    public void devolverArticulo(Articulo a) {
        this.articulosAlquilados.remove(a);
    }

    public void mostrarInfoCliente() {
        System.out.println(super.toString());
        System.out.println("NumSocio: " + numSocio);
        System.out.println("Fecha baja: " + fechaBaja);
    }

    public void mostrarArticulosAlquilados() {
        System.out.println("Películas alquiladas:");
        for (Articulo p : articulosAlquilados) {
            if (p != null) System.out.println("- " + p.getTitulo());
        }
    }
}
