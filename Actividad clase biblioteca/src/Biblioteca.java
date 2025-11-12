public class Biblioteca {

    //Atributos encapsulados
    private String codigo;
    private String nombre;
    private String direccion;
    private String email;
    private String nTelefono;

    //Coleccion (array) de libros en la biblioteca
    private Libro[] libros;
    private int nLibrosActuales;
    private final int dimensionInicial = 100;

    //Constructor
    public Biblioteca(String codigo, String nombre, String direccion, String email, String nTelefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.nTelefono = nTelefono;

        this.libros = new Libro[this.dimensionInicial];

        //Esto es importante para la smartbiblioteca
        this.nLibrosActuales = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNTelefono() {
        return this.nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public boolean insertLibro(Libro libro) {
        boolean resultado = false;

        //Toda la logica para insertar un libro
        if (libro != null) {
            //Tengo huecos suficientes
            if (this.nLibrosActuales < this.libros.length) {
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;
            } else {
                //No tengo huecos suficientes
                this.AmpliarDimensionBiblioteca();
                this.libros[this.nLibrosActuales] = libro;
                resultado = true;
                this.nLibrosActuales++;

            }

//            //Algoritmo refactorizado o refinado
//            if(this.nLibrosActuales >= this.libros.length) {
//                this.ampliarDimensionBiblioteca();
//            }
//            this.libros[this.nLibrosActuales] = libro;
//            resultado = true;
//            this.nLibrosActuales++;
        }

        return resultado;
    }

    public boolean eliminarLibro(Libro libro) {
        boolean resultado = false;

        if (libro != null) {
            int index = -1;
            for (int i = 0; i < this.nLibrosActuales; i++) {
                if (this.libros[i] != null) {
                    if (this.libros[i].getISBN().equals(libro.getISBN())) {
                        index = i;
                        break; //para eliminar la primera ocurrencia
                    }
                }

                if (index != -1) {
                    this.libros[index] = null;
                    resultado = true;

                    //Opcion 1 (MARCO): mover solo el último
                    this.libros[index] = this.libros[nLibrosActuales - 1];
                    this.libros[nLibrosActuales - 1] = null;
                    this.nLibrosActuales--;

//                    //Opcion 2: recoloco todo el array
//                    for(int i = index +1; i < this.libros.length; i++){
//                        this.libros[i-1] = this.libros[i];
//                    }
//                    this.libros[this.libros.length-1] = null;
                    this.nLibrosActuales--;
//                }
                }
            }


            return resultado;
        }

        public boolean eliminarlibri (Libro libro){...}

        public String infoBiblioteca() {
            String infoBiblioteca = String.format("Biblioteca - nombre: %s, direccion :%s, Email :%s, numero telefono :%s,"
                    , this.nombre, this.direccion, this.email, this.nTelefono);

            StringBuilder sb = new StringBuilder();
            sb.append("nombre: " + this.nombre + "\n");
            sb.append("direccion: " + this.direccion + "\n");
            sb.append("Email: " + this.email + "\n");
            sb.append("numero telefono: " + this.nTelefono + "\n");

            return sb.toString();
            //return infoBiblioteca
        }

        public String infoLibros() {
            String infoLibro = "No hay libros en la biblioteca";
            if (this.nLibrosActuales > 0) {
                for (int i = 0; i < this.nLibrosActuales; i++) {
                    if (this.libros[i] != null) {
                        infoLibro += this.libros[i];
                    }
                }
            } else {
                infoLibro = "No hay libros en la biblioteca";
            }

            return infoLibro;
        }



//        private void ampliarDimensionBiblioteca () {
//            Libro[] librosAux = new Libro[this.libros.length + 5];
//            for (int i = 0; i < this.libros.length; i++) {
//                librosAux[i] = this.libros[i];
//            }
//            this.libros = librosAux;
//
//
//        }

    }
}