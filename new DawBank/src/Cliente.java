public class Cliente extends Persona {

    private String telefono;
    private String email;
    private String direccion;

    public Cliente(String telefono, String email, String direccion) {
        super();
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", FechaNacimiento='" + FechaNacimiento + '\'' +
                ", DNI='" + DNI + '\'' +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
