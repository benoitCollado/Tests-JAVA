// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;


  
public class Main {
  public static void main(String[] args) {
    try{
      Kit kitStarter = new Kit();
       kitStarter.afficheKit();
      kitStarter.addBloc(new Mur(1.0f, 2.0f, 6.0f, true));
      for(IBloc bloc : kitStarter.getBlocs()){
        if(bloc instanceof Porte){
         ((Porte)bloc).verouiller();
        }
      }
    }catch(Exception e){
      if(e instanceof IllegalBlocException){
        System.out.println("Valeurs pour contruire le bloc invalides");
      }else if(e instanceof PorteVerouilleException){
        System.out.println("La porte est déjà verouillée");
      }
    
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