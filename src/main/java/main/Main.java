package main;// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Kit.*;
import main.Exceptions.*;
  
public class Main {
  public static void main(String[] args){
    BufferedReader fluxEntree = new BufferedReader(new InputStreamReader(System.in));
    try{
      
      Kit kitStarter = new Kit();
      
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
    }catch(IllegalBlocException e){
      System.out.println("Erreur lors de la création du kit : " + e.getMessage());
    }catch(IOException e){
      System.out.println("Erreur lors de l'affichage : " + e.getMessage());
    }
 
  }
  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}