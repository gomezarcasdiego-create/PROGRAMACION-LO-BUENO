import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Aldea {
    String nombreAldea;
    int codigo;
    LocalDate FechaCreacion;
    Rango KAGE;
    int maximoEquipos;
    Equipo [] Equipos;

    public Aldea(String nombreAldea, int codigo, LocalDate FechaCreacion, Rango KAGE, int maximoEquipos, String Equipos){

        this.nombreAldea = nombreAldea;
        this.codigo = codigo;
        this.FechaCreacion = FechaCreacion;
        this.KAGE = KAGE;
        this.maximoEquipos = maximoEquipos;
    }
    public String getNombreAldea() {
        return nombreAldea;
    }
    public void setNombreAldea(String nombreAldea) {
        this.nombreAldea = nombreAldea;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(LocalDate FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }
    public Rango getKAGE() {
        return KAGE;
    }
    public void setKAGE(Rango KAGE) {
        this.KAGE = KAGE;
    }
    public int getMaximoEquipos() {
        return maximoEquipos;
    }
    public void setMaximoEquipos(int maximoEquipos) {
        this.maximoEquipos = maximoEquipos;
    }
    public Equipo[] getEquipos() {
        return Equipos;
    }
    public void setEquipos(Equipo[] equipos) {
        Equipos = equipos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aldea{");
        sb.append("nombreAldea=").append(nombreAldea);
        sb.append(", codigo=").append(codigo);
        sb.append(", FechaCreacion=").append(FechaCreacion);
        sb.append(", KAGE=").append(KAGE);
        sb.append(", maximoEquipos=").append(maximoEquipos);
        sb.append(", Equipos=[");
        for (Equipo equipo : Equipos) {}
        return sb.toString();
    }



}
