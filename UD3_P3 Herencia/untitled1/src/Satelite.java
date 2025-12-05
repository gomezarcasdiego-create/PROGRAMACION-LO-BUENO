import java.util.Scanner;

public class Satelite {
    private String DistanciaAlPlaneta;
    private String OrbitaPlanetaria;
    private String PlanetaAlQuePertenece;

    public Satelite (String DistaciaAlPlaneta, String OrbitaPlanetaria, String PlanetaAlQuePertenece) {
        this.DistanciaAlPlaneta = DistaciaAlPlaneta;
        this.OrbitaPlanetaria = OrbitaPlanetaria;
        this.PlanetaAlQuePertenece = PlanetaAlQuePertenece;
    }
    public String getDistanciaAlPlaneta() {
        return DistanciaAlPlaneta;
    }
    public void setDistanciaAlPlaneta(String DistanciaAlPlaneta) {
        this.DistanciaAlPlaneta = DistanciaAlPlaneta;
    }

    public String getOrbitaPlanetaria() {
        return OrbitaPlanetaria;
    }
    public void setOrbitaPlanetaria(String OrbitaPlanetaria) {
        this.OrbitaPlanetaria = OrbitaPlanetaria;
    }

    public String getPlanetaAlQuePertenece() {
        return PlanetaAlQuePertenece;
    }
    public void setPlanetaAlQuePertenece(String PlanetaAlQuePertenece) {
        this.PlanetaAlQuePertenece = PlanetaAlQuePertenece;
    }

    public Satelite(String DistanciaAlPlaneta, String OrbitaPlanetaria) {
        this.DistanciaAlPlaneta = DistanciaAlPlaneta;
        this.OrbitaPlanetaria = OrbitaPlanetaria;
    }
    @Override
    public String toString() {
        return "Satelite [ DistanciaAlPlaneta=" + DistanciaAlPlaneta + ", OrbitaPlanetaria=" + OrbitaPlanetaria + "]";
    }

    public String SistemaSolar(Satelite satelite) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sistema Solar");
        String SistemaSolar = sc.nextLine();
        sc.close();
        return "Sistema Solar";
    }
}