public class Libro {

    //Atributos o campos de la clase (encapsulacion)
    private String titulo;
    private String autor;
    private int nPaginas;
    private String ISBN;
    private String editora;
    private String fechaPublicacion;
    private int edicion;

    //constructor / Constructores
    //constructor con atributos imprescindibles
    public Libro(String titulo,  String autor, String ISBN, String fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = 1;
        this.nPaginas = 1;
        this.editora = "Auto-publicacion";
    }

    //constructor con todos los atributos
    public Libro(String titulo,  String autor, String ISBN, String fechaPublicacion,
                 String editora, int edicion, int nPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
        this.setNpaginas(nPaginas);
        this.editora = editora;
        }
        /*
            DEFINIMOS LOS GETTER Y SETTER DE LOS ATIBUTOS
        */

        public String getTitulo(){
         return this.titulo;
        }
        public String getAutor(){
            return this.autor;
        }
        public String getISBN(){
            return this.ISBN;
        }
        public String getFechaPublicacion(){
            return this.fechaPublicacion;
        }

        public int getEdicion(){
            return this.edicion;
        }

        public int getNpaginas(){
            return this.nPaginas;
        }

        public void setNpaginas(int Npaginas){
          if(Npaginas > 0){
              this.nPaginas = Npaginas;
          }
        }

        public String getEditora(){
            return this.editora;
        }

        public void setEditora(String editora){
            this.editora = editora;
        }

        //Metodos

    /**
     * Metodo: mostrar informacion del libro;
     */
    public String infoLibro(){
        String infoLibro = "";
        infoLibro += "Titulo: " + this.titulo + "\n";
        infoLibro += "Autor: " + this.autor + "\n";
        infoLibro += "ISBN: " + this.ISBN + "\n";
        infoLibro += "Fecha de publicacion: " + this.fechaPublicacion + "\n";
        infoLibro += "Editora: " + this.editora + "\n";
        infoLibro += "Edicion: " + this.edicion + "\n";
        infoLibro += "NPaginas: " + this.nPaginas + "\n";

        //
        String info = String.format("Libro - Titulo : %s, Autor: %s , Fecha publicacion: %s, Numero de paginas: %s, Edicion: %s, Editorial: %s, ISBN: %s ");
            , this.titulo, this.autor, this.ISBN, this.fechaPublicacion, this.nPaginas);

        return infoLibro;
    }
}
