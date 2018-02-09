package pl.zliczacz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Stąd startujemy. Klasa ma za zadanie zebrać dane od użytkownika i odpalić odpowiednie funkcje.
 */
public class Start {
  private static final Gadacz gadacz = new Gadacz();

  public static void main(String[] args) {
    final String op = gadacz.menuStartowe();
    System.out.format("Wybrałeś: %s. ", op);
    switch (op) {
      default: doWidzenia();
      case "1": {
        zliczSłowo();
        break;
      }
      case "2": {
        zliczZnak();
        break;
      }
      case "3": {
        usuńCiąg(gadacz.podajPlik(),gadacz.podajCiąg("do usunięcia"));
        break;
      }
      case "4": {
        zamieńCiąg(gadacz.podajPlik(),gadacz.podajCiąg("do zamiany"), gadacz.podajCiąg("nowy"));
        break;
      }
      case "5": {
        dodajCiąg(gadacz.podajPlik(),gadacz.podajCiąg("do wstawienia"), Integer.parseInt(gadacz.podajGdzieWstawić()));
        break;
      }
      case "6": {
        Sortowacz.rosnąco(new Czytacz(gadacz.podajPlik()));
        break;
      }
      case "7": {
        Sortowacz.malejąco(new Czytacz(gadacz.podajPlik()));
        break;
      }
    }
    //TODO: plik z URLa?
    //TODO: zapis pliku (pod tą lub inną nazwą)
  }

  private static void dodajCiąg(Path ścieżka, String ciąg, Integer pozycja) {
    try {
      List<String> słowa = Files
          .readAllLines(ścieżka, Charset.defaultCharset())
          .stream()
          .flatMap(s-> Arrays.stream(s.split(" ")))
          .collect(Collectors.toList());
      System.out.println("słowa.size() = " + słowa.size());
      słowa.add(pozycja,ciąg);
      słowa.forEach(System.out::print);
    } catch (IOException e) {
      System.err.format("Problem! %s", e.getMessage());
    }
  }

  private static void zamieńCiąg(Path ścieżka, String doUsunięcia, String nowy) {
    try {
      final List<String> linie = Files.readAllLines(ścieżka, Charset.defaultCharset());
      linie.replaceAll(s -> s.replace(doUsunięcia, nowy));
      linie.forEach(System.out::print);
    } catch (IOException e) {
      System.err.format("Problem! %s", e.getMessage());
    }
  }

  private static void usuńCiąg(Path ścieżka, String doUsunięcia) {
    zamieńCiąg(ścieżka, doUsunięcia, "");
  }

  private static void zliczZnak() {
    Zliczacz z = new Zliczacz(gadacz.podajPlik());
    System.out.println(z.zlicz(gadacz.podajZnak().charAt(0)));

  }

  private static void zliczSłowo() {
    Zliczacz z = new Zliczacz(gadacz.podajPlik());
    System.out.println(z.zlicz(gadacz.podajSłowo()));

  }


  private static void doWidzenia() {
    System.out.println("Wybrałeś wyjście. Do widzenia!");
    System.exit(0);
  }

}
