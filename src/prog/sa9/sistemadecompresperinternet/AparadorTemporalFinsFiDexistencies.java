package prog.sa9.sistemadecompresperinternet;
public class AparadorTemporalFinsFiDexistencies extends Aparador{
    
    private final long tempsCreacio;
    private static final int MAX_DIES_OBERTS = 3;

    public AparadorTemporalFinsFiDexistencies(String nom, TipusMarca marca) {
        super(nom, marca);
        this.tempsCreacio = System.currentTimeMillis();
    }

    private int obtenirDiesTranscorreguts() {
        long tempsActual = System.currentTimeMillis();
        long tempsTranscorregut = tempsActual - tempsCreacio;
        return (int) (tempsTranscorregut / (1000 * 60 * 60 * 24));
    }

    private boolean hayProductosEnStock() {
        for (StockProducte stockProducte : stock) {
            if (stockProducte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    }

    public void verificarEstat() {
    if (obtenirDiesTranscorreguts() >= MAX_DIES_OBERTS || !hayProductosEnStock()) {
        this.tancarAparador();
        System.out.println("El aparador ha tancat automaticament per temps o falta d'estoc");
    }
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
}
