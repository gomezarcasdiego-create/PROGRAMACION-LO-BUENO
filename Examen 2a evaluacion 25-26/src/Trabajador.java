import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Trabajador extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = -19119846374684374L;
    private int numeroSS;
    private String emailEmpresa;
    private static int salario;
    public static Enum departamento;

    public Trabajador(String nombre, LocalDate fechaDeNacimiento, String dni, String direccion, int numeroSS, String emailEmpresa,
                      int salario, Enum departamento) {
        super(nombre, fechaDeNacimiento, dni, direccion);
        this.numeroSS = numeroSS;
        this.emailEmpresa = emailEmpresa;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(int numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public static int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public static Enum getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Enum departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        String mostrar = "";
        mostrar += "numeroSS: " + numeroSS + "\n";
        mostrar += "emailEmpresa: " + emailEmpresa + "\n";
        mostrar += "salario: " + salario + "\n";
        mostrar += "departamento: " + departamento + "\n";
        return "info persona" + this.getNombre() + this.getDni() + this.getDireccion();
    }

    public void validarNumeroSS(String numeroSS) {
        do{
        if (numeroSS.length() != 10) {
            return;
        }
    }while (!numeroSS.matches("[10]+"));
    }

    private ArrayList<GerenteDep> trabajadores;

    public ArrayList<GerenteDep> getTrabajadores() {
        String informatica = "";
        String gestion = "";
        String marketing = "";
        String direccion = "";
        System.out.println("informatica" + informatica + "gestion" + gestion + "marketing" + marketing + "direccion" + direccion);
        return trabajadores;
    }
}

