import java.util.Scanner;

public class pozdorwieniazjava {
  public static void main(String[] args) {
  
    // Wystarczy wpisać po prostu System.in w nawiasie
    Scanner scanner = new Scanner(System.in);
  
    System.out.println("Wprowadź @Strimer/@czaty: ");
  
    String komenda = scanner.nextLine();
    
    switch (komenda) {
      case "@Strimer":
        System.out.println("Zjedz coś i się ubierz, bo się przeziębisz!");
        break;
      case "@czaty":
        System.out.println("Pozdrawiam i życzę błogosławionego popołudnia! dansi");
        break;
      default:
        System.out.println("Aha");
        break;
    }
    
    scanner.close();
  }
}

