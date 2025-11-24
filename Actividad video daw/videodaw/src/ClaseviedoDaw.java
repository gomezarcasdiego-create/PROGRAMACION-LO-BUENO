import java.time.LocalDate;
import java.util.ArrayList;

public class ClaseviedoDaw {

    private String CIF;
    private String direccion;
    LocalDate fechaAlta;
    private String PeliculasRegistradas;
    private String ClientesRegistrados;

    public void videoDaw(String CIF, String direccion) {

        this.CIF = CIF;
            this.direccion = direccion;
            this.PeliculasRegistradas = PeliculasRegistradas;
            this.ClientesRegistrados = ClientesRegistrados;
    }



    public String getCIF() {
        return CIF;
    }
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getPeliculasRegistradas() {
        return PeliculasRegistradas;
    }
    public void setPeliculasRegistradas(String PeliculasRegistradas) {
        this.PeliculasRegistradas = PeliculasRegistradas;
    }
    public String getClientesRegistrados() {
        return ClientesRegistrados;
    }
    public void setClientesRegistrados(String ClientesRegistrados) {
        this.ClientesRegistrados = ClientesRegistrados;
    }

    public void mostrarInfoVideoClub (){
        System.out.println("CIF: " + this.CIF);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Fecha Alta: " + this.fechaAlta);
    }

    public void mostrarPeliculasRegistradas(){
        System.out.println("PeliculasRegistradas: " + this.PeliculasRegistradas);
    }

    public void mostrarClientesRegistradas(){
        System.out.println("ClientesRegistradas: " + this.ClientesRegistrados);
    }

    public void alquilarPelicula(){
        class Pelicula {
            private String titulo;
            private boolean alquilada;

            public Pelicula(String titulo) {
                this.titulo = titulo;
                this.alquilada = false;
            }

            public boolean isAlquilada() {
                return alquilada;
            }

            public void setAlquilada(boolean alquilada) {
                this.alquilada = alquilada;
            }

            public String getTitulo() {
                return titulo;
            }
        }

        class Cliente {
            private String nombre;
            private ArrayList<Pelicula> peliculasAlquiladas;

            public Cliente(String nombre) {
                this.nombre = nombre;
                this.peliculasAlquiladas = new ArrayList<>();
            }

            public void agregarPeliculaAlquilada(Pelicula p) {
                peliculasAlquiladas.add(p);
            }

            public ArrayList<Pelicula> getPeliculasAlquiladas() {
                return peliculasAlquiladas;
            }
        }
    }

}
