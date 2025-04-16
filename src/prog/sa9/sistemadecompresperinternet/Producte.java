package prog.sa9.sistemadecompresperinternet;

import java.util.Objects;

public class Producte implements Comparable<Producte> {
    private String id;
    private double preu;
    private TipusMarca marca;
    private StockProducte stockProducte;  // Añadido para almacenar el stock del producto

    public Producte(String id, double preu, TipusMarca marca) {
        this.id = id;
        this.preu = preu;
        this.marca = marca;
        this.stockProducte = null;  // Inicialmente no tiene stock
    }

    // Método para asociar un stock con el producto
    public void setStockProducte(StockProducte stockProducte) {
        this.stockProducte = stockProducte;
    }

    public int getStockProducte() {
        // Comprobamos si el stock es nulo. Si no lo es, devolvemos las unidades.
        if (this.stockProducte != null) {
            return this.stockProducte.getNumeroDeProductesDisponibles();
        }
        return 0;  // Si el producto no tiene stock, devolvemos 0
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
        // Usamos el método getStockProducte para obtener las unidades
        return "Producte amb id: " + id + ", Preu: " + preu + ", Marca: " + marca + ", Unitats: " + getStockProducte();
    }
}
