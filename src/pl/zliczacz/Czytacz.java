package pl.zliczacz;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Czyta plik (po ścieżce) do strumienia Stringów. W konstruktorze może polecieć wyjątek!
 * Wtedy lista będzie (pesymistycznie) pusta lub (nieco lepiej) niepełna.
 */
class Czytacz {
  final Stream<String> linie;

  Czytacz(Path ścieżkaDoPliku) {
    Stream<String> l = Stream.of("");
    try {
      l = Files.lines(ścieżkaDoPliku, Charset.defaultCharset());
    } catch (IOException e) {
      System.err.println("Problem podczas czytania pliku! Będzie niepełna/pusta treść!");
      e.printStackTrace();
    }
    linie = l;
  }

}
