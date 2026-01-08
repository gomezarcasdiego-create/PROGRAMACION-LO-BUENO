public class Sensei {
    String codSensei;
    double Estrategia;
    double Liderazgo;

    public Sensei(String codSensei, double Estrategia, double Liderazgo){
       this.codSensei = codSensei;
       this.Estrategia = Estrategia;
       this.Liderazgo = Liderazgo;
    }
    public String getCodSensei() {
        return codSensei;
    }

    public void setCodSensei(String codSensei){
        this.codSensei = codSensei;
    }

    public double getEstrategia() {
        return Estrategia;
    }

    public void setEstrategia(double estrategia) {
        this.Estrategia = Estrategia;
    }

    public double getLiderazgo() {
        return Liderazgo;
    }

    public void setLiderazgo(double liderazgo) {
        this.Liderazgo = liderazgo;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sensei{");
        sb.append("codSensei=").append(codSensei);
        sb.append(", Estrategia=").append(Estrategia);
        sb.append(", Liderazgo=").append(Liderazgo);
        sb.append('}');
        return sb.toString();
    }

}
