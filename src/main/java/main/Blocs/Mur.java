package Blocs;

import Components.Couleur;
import Exceptions.IllegalBlocException;

public class Mur extends Bloc{

  protected boolean porteur;

  public Mur(final float longueur, final float largeur, final float hauteur,final boolean porteur)throws IllegalBlocException{
    super(longueur, largeur, hauteur);
    this.porteur = porteur;
    this.couleur = Couleur.GRIS;
  }

  public boolean getPorteur(){
    return this.porteur;
  }
  
  @Override
  public void afficheBloc(){
    System.out.println(
      "Mur : " +
      "Longueur : " + super.longueur + ", " +
      "Largeur : " + super.largeur + ", " +
      "Hauteur : " + super.hauteur + ", " +
      "Poteur : " + this.porteur + ", " +
      "Couleur : " + this.couleur
    );
  }

  public boolean isTraversable(){
    return !this.porteur;
  }
}