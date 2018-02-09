package pl.zliczacz;

/**
 * Humorystyczna klasa, mimo niestandardowej nazwy to wyjątek (z typu sprawdzanych, ang. checked).
 * Rzucana przy: braku szukanego słowa w podanym pliku.
 */
public class NieMaTakiegoNumeru extends Exception {
  public NieMaTakiegoNumeru(String s) {
    super(s);
  }
}
