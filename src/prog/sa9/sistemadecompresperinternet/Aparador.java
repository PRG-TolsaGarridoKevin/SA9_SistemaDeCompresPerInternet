package prog.sa9.sistemadecompresperinternet;

import java.util.ArrayList;

public abstract class Aparador {

    private static final int LIMITE = 20;

    private boolean aparadorActiu;
    private String nom;
    private TipusMarca marca;
    private ArrayList<StockProducte> stock = new ArrayList<>();

    public Aparador(String nom, TipusMarca marca) {
        this.nom = nom;
        this.marca = marca;
        this.aparadorActiu = true;
    }

    public void obrirAparador() {
        this.aparadorActiu = true;
    }

    public void tancarAparador() {
        this.aparadorActiu = false;
    }

    public void obtindreProductesALaVenta() {
        for (StockProducte Producte : stock) {
            System.out.println(Producte);
        }
    }

    public boolean verSiUnProductoYaExiste(Producte producte) {
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().getId().equals(producte.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean comprobarStockDeProducte(Producte producte) {
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().equals(producte) && Producte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void verProductosEnVentaOrdenadosAlfabeticamente() {
        //obligado usar interfaz Comparable en clase producte
    }
    
    public int obtenerUnidadesDisponibles(Producte producte) {
        for (StockProducte Producte : stock) {
            if (Producte.getProducteRelacionat().equals(producte)) {
                return Producte.getNumeroDeProductesDisponibles();
            }
        }
        return 0;
    }
    
    public static boolean aparadorObert(Aparador aparador) {
        return aparador.aparadorActiu;
    }
    
    public boolean comprarProducte(String idProducte, int quantitat) throws NotExistEnoughItemException {
        if (!this.aparadorActiu) {
            System.out.println("L'aparador esta tancat, no es poden fer compres");
            return false;
        }

        for (StockProducte Producte : stock) {
            Producte producteComprat = Producte.getProducteRelacionat();

            if (producteComprat.getId().equals(idProducte)) {
                if (Producte.getNumeroDeProductesDisponibles() >= quantitat) {
                    Producte.restarNumeroUnitats(quantitat);
                    System.out.println("Compra realitzada: " + quantitat + " unitats del producte " + idProducte);
                    return true;
                } else {
                    throw new NotExistEnoughItemException("No hi ha prou unitats disponibles del producte seleccionat");
                }
            }
        }

        System.out.println("Producte no trobat en el aparador");
        return false;
    }

    public boolean afegirProducte(StockProducte Producte) throws CanNotMergeBrandsException {
        if (stock.size() >= LIMITE) {
            System.out.println("L'aparador ja te el limit de 20 productes diferents");
            return false;
        }

        if (!Producte.getProducteRelacionat().getMarca().equals(this.marca)) {
            throw new CanNotMergeBrandsException("El producte no es de la mateixa marca que l'aparador");
        }
        
        if (verSiUnProductoYaExiste(Producte.getProducteRelacionat())) {
            System.out.println("El producte ja existeix en l'aparador.");
            return false;
        }
        
        
        stock.add(Producte);
        System.out.println("Producte afegit: " + Producte.getProducteRelacionat().getId());
        return true;
    }
}
