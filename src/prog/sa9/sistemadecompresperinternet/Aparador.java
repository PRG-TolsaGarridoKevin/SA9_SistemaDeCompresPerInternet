package prog.sa9.sistemadecompresperinternet;

import java.util.ArrayList;

public abstract class Aparador {

    private static final int LIMITE = 20;

    protected boolean aparadorActiu;
    protected int diesRestantsPerTancar;
    private String nom;
    private TipusMarca marca;
    protected ArrayList<StockProducte> stock = new ArrayList<>();

    public Aparador(String nom, TipusMarca marca) {
        assert nom != null && !nom.isEmpty() : "El nom no pot ser null";
        assert marca != null : "La marca no pot ser null";
        
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
        assert stock != null : "El stock no pot ser null";
        for (StockProducte productes : stock) {
            System.out.println(productes.getProducteRelacionat());
        }
    }

    public boolean verSiUnProductoYaExiste(Producte producte) {
        assert producte != null : "El producte no pot ser null";
        for (StockProducte productes : stock) {
            if (productes.getProducteRelacionat().getId().equals(producte.getId())) {
                return true;
            }
        }
        return false;
    }

    public int comprobarStockDeProducte(Producte producte) {
    assert producte != null : "El producte no pot ser null";
    
    for (StockProducte productes : stock) {
        if (productes.getProducteRelacionat().equals(producte)) {
            return productes.getNumeroDeProductesDisponibles();
        }
    }
    return 0;
    }

    public void verProductosEnVentaOrdenadosAlfabeticamente() {
        ArrayList<Producte> producte = new ArrayList<>();
        for (StockProducte productes : stock) {
            producte.add(productes.getProducteRelacionat());
        }
        assert producte.stream().allMatch(p -> p != null) : "Hi ha productes nulls en la llista";
        producte.sort(null);
        for (Producte productes : producte) {
            System.out.println(productes);
        }
    }

    public int obtenerUnidadesDisponibles(Producte producte) {
        assert producte != null : "El producte no pot ser null";
        for (StockProducte productes : stock) {
            if (productes.getProducteRelacionat().equals(producte)) {
                return productes.getNumeroDeProductesDisponibles();
            }
        }
        return 0;
    }

    public static boolean aparadorObert(Aparador aparador) {
        assert aparador != null : "El aparador no pot ser null";
        return aparador.aparadorActiu;
    }

    public boolean comprarProducte(String idProducte, int quantitat) throws NotExistEnoughItemException, ShowRoomNotOpenException {
        assert idProducte != null && !idProducte.isEmpty() : "El id del producte no pot ser null";
        assert quantitat > 0 : "La quantitat ha de ser major que zero";
        
        if (!this.aparadorActiu) {
            System.out.println("L'aparador esta tancat, no es poden fer compres");
            return false;
        }

        for (StockProducte productes : stock) {
            Producte producteComprat = productes.getProducteRelacionat();

            if (producteComprat.getId().equals(idProducte)) {
                if (productes.getNumeroDeProductesDisponibles() >= quantitat) {
                    productes.restarNumeroUnitats(quantitat);
                    System.out.println("Compra realitzada: " + quantitat + " unitats del producte " + idProducte);
                    return true;
                } else {
                    throw new NotExistEnoughItemException("No hi ha prou unitats disponibles del producte seleccionat");
                }
            }
        }

        System.out.println("Producte no trobat en l'aparador");
        return false;
    }

    public boolean afegirProducte(StockProducte stockProducte) throws CanNotMergeBrandsException {
        assert stockProducte != null : "El producte a afegir no pot ser null";

        if (stock.size() >= LIMITE) {
            System.out.println("L'aparador ja te el límit de 20 productes diferents");
            return false;
        }

        Producte producte = stockProducte.getProducteRelacionat();

        if (!producte.getMarca().equals(this.marca)) {
            throw new CanNotMergeBrandsException("El producte no és de la mateixa marca que l'aparador");
        }

        if (verSiUnProductoYaExiste(producte)) {
            System.out.println("El producte ja existeix en l'aparador.");
            return false;
        }

        stock.add(stockProducte);
        System.out.println("Producte afegit: " + producte.getId());
        return true;
    }

    protected ArrayList<StockProducte> getStock() {
        return stock;
    }

    protected boolean isAparadorActiu() {
        return aparadorActiu;
    }
}