import java.util.Scanner;

public class Clasecliente {
    public class Numsocio {
    }

    private String DNI;
    private String nombre;
    private String NumSocio;
    private String direccion;
    private int fechanacimiento;
    private int fechabaja;
    private String peliculasalquiladas;

    private Numsocio[] Numsocios;
    private final peliculasalquiladas [] pelulasalquiladas;


    public Clasecliente(String DNI, String nombre, String direccion, String peliculasalquiladas) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peliculasalquiladas = peliculasalquiladas;
    }
}
