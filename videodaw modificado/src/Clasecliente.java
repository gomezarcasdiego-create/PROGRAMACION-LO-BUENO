import java.time.LocalDate;
import java.util.Arrays;

public class Clasecliente extends Clasepersona{

    private String DNI;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Clasepelicula[] peliculasAlquiladas;

    public Clasecliente(String DNI, String nombre, String numSocio, LocalDate fechaNacimiento) {
        super();
        this.DNI = DNI;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = "";
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Clasepelicula[10];
    }

    public String getDNI() {
        return DNI;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void alquilarPelicula(Clasepelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) {
                peliculasAlquiladas[i] = p;
                return;
            }
        }
    }

    public void devolverPelicula(Clasepelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] != null && peliculasAlquiladas[i].getCod().equals(p.getCod())) {
                peliculasAlquiladas[i] = null;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Clasecliente{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numSocio='" + numSocio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaBaja=" + fechaBaja +
                ", peliculasAlquiladas=" + Arrays.toString(peliculasAlquiladas) +
                '}';
    }

    public void mostrarInfoCliente() {
        System.out.println("DNI: " + DNI);
        System.out.println("Nombre: " + nombre);
        System.out.println("NumSocio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha nacimiento: " + fechaNacimiento);
        System.out.println("Fecha baja: " + fechaBaja);
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas alquiladas:");
        for (Clasepelicula p : peliculasAlquiladas) {
            if (p != null) System.out.println("- " + p.getTitulo());
        }
    }
}