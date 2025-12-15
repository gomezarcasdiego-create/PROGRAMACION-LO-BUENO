public class Planetas extends Astros {

    private String satelites;

    public Planetas(String nombre, double masa, double diametro,
                   double rotacion, double traslacion,
                   double distancia, String satelites) {

        super(nombre, masa, diametro, rotacion, traslacion, distancia);
        this.satelites = satelites;
    }

    public Planetas(String nombre) {
    }

    @Override
    public void mostrar() {
        System.out.println("PLANETA: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Rotación: " + rotacion);
        System.out.println("Traslación: " + traslacion);
        System.out.println("Distancia al Sol: " + distancia);
        System.out.println("Satélites: " + satelites);
    }

    public String getNombre() {
        return nombre;
    }

    public void insertarSatelite(String nombreSat) {
    }

    public void eliminarSatelite(String nombreSat) {
    }

}
