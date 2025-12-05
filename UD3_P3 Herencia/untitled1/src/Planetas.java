import java.util.Scanner;
    public class Planetas {

    private String DisatanciaAlSol;
    private String OrbitaAlSol;
    private String TieneSatelite;

    public Planetas(String DisatanciaAlSol, String OrbitaAlSol, String TieneSatelite) {
        this.DisatanciaAlSol = DisatanciaAlSol;
        this.OrbitaAlSol = OrbitaAlSol;
        this.TieneSatelite = TieneSatelite;
    }

    public String getDisatanciaAlSol() {
        return DisatanciaAlSol;
    }
    public void setDisatanciaAlSol(String DisataciaAlSol) {
        this.DisatanciaAlSol = DisataciaAlSol;
    }

    public String getOrbitaAlSol() {
        return OrbitaAlSol;
    }
    public void setOrbitaAlSol(String OrbitaAlSol) {
        this.OrbitaAlSol = OrbitaAlSol;
    }

    public String getTieneSatelite() {
        return TieneSatelite;
    }
    public void setTieneSatelite(String TieneSatelite) {
        this.TieneSatelite = TieneSatelite;
    }

    public Planetas(String OrbitaAlSol, String DistanciaAlSol) {
        this.OrbitaAlSol = OrbitaAlSol;
        this.DisatanciaAlSol = DistanciaAlSol;
    }

    @Override
    public String toString() {
        return "Planetas [OrbitaAlSol=" + OrbitaAlSol + ", DisatanciaAlSol=" + DisatanciaAlSol + "]";
    }

    public String SistemaSolar(Planetas planetas) {
        Scanner sc = new Scanner(System.in);
        System.out.print("SistemaSolar");
        String SistemaSolar = sc.nextLine();
        sc.close();
        return "Sistema Solar";
    }
}
