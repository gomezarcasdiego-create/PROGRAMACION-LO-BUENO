public class Persona {

    String Nombre;
    String DNI;
    String FechaNacimiento;

    public Persona(String nombre, String DNI, String fechaNacimiento) {
        Nombre = nombre;
        this.DNI = DNI;
        FechaNacimiento = fechaNacimiento;
    }

    public Persona() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "FechaNacimiento='" + FechaNacimiento + '\'' +
                ", DNI='" + DNI + '\'' +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
