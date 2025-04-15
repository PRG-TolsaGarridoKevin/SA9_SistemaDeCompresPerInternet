package prog.sa9.sistemadecompresperinternet;
public class AparadorTemporal extends Aparador{
    
    public AparadorTemporal(String nom, TipusMarca marca) {
        super(nom, marca);
    }
    
    
    /*Aparador temporal = apartir de la seva creacio esta obert un numero llimitat de dies, es pot vorer els dies que li queden
    (currentTimeMillis clase System) (1 dia = 86400 milisegundos | 1 seg = 1000 milisegundos) */
}
