package pl.zliczacz;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Gada z użytkownikiem. Polega na skanerze, którego nie zamyka, bo jest otwarty na System.in.
 */
public class Gadacz {
  Scanner s = new Scanner(System.in);

  String menuStartowe() {
    StringBuilder menu = new StringBuilder("Witaj w aplikacji na ocenę 3!");
    menu.append(" Wybierz:").append(System.lineSeparator())
        .append("\t1. zliczenie wystąpień danego słowa ").append(System.lineSeparator())
        .append("\t2. zliczenie wystąpień danego znaku ").append(System.lineSeparator())
        .append("\t3. usunięcie wybranego ciągu znaków ").append(System.lineSeparator())
        .append("\t4. zamianę wybranego ciągu znaków na inny").append(System.lineSeparator())
        .append("\t5. dodanie we wskazanym miejscu danego ciągu znaków ").append(System.lineSeparator())
        .append("\t6. posortowanie pliku rosnąco względem znaków w nim występujących ").append(System.lineSeparator())
        .append("\t7. posortowanie pliku malejąco względem znaków w nim występujących ").append(System.lineSeparator())
        .append("Twój wybór? (1-7 operacje, cokolwiek innego - wyjście: ");
    System.out.print(menu.toString());
    return s.nextLine();
  }

  Path podajPlik() {
    System.out.println("Podaj ścieżkę do pliku na dysku albo URL? (na razie URL nie działa, zatem ścieżkę)");
    String p = s.nextLine().trim();
//    if (p.startsWith("http://") || p.startsWith("https://") || p.startsWith("ftp://")) {
//      // new Scanner(new URL(p).openStream(), "UTF-8").useDelimiter("\\A").next(); // returns file as a string, not as a stream
//    }
    return Paths.get(p);
  }

  String podajSłowo() {
    System.out.println("Podaj słowo, jakiego wystąpienia mam zliczyć? ");
    return s.nextLine();
  }

  public String podajZnak() {
    System.out.println("Podaj znak, jakiego wystąpienia mam zliczyć? ");
    return s.nextLine();
  }

  public String podajCiąg(String jaki) {
    System.out.format("Podaj ciąg (%s)? ", jaki);
    return s.nextLine();
  }

  public String podajGdzieWstawić() {
    System.out.format("Podaj pozycję (numer słowa), po którym ciąg ma być wstawiony?");
    return s.nextLine();
  }

}
