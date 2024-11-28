package main;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import main.Blocs.*;
import main.Exceptions.*;
public class Test{
  public static void implémentations() throws IllegalBlocException{
    Bloc mur = new Mur(1.0f, 2.0f, 3.0f, true);
    mur.afficheBloc();
    Mur mur2 = new Mur(4.0f, 5.0f, 6.0f, true);
    mur2.afficheBloc();
    System.out.println(mur2.isTraversable());
    Bloc porte1 = new Porte(1.0f, 2.0f, 3.0f, false);
    porte1.afficheBloc();

    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);

    for (Integer valeur : list){
      System.out.println(valeur);
    }
    System.out.println("   ");
    list.remove(Integer.valueOf(2));

    for (int valeur : list){
      System.out.println(valeur);
    }

    Set<Integer> list2 = new LinkedHashSet<Integer>();
    list2.add(1);
    list2.add(2);
    list2.add(1);

    System.out.println("   ");

    for(Integer value : list2){
      System.out.println(value);
    }

    if(list2.contains(1)){
      list2.remove(Integer.valueOf(1));
    }
    System.out.println("   ");

    for(Integer value : list2){
      System.out.println(value);
    }

    System.out.println("   ");

    Map<Bloc, Integer> collection = new HashMap<Bloc, Integer>();
    collection.put(new Mur(1.0f, 2.0f, 3.0f, true), 1);
    collection.put(new Mur(4.0f, 5.0f, 6.0f, false), 2);
    collection.put(new Porte(1.0f, 2.0f, 3.0f, false), 3);
    collection.put(new Porte(4.0f, 5.0f, 6.0f, true),4);

    Set<Bloc> keys = collection.keySet();
    for(Bloc key : keys){
      Integer value = collection.get(key);
      System.out.println(/*key.getClass().getName()*/key + " : " + value);
    }

    System.out.println("  ");

  }
}