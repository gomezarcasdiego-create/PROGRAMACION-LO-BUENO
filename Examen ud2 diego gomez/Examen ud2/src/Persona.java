import java.time.LocalDate;

public abstract class Persona {

    String nombre;
    LocalDate FechaNacimiento;
    String DNI;
    String Direccion;
    String Telefono;

    public Persona(String nomnre, LocalDate FechaNacimiento, String DNI, String Direcion, String Telefono) {
        this.nombre = nomnre;
        this.FechaNacimiento = FechaNacimiento;
        this.DNI = DNI;
        this.Direccion = Direcion;
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

}
