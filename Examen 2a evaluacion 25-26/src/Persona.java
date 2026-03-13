import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 19543786674548L;
    private static String nombre;
    private LocalDate fechaNacimiento;
    private static String dni;
    private static String direccion;

    public Persona(String nombre, LocalDate fechaNacimiento, String dni, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }

    public static String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public static String getDni() {
        return dni;
    }

    public static String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
