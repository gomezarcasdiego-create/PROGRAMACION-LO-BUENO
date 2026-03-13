import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenteDep extends Trabajador implements Serializable {

    @Serial
    private static final long serialVersionUID = -7965412332939787204L;
    private int numeroTrabajadores;
    private Enum gerencia;
    private String coleccionTrabajadores;

    public GerenteDep(String nombre, LocalDate fechaDeNacimiento, String dni, String direccion, int numeroSS, String emailEmpresa, int salario, Enum departamento,
                      int numeroTrabajadores, Enum gerencia, String coleccionTrabjadores) {
        super(nombre, fechaDeNacimiento, dni, direccion, numeroSS, emailEmpresa, salario, departamento);
        this.numeroTrabajadores = numeroTrabajadores;
        this.gerencia = gerencia;
        this.coleccionTrabajadores = coleccionTrabjadores;
    }

    public int getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(int numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public Enum getGerencia() {
        return gerencia;
    }

    public void setGerencia(Enum gerencia) {
        this.gerencia = gerencia;
    }

    public String getColeccionTrabajadores() {
        return coleccionTrabajadores;
    }

    public void setColeccionTrabjadores(String coleccionTrabajadores) {
        this.coleccionTrabajadores = coleccionTrabajadores;
    }

    @Override
    public String toString() {
        String informacion = "";
        informacion = "Gerente Dep - " + super.toString();
        informacion += " Nombre: " + getNombre();
        informacion += " DNI: " + getDni();
        informacion += " Direccion: " + getDireccion();
        return "GerenteDep" + this.getSalario() + this.getDepartamento() + this.getNumeroSS();
    }

    public static void mostrarInfoDepartamento(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("DNI: " + getDni());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Salario: " + getSalario());
        System.out.println("Departamento: " + getDepartamento());
    }

    private ArrayList<GerenteDep> gerentes;

    public ArrayList<GerenteDep> getGerentes() {
        String informatica = "";
        String gestion = "";
        String marketing = "";
        System.out.println("informatica" + informatica + "gestion" + gestion + "marketing" + marketing);
        return gerentes;
    }
}
