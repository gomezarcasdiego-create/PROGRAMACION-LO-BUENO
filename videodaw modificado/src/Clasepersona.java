import java.time.LocalDateTime;

public class Clasepersona {

    private String DNI;
    private String Nombre;
    private String Direccion;
    private LocalDateTime fechaNacimiento;

    public Clasepersona(String DNI, String nombre, String direccion,
                        LocalDateTime fechaNacimiento) {
        this.DNI = DNI;
        Nombre = nombre;
        Direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Clasepersona() {

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
