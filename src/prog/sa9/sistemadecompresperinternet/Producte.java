package prog.sa9.sistemadecompresperinternet;

import java.util.Objects;

public class Producte implements Comparable<Producte> {
    private String id;
    private double preu;
    private TipusMarca marca;
    private StockProducte stockProducte;  

    public Producte(String id, double preu, TipusMarca marca) {
        this.id = id;
        this.preu = preu;
        this.marca = marca;
        this.stockProducte = null;  
    }

    public void setStockProducte(StockProducte stockProducte) {
        this.stockProducte = stockProducte;
    }

    public int getStockProducte() {
        
        if (this.stockProducte != null) {
            return this.stockProducte.getNumeroDeProductesDisponibles();
        }
        return 0; 
    }

    @Override
    public int compareTo(Producte producte) {
        return this.id.compareTo(producte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producte producte = (Producte) obj;
        return id.equals(producte.id);
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getId() {
        return id;
    }

    public TipusMarca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
      
        return "Producte amb id: " + id + ", Preu: " + preu + ", Marca: " + marca + ", Unitats: " + getStockProducte();
    }
}
