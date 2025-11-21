import java.time.LocalDate;

public class Clasecliente {
    public class Numsocio {
    }

    private String DNI;
    private String nombre;
    private int NumSocio;
    private String direccion;
    LocalDate fechanacimiento;
    LocalDate fechabaja;
    private String peliculasalquiladas;

    private Numsocio[] Numsocios;
    private int Fechanacimiento;
    private int Fechabaja;

    LocalDate getFechanacimiento() {
        if (fechanacimiento == null) {
            return LocalDate.now();
        }
    return fechanacimiento;}

    public Clasecliente(String DNI, String nombre, String direccion, String peliculasalquiladas) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculasalquiladas = peliculasalquiladas;
    }

    public void mostrarinfoCliente() {
        System.out.println("DNI: " + DNI);
        System.out.println("Nombre: " + nombre);
        System.out.println("NumSocio" + NumSocio);
        System.out.println("Direccion: " + direccion);
        System.out.println("Fechanacimiento: " + fechanacimiento);
        System.out.println("Fechabaja: " + fechabaja);
        System.out.println("peliculasalquiladas: " + peliculasalquiladas);

    }
    public void mostrarinfoNumsocio() {
        System.out.println("Numsocio: " + Numsocios[0]);
    }

    public static void ultimaspeliculasalquiladas() {
        System.out.println("mostrarPeliculasalquiladas()");
    }
}
