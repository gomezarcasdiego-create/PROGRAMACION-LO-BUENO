public class Coche {

    private String color;
    private String marca;
    String matricula;

    public Coche(String color, String marca, String matricula) {
        this.color = color;
        this.marca = marca;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String matricula() {
        return matricula;
    }
}