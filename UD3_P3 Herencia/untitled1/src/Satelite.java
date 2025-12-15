public class Satelite extends Astros {

    private String planeta;

    public Satelite(String nombre, double masa, double diametro,
                    double rotacion, double traslacion,
                    double distancia, String planeta) {

        super(nombre, masa, diametro, rotacion, traslacion, distancia);
        this.planeta = planeta;
    }

    public Satelite(String nombre) {
        super();
    }

    public Satelite(String luna, double v, int i, int i1, int i2, int i3) {
    }

    @Override
    public void mostrar() {
        System.out.println("SATÉLITE: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Rotación: " + rotacion);
        System.out.println("Traslación: " + traslacion);
        System.out.println("Distancia al planeta: " + distancia);
        System.out.println("Planeta: " + planeta);
    }

    public String getNombre() {
        return "";
    }
}
