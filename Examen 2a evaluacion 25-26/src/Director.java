import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Director extends Trabajador implements Serializable{

    @Serial
    private static final long serialVersionUID = 1880531401635374735L;
    private String numeroTelefono;
    private String cocheEmpresa;

    public Director(String nombre, LocalDate fechaDeNacimiento, String dni, String direccion, int numeroSS, String emailEmpresa, int salario, Enum departamento,
                    String numeroTelefono, String cocheEmpresa) {
        super(nombre, fechaDeNacimiento, dni, direccion, numeroSS, emailEmpresa, salario, departamento);
        this.numeroTelefono = numeroTelefono;
        this.cocheEmpresa = cocheEmpresa;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCocheEmpresa() {
        return cocheEmpresa;
    }

    public void setCocheEmpresa(String cocheEmpresa) {
        this.cocheEmpresa = cocheEmpresa;
    }

    @Override
    public String toString() {
        return "Director{" +
                "numeroTelefono='" + numeroTelefono + '\'' +
                ", cocheEmpresa='" + cocheEmpresa + '\'' +
                '}';
    }

    public void conductores(){

    }

    public void validarNumeroTelefono(String numeroTelefono){

    }
}
