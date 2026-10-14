import java.util.ArrayList;

public class Ruta {
  public static final String SEPARADOR = ", ";
  public static final int MINUTO_POR_OMISION = 0;

  private String codigo;
  private String nombre;
  private double tarifa;

  
  private ArrayList<Parada> misParadas;

  private ArrayList<HorarioSalida> misHorarios;

  public Ruta(String pCodigo, String pNombre, double pTarifa) {
    codigo = pCodigo;
    nombre = pNombre;
    tarifa = pTarifa;
    misParadas = new ArrayList<>();
    misHorarios = new ArrayList<>();
  }

  public void agregarParada(Parada pParada) {
    if (pParada != null && !existeParada(pParada)) {
      misParadas.add(pParada);
    }
  }

  public void registrarSalida(int pHora, int pMinuto) {
    if (pHora >= 0 && pHora <= HorarioSalida.HORA_MAXIMA
        && pMinuto >= 0 && pMinuto <= HorarioSalida.MINUTO_MAXIMO) {
      misHorarios.add(new HorarioSalida(pHora, pMinuto));
    }
  }

  public void registrarSalida(int pHora) {
    registrarSalida(pHora, MINUTO_POR_OMISION);
  }

  public String getNombre() {
    return nombre;
  }

  public double getTarifa() {
    return tarifa;
  }

  public String consultarNombresParadas() {
    String msg = "";
    for (Parada p : misParadas) {
      if (!msg.isEmpty()) {
        msg += SEPARADOR;
      }
      msg += p.getNombre();
    }
    return msg;
  }

  public String consultarHorariosSalida() {
    String msg = "";
    for (HorarioSalida h : misHorarios) {
      if (!msg.isEmpty()) {
        msg += SEPARADOR;
      }
      msg += h.toString();
    }
    return msg;
  }

  private boolean existeParada(Parada pParada) {
    for (Parada p : misParadas) {
      if (p == pParada) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    String msg = "Ruta\n";
    msg += "  Codigo: " + codigo + "\n";
    msg += "  Nombre: " + nombre + "\n";
    msg += "  Tarifa en colones: " + tarifa + "\n";
    msg += "  Paradas: " + consultarNombresParadas() + "\n";
    msg += "  Cantidad de horarios: " + misHorarios.size() + "\n";
    msg += "  Horarios de salida: " + consultarHorariosSalida();
    return msg;
  }
}
