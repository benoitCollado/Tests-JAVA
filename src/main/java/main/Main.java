package main;
/*
*
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;

/*
* imports necessaires pour les threads 
*/
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/*
*
*/

import main.Blocs.*;
import main.Kit.*;
import main.Exceptions.*;

/*
*Test imports 
*/
  
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

      //kitStarter.afficheKit();
    }catch(IllegalBlocException e){
      System.out.println("Erreur lors de la création du kit : " + e.getMessage());
    }catch(IOException e){
      System.out.println("Erreur lors de l'affichage : " + e.getMessage());
    }

    try{
    Set<IBloc> setBlocs = constructionSetBlocs();
    setBlocs.forEach((bloc)->{
      bloc.afficheBloc();
    });
    }catch(IllegalBlocException e){
      System.out.println("Erreur dans la construction des blocs");
    }
  }

  private static Set<IBloc> constructionSetBlocs() throws IllegalBlocException{
    Set<IBloc> blocs = new LinkedHashSet<IBloc>();
    //platform threads
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    //virtualthreads à partir de java 21
    //ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    
    Callable<IBloc> mur1 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Mur(1.0f, 2.0f, 3.0f,true);};
    Callable<IBloc> mur2 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Mur(3.0f, 4.0f, 5.0f,false);};
    Callable<IBloc> mur3 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Mur(6.0f, 7.0f, 8.0f,false);};
    Callable<IBloc> mur4 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Mur(8.0f, 9.0f, 9.0f,true);};
    Callable<IBloc> porte1 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Porte(1.0f, 2.0f, 3.0f,true);};
    Callable<IBloc> porte2 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Porte(4.0f, 5.0f, 6.0f,false);};
    Callable<IBloc> porte3 = () -> {
      System.out.println("current Thread :" + Thread.currentThread().getId());
      return new Porte(1.0f, 2.0f, 3.0f,false);};

    List<Callable<IBloc>> list = Arrays.asList(mur1, mur2, mur3, mur4, porte1, porte2, porte3);
    try{
      List<Future<IBloc>> resultats = executorService.invokeAll(list);
      resultats.forEach((resultat)->{
        try{
          blocs.add(resultat.get());
        }catch(InterruptedException | ExecutionException e){
          System.out.println("Erreur lors de la création parallèle des Blocs : " + e.getMessage());
        }
      });
    }catch(InterruptedException e){
      System.out.println("Erreur lors de la création parallèle des Blocs : " + e.getMessage());
    }
    
    executorService.shutdown();
    return blocs;
  }
}