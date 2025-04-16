package prog.sa9.sistemadecompresperinternet;
public class AparadorTemporal extends Aparador{
    
    private long tempsCreacio;
    private int duracioEnDies;

    public AparadorTemporal(String nom, TipusMarca marca, int diesDuracio) {
        super(nom, marca);
        this.tempsCreacio = System.currentTimeMillis();
        this.duracioEnDies = diesDuracio;
        this.diesRestantsPerTancar = diesDuracio;
    }

    public int obtenirDiesRestants() {
        long tempsActual = System.currentTimeMillis();
        long tempsTranscorregut = tempsActual - tempsCreacio;
        int diesPassats = (int) (tempsTranscorregut / (1000 * 60 * 60 * 24));
        diesRestantsPerTancar = duracioEnDies - diesPassats;

        return Math.max(diesRestantsPerTancar, 0);
    }

    @Override
    public void obrirAparador() {
        if (obtenirDiesRestants() > 0) {
            super.obrirAparador();
            System.out.println("L'aparador temporal esta obert, dies restants: " + obtenirDiesRestants());
        } else {
            System.out.println("Aquest aparador ha expirat i no es pot tornar a obrir");
        }
    }

    public void verificarSiHaExpiratIActualitzar() {
        if (obtenirDiesRestants() <= 0) {
            tancarAparador();
        }
    }
}
