package main.Blocs;

import java.util.logging.Level;
import main.Components.Couleur;
import main.Exceptions.PorteVerouilleException;
import main.Exceptions.IllegalBlocException;

public class Porte extends Bloc{
  protected boolean isLocked;
  public Porte(final float longueur, final float largeur, final float hauteur, final boolean isLocked) throws IllegalBlocException{
    super(longueur, largeur, hauteur);
    this.isLocked = isLocked;
    this.couleur = Couleur.BLEU;
  }

  public void afficheBloc(){
    System.out.println(
      "Porte : " +
      "Longueur : " + super.longueur + ", " +
      "Largeur : " + super.largeur + ", " +
      "Hauteur : " + super.hauteur + ", " +
      "Locked : " + this.isLocked + ", " +
      "Couleur : " + this.couleur
    );
  }

  public boolean isLocked(){
    return this.isLocked;
  }

  public void verouiller() throws PorteVerouilleException{

      if(this.isLocked){
        Bloc.logger.log(Level.SEVERE, "La porte est déjà verouillée vous ne pouvez pas la vérouiller à nouveau");
        throw new PorteVerouilleException();
      }else{
        this.isLocked = true;
      }

  }
}