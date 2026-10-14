import java.util.Locale;

public class HorarioSalida {
  public static final int HORA_MAXIMA = 23;
  public static final int MINUTO_MAXIMO = 59;

  private int hora;
  private int minuto;
  public HorarioSalida(int pHora, int pMinuto) {
    hora = pHora;
    minuto = pMinuto;
  }

  @Override
  public String toString() {
    return String.format(Locale.ROOT, "%02d:%02d", hora, minuto);
  }
}
