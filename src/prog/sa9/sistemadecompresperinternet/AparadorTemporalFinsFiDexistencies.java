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

    private boolean quedaStock() {
        for (StockProducte Producte : getStock()) {
            if (Producte.getNumeroDeProductesDisponibles() > 0) {
                return true;
            }
        }
        return false;
    }

    public void verificarEstat() {
        if (obtenirDiesTranscorreguts() >= MAX_DIES_OBERTS || !quedaStock()) {
            this.tancarAparador();
        }
    }

    @Override
    public boolean comprarProducte(String idProducte, int quantitat) throws NotExistEnoughItemException, ShowRoomNotOpenException {
        verificarEstat();

        if (!isAparadorActiu()) {
            throw new ShowRoomNotOpenException("No es pot comprar, l'aparador esta tancat");
        }

        return super.comprarProducte(idProducte, quantitat);
    }
}
