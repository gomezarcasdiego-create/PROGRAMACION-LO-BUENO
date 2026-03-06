import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona implements Serializable {

    private String DNI;
    private String nombre;
    private String direccion;
    private LocalDate fechaDeNacimiento;

    public Persona(String DNI,String nombre, LocalDate fechaDeNacimiento, String direccion)  throws Exception {

        if(this.mayorDeEdad(fechaDeNacimiento)){
            this.fechaDeNacimiento = fechaDeNacimiento;

        } else{
            throw new Exception("El cliente no es mayor de edad");
        }
        this.DNI = DNI;
        this.direccion = direccion;
                this.nombre = nombre;
    }


    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                '}';
    }

    private boolean mayorDeEdad(LocalDate fechaDeNacimiento) {
        LocalDate hoy = LocalDate.now();
        hoy.minusYears(18);
        return hoy.isAfter(fechaDeNacimiento);
    }
}
