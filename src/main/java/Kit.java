import java.util.Set;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.ArrayList;

class Kit {
  List<IBloc> blocs;
  Set<String> keyWords;

  Kit() throws IllegalBlocException{
    blocs = new ArrayList<IBloc>();
    keyWords = new LinkedHashSet<String>();
    blocs.add(new Mur(3.0f, 2.0f, 2.0f, true));
    blocs.add(new Mur(3.0f, 2.0f, 2.0f, true));
    blocs.add(new Mur(2.0f, 1.0f, 2.0f, false));
    blocs.add(new Mur(2.0f, 1.0f, 2.0f, false));
    blocs.add(new Porte(1.0f, 2.0f, 2.0f, true));

    keyWords.add("Muraile");
    keyWords.add("Cabane");
  }

  public void addBloc(IBloc bloc){
    blocs.add(bloc);
  }

  public List<IBloc> getBlocs(){
    return blocs;
  }

  public Set<String> getKeyWords(){
    return keyWords;
  }

  public void addKeyWord(String keyWord){
    keyWords.add(keyWord);
  }

  public void afficheKit(){
    System.out.println("Kit : ");
    System.out.println("  Blocs : ");
    System.out.println("    nombrer de blocs : " + blocs.size());
    for(IBloc bloc : blocs){
      bloc.afficheBloc();
    }
    System.out.println("  KeyWords : ");
    for(String keyWord : keyWords){
      System.out.println("    " + keyWord);
    }
  }

  public void afficherBlocs(){
    System.out.println("Kit : ");
    System.out.println("  Blocs : ");
    System.out.println("    nombrer de blocs : " + blocs.size());
    for(IBloc bloc : blocs){
      bloc.afficheBloc();
    }
  }

  public void afficherKeyWords(){
    System.out.println("Kit : ");
    System.out.println("  KeyWords : ");
    for(String keyWord : keyWords){
      System.out.println("    " + keyWord);
    }
  }
  
}