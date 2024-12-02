package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.Exceptions.IllegalBlocException;
import main.Blocs.Mur;

class MurTest{
  @Test
  void TestMurCretaion(){
    try{
      Mur mur = new Mur(1.0f, 2.0f, 3.0f, true);
      assertEquals(1.0f, mur.getLongueur());
      assertEquals(2.0f, mur.getLargeur());
      assertEquals(3.0f, mur.getHauteur());
      assertEquals(true, mur.getPorteur());
    }catch(IllegalBlocException e){
      System.out.print(e.getMessage());
    }
  }
  
}