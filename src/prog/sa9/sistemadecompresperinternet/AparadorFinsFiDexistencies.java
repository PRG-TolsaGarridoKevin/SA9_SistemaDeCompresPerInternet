package prog.sa9.sistemadecompresperinternet;
public class AparadorFinsFiDexistencies extends Aparador {
    
    public AparadorFinsFiDexistencies(String nom, TipusMarca marca) {
        super(nom, marca);
    }
    
    @Override
    public void obrirAparador() {
        if (hayProductosEnStock()) {
            super.obrirAparador();  
            System.out.println("L'aparador s'ha obert");
        } else {
            System.out.println("No hi ha productes en estoc, no es pot obrir l'aparador");
        }
    }

    private boolean hayProductosEnStock() {
        for (StockProducte stockProducte : stock) {
            if (stockProducte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean comprarProducte(String idProducte, int quantitat) throws NotExistEnoughItemException, ShowRoomNotOpenException {
    assert idProducte != null && !idProducte.isEmpty() : "El id del producte no pot ser null";
    assert quantitat > 0 : "La quantitat ha de ser major que zero";

    if (!this.aparadorActiu) {
        throw new ShowRoomNotOpenException("L'aparador està tancat, no es poden fer compres");
    }

    for (StockProducte productes : stock) {
        Producte producteComprat = productes.getProducteRelacionat();

        if (producteComprat.getId().equals(idProducte)) {
            if (productes.getNumeroDeProductesDisponibles() >= quantitat) {
                productes.restarNumeroUnitats(quantitat);
                System.out.println("Compra realitzada: " + quantitat + " unitats del producte " + idProducte);

                if (!hayProductosEnStock()) {
                    this.tancarAparador();
                    System.out.println("Tots els productes estan agotats, el aparador s'ha tancat automaticament.");
                }

                return true;
            } else {
                throw new NotExistEnoughItemException("No hi ha prou unitats disponibles del producte seleccionat");
            }
        }
    }

    return false;
}
    
    @Override
    public void tancarAparador() {
        super.aparadorActiu = false;
        System.out.println("L'aparador s'ha tancat");
    }
}
