import java.time.LocalDate;
import java.util.Arrays;

public class Equipo {
    String NombreEquipo;
    int codigo;
    LocalDate fechacreacion;
    int maximoninjas;
    static Ninja [] Ninja;

    public Equipo() {
        this.fechacreacion = LocalDate.now();
        this.maximoninjas = 200;
    }

    public Equipo(String nombre, LocalDate FechaNacimiento, String DNI, String Direccion, String Telefono,
                  Chakra chakra, Rango rango, String Tecnicas, LocalDate fechaAlta, double Ataque, double Defensa) {

        this.NombreEquipo = nombre;
        this.codigo = codigo;
        this.fechacreacion = FechaNacimiento;
        this.maximoninjas = maximoninjas;
        this.Ninja = Ninja;
    }
    public String getNombreEquipo() {
        return NombreEquipo;
    }
    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFechacreacion() {
        return fechacreacion;
    }
    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    public int getMaximoninjas() {
        return maximoninjas;
    }
    public void setMaximoninjas(int maximoninjas) {
        this.maximoninjas = maximoninjas;
    }
    public static Ninja[] getNinjas() {
        Ninja[] Ninjas;
        return Ninja;
    }
    public void setNinjas(String Ninjas) {
        this.Ninja = Ninja;
    }

    public boolean registrarNinja (Ninja ninja) {

        boolean Ninja;
        return Ninja = false;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo{");
        sb.append("NombreEquipo='").append(NombreEquipo).append('\'');
        sb.append(", codigo=").append(codigo);
        sb.append(", fechacreacion=").append(fechacreacion);
        sb.append(", maximoninjas=").append(maximoninjas);
        sb.append(", Ninja=").append(Arrays.toString(Ninja));
            return sb.toString();
    }

}