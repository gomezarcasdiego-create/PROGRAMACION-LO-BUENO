import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class Empresa implements Serializable {

    private TreeMap<String, Trabajador> trabajadores;

    @Serial
    private static final long serialVersionUID = 2885482671575480622L;
    private String nombre;
    private String cif;
    private LocalDate fechaFundacion;
    private String dni;
    private String fechaNacimiento;

    public Empresa(String nombre, String cif, LocalDate fechaFundacion) {
        this.nombre = nombre;
        this.cif = cif;
        this.fechaFundacion = fechaFundacion;
        this.trabajadores = new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public TreeMap<String, Trabajador> getTrabajadores() {
        TreeMap<String, Trabajador> trabajadores = new TreeMap<>();
        for (Trabajador trabajador : this.trabajadores.values()) {
            trabajadores.put(trabajador.getNombre(), trabajador);
            if (trabajadores.containsKey(trabajador.getNombre())) {
                this.getNombre();
                this.getFechaFundacion();
            }
        }
        return trabajadores;
    }

    private ArrayList<Trabajador> trabajadoresRegistrados;
    private ArrayList<GerenteDep> gerentesRegistrados;
    private ArrayList<Director> directoresRegistrados;
    private ArrayList<Trabajador> trabajadoresEliminados;

    public Empresa() {
        this.trabajadoresRegistrados = new ArrayList<Trabajador>();
        this.gerentesRegistrados = new ArrayList<GerenteDep>();
        this.directoresRegistrados = new ArrayList<Director>();
        this.trabajadoresEliminados = new ArrayList<Trabajador>();
    }

    private Trabajador bucarTrabajador(String dni) {
        for (Trabajador t : trabajadoresRegistrados) {
            if (t.getNombre().equals(dni)) {
                return t;
            }
        }
        return null;
    }

    public void registrarTrabajador(Trabajador trabajador) {
        trabajadoresRegistrados.add(trabajador);
    }

    private GerenteDep bucarGerente(String dni) {
        for (GerenteDep g : gerentesRegistrados) {
            if (g.getNombre().equals(dni)) {
                return g;
            }
        }
        return null;
    }

    public void registrarGerenteDep(GerenteDep gerente) {
        gerentesRegistrados.add(gerente);
    }

    private Director bucarDirector(String dni) {
        for (Director d : directoresRegistrados) {
            if (d.getNombre().equals(dni)) {
                return d;
            }
        }
        return null;
    }

    public void registrarDirector(Director director) {
        directoresRegistrados.add(director);
    }

    Trabajador trabajadoresEliminados() {
        for (Trabajador te : trabajadoresEliminados) {
            System.out.println(te.getNombre());
            if (te.getDni().equals(dni)) {
                return te;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "trabajadores=" + trabajadores +
                ", nombre='" + nombre + '\'' +
                ", cif='" + cif + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", trabajadoresRegistrados=" + trabajadoresRegistrados +
                ", gerentesRegistrados=" + gerentesRegistrados +
                ", directoresRegistrados=" + directoresRegistrados +
                ", trabajadoresEliminados=" + trabajadoresEliminados +
                '}';
    }

    public boolean mostrarInfoTrabajadores() {
        System.out.println("infromacion de todos los trabajadores");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("dni: " + this.dni);
        System.out.println("fecha de nacimiento: " + this.fechaNacimiento);
        System.out.println("trabajadores: " + this.trabajadoresRegistrados);
        System.out.println("gerentes: " + this.gerentesRegistrados);
        System.out.println("directores: " + this.directoresRegistrados);
        return false;
    }
}