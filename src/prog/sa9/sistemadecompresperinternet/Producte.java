package prog.sa9.sistemadecompresperinternet;

import java.util.Objects;

public class Producte {
    private String id;
    private double preu;
    private TipusMarca marca;
    private StockProducte stockProducte;

    public Producte(String id, double preu, TipusMarca marca, StockProducte stockProducte) {
        this.id = id;
        this.preu = preu;
        this.marca = marca;
        this.stockProducte = stockProducte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producte other = (Producte) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte amb id: "+id+", Preu: "+preu+", Marca: "+ marca+", Unitats: "+ stockProducte.getNumeroDeProductesDisponibles()+"\n";
    }

    
    
}
