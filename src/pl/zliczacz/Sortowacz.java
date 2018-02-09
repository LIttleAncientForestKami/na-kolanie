package pl.zliczacz;

import java.util.Arrays;

/**
 * Sortuje malejąco lub rosnąco, czytając plik via Czytacz.
 * Wykorzystuje fakt, że znaki można interpretować jako numery.
 * @see Czytacz
 */
public class Sortowacz {

  public static void malejąco(Czytacz czytacz) {
    System.out.println("Malejące sortowanie");
    czytacz.linie
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .flatMap(s -> s.chars().boxed())
        .sorted((o1, o2) -> {
          if (o1 > o2) return -1;
          if (o2 > o1) return 1;
          return 0;
        }).forEach(i -> {
      char znak = (char) i.intValue();
      System.out.print(znak);
    });
  }

  public static void rosnąco(Czytacz czytacz) {
    System.out.println("Rosnące sortowanie");
    czytacz.linie
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .flatMap(s -> s.chars().boxed())
        .sorted().forEach(i -> {
      char znak = (char) i.intValue();
      System.out.print(znak);
    });
  }
}
