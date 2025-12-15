public abstract class Astros {

    protected String nombre;
    protected double masa;
    protected double diametro;
    protected double rotacion;
    protected double traslacion;
    protected double distancia;

    public Astros(String nombre, double masa, double diametro,
                 double rotacion, double traslacion, double distancia) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.rotacion = rotacion;
        this.traslacion = traslacion;
        this.distancia = distancia;
    }

    public Astros() {

    }

    public abstract void mostrar();

    public void mostrarInfo() {
    }

    public abstract class Astro {

        protected String nombre;

        public Astro(String nombre) {
            this.nombre = nombre;
        }

        public Astro(String nombre, double masa, double diametro, double rotacion, double traslacion, double distancia) {
        }


        public String getNombre() {
            return nombre;
        }

        public abstract void mostrar();

        public abstract void mostrarInfo();
    }
}




