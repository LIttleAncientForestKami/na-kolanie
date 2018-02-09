package pl.zliczacz;

import java.nio.file.Path;
import java.util.Arrays;

/**
 * Zlicza znaki lub słowa. Polega na czytaczu plików.
 * @see Czytacz
 */
public class Zliczacz {
  private final Path path;
  private final Czytacz czytacz;

  public Zliczacz(Path path) {
    this.path = path;
    this.czytacz = new Czytacz(path);
  }

  long zlicz(String słowo) {
    return czytacz.linie.flatMap(s -> Arrays.stream(s.split(" ")))
        .filter(s -> s.equalsIgnoreCase(słowo))
        .count();
  }

  long zlicz(char znak) {
    System.out.format("Znak %c... wystąpień: ", znak);
    final int znakNumerycznie = (int) znak;
    return czytacz.linie
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .flatMap(s -> s.chars().boxed())
        .filter(c -> c == znakNumerycznie)
        .count();
  }
}
