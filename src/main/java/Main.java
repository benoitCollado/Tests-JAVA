// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

  
public class Main {
  public static void main(String[] args) throws IllegalBlocException {
    BufferedReader fluxEntree = new BufferedReader(new InputStreamReader(System.in));
    Kit kitStarter = new Kit();
    
    try{
      System.out.println("Que souhaitez-vous afficher ? 1 - Les idées de constructions. 2 - Le nombre de blocs pour chaque type de blocs présent dans le kit");
      String saisieUtilisateur = fluxEntree.readLine();
      switch(saisieUtilisateur){
        case "1" : 
          kitStarter.afficherKeyWords();
          break;
        case "2" :
          kitStarter.afficherBlocs();
          break;
        default:
          break;
      }
      
    } catch(IOException e){
      
      System.out.println("Erreur lors de la saisie" + e);
    }
    
  char[] listChar = {'a','b','c'};
    System.out.println(fonction(listChar));
 
  }

   public static char fonction(char[] tableau) {
      char valeur = tableau[tableau.length-1];
      return Character.toUpperCase(valeur);
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}