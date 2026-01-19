import java.util.regex.Pattern;

public class Contacto {

    private String nombre;
    private String telefono;
    private String Correo;

    Pattern nombreD = Pattern.compile("(A-Z¨{0,}[a-z])");
    Pattern telefonoD = Pattern.compile("(6/7/9{8}[0-9])");
    Pattern CorreoD = Pattern.compile("[^a-z0-9_.-]+@[^a-z]+\\.[a-z]{2,4}€");

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.Correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Correo='" + Correo + '\'' +
                '}';
    }
}
