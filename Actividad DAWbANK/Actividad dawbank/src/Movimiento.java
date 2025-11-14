import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private static int contadorTotal = 0;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private int ID;
    private String Fecha;
    private String Tipo;
    private double Cantidad;

    public Movimiento(String Tipo, double Cantidad) {
        this.Tipo = Tipo;
        this.Cantidad = Cantidad;

        this.contadorTotal++;
        this.ID = contadorTotal;

        this.Fecha = LocalDateTime.now().format(dtf);


    }

    public int getID() {
        return ID;
    }
    public String getFecha() {
        return Fecha;
    }
    public String getTipo() {
        return Tipo;
    }
    public double getCantidad() {
        return Cantidad;
    }

    public void Movimiento(){
        System.out.println("Movimiento ID: " + ID);
        System.out.println("Fecha: " + Fecha);
        System.out.println("Tipo: " + Tipo);
        System.out.println("Cantidad: " + Cantidad + "€");
    }
}
