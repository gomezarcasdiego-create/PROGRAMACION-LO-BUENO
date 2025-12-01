public class videoDaw {

    Clasepelicula[] peliculas = new Clasepelicula[20];
    Clasecliente[] clientes = new Clasecliente[20];

    int contadorPeliculas = 0;
    int contadorClientes = 0;

    public void registrarPelicula(Clasepelicula p) {
        peliculas[contadorPeliculas] = p;
        contadorPeliculas++;
        System.out.println("Película registrada.");
    }

    public void registrarCliente(Clasecliente c) {
        clientes[contadorClientes] = c;
        contadorClientes++;
        System.out.println("Cliente registrado.");
    }

    public void mostrarPeliculas() {
        for (int i = 0; i < contadorPeliculas; i++) {
            peliculas[i].mostrarInfoPelicula();
            System.out.println("---------------------");
        }
    }

    public void mostrarClientes() {
        for (int i = 0; i < contadorClientes; i++) {
            clientes[i].mostrarInfoCliente();
            System.out.println("---------------------");
        }
    }
}
