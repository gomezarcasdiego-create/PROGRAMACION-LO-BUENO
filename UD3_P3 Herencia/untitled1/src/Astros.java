import com.sun.source.tree.StringTemplateTree;

import java.time.LocalDate;

public abstract class Astros {
    private String MasaCuerpo;
    private String DiametroMedio;
    private LocalDate periododerotacionsobresupropioeje;
    private LocalDate periododetranslacionalrededordelcuerpoqueorbitan;
    private String Distanciamediaaesecuerpo;

    public Astros(String MasaCuerpo, String DiametroMedio, String Distanciamediaaesecuerpo) {
       this.MasaCuerpo = MasaCuerpo;
       this.DiametroMedio = DiametroMedio;
       this.Distanciamediaaesecuerpo = Distanciamediaaesecuerpo;
    }
    public String getMasaCuerpo() {
        return MasaCuerpo;
    }
    public void setMasaCuerpo(String MasaCuerpo) {
        this.MasaCuerpo = MasaCuerpo;
    }

    public String getDiametroMedio() {
        return DiametroMedio;
    }
    public void setDiametroMedio(String DiametroMedio) {
        this.DiametroMedio = DiametroMedio;
    }

    public LocalDate getPeriododerotacionsobresupropioeje() {
        return periododerotacionsobresupropioeje;
    }
    public void setPeriododerotacvionsobresupropioeje(String Periododerotacvionsobresupropioeje) {
        this.DiametroMedio = DiametroMedio;
    }

    public LocalDate getPeriododetranslacionalrededordelcuerpoqueorbitan() {
        return periododetranslacionalrededordelcuerpoqueorbitan;
    }

    public void setPeriododetranslacionalrededordelcuerpoqueorbitan(LocalDate periododetranslacionalrededordelcuerpoqueorbitan) {
        this.periododetranslacionalrededordelcuerpoqueorbitan = periododetranslacionalrededordelcuerpoqueorbitan;
    }

    public String getDistanciamediaaesecuerpo() {
        return Distanciamediaaesecuerpo;
    }
    public void setDistanciamediaaesecuerpo(String Distanciamediaaesecuerpo) {
        this.DiametroMedio = Distanciamediaaesecuerpo;
    }

    public Astros (String MasaCuerpo, String DiametroMedio) {
        this.MasaCuerpo = MasaCuerpo;
        this.DiametroMedio = DiametroMedio;
    }
    @Override
    public String toString(){
        return "Astros [ MasaCuerpo=" + MasaCuerpo + ", DiametroMedio=" + DiametroMedio + "]";
    }

}

