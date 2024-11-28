/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class Bloc implements IBloc{

/*  private static final Logger logger = LogManager.getLogger(Bloc.class);*/
  protected static final Logger logger = Logger.getLogger(Bloc.class.getName());
  protected float longueur;
  protected float largeur;
  protected float hauteur;
  protected Couleur couleur;

  Bloc(final float longueur, final float largeur, final float hauteur) throws IllegalBlocException {
    if(longueur < MIN_LONGUEUR || largeur < MIN_LARGEUR || hauteur < MIN_HAUTEUR) {
      /*logger.error("Les valeurs minimales pour longeur, larger et hauteur n'ont pas été respectées");*/
      logger.log(Level.SEVERE, "Les valeurs minimales pour longeur, larger et hauteur ne sont pas respectées");
      throw new IllegalBlocException();
    }
    this.longueur = longueur;
    this.largeur = largeur;
    this.hauteur = hauteur;
    logger.log(Level.INFO, "Un Bloc de type : " + this.getClass().getName() + " a été créé");
    /*logger.info("Un bloc de type : " + this.getClass().getName() + " a été créé" );  */  
  }

  public float getLongueur(){
    return this.longueur;
  }
  public float getLargeur(){
    return this.largeur;
  }
  public float getHauteur(){
    return this.hauteur;
  }
  public Couleur getCouleur(){
    return this.couleur;
  }
  public void setCouleur(final Couleur couleur){
    this.couleur = couleur;
  }

}