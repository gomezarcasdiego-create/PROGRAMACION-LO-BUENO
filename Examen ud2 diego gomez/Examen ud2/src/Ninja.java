import javax.swing.*;
import java.time.LocalDate;

public class Ninja extends Persona{
    Chakra chakra;
    Rango rango;
    int idNinja;
    String TecnicaSecreta;
    LocalDate fechaAlta;
    double Ataque;
    double Defensa;

    public Ninja(String nombre, LocalDate FechaNacimiento, String DNI, String Direccion, String Telefono,
    Chakra chakra, Rango rango, String TecnicaSecreta, LocalDate fechaAlta, double Ataque, double Defensa) {
        super(nombre, FechaNacimiento, DNI, Direccion, Telefono);

        this.chakra = chakra;
        this.rango = rango;
        this.idNinja = idNinja;
        this.TecnicaSecreta= TecnicaSecreta;
        this.fechaAlta = fechaAlta;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
    }

    public Chakra getChakra() {
        return chakra;
    }

    public void setChakra(Chakra chakra) {
        this.chakra = chakra;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public int getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public String getTecnicaSecreta() {
        return TecnicaSecreta;
    }

    public void setTecnicaSecreta(String tecnicaSecreta) {
        this.TecnicaSecreta = tecnicaSecreta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getAtaque() {
        return Ataque;
    }

    public void setAtaque(double ataque) {
        this.Ataque = ataque;
    }

    public double getDefensa() {
        return Defensa;
    }

    public void setDefensa(double defensa) {
        this.Defensa = defensa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ninja{");
        sb.append("chakra=").append(chakra);
        sb.append(", rango=").append(rango);
        sb.append(", idNinja=").append(idNinja);
        sb.append(", TecnicaSecreta=").append(TecnicaSecreta);
        sb.append(", fechaAlta=").append(fechaAlta);
        sb.append(", Ataque=").append(Ataque);
        sb.append(", Defensa=").append(Defensa);
        return sb.toString();
    }
}

