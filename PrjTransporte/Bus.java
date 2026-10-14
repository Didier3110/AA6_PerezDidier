public class Bus {
  public static final String PREFIJO_CODIGO = "BUS-";
  public static final String TEXTO_SIN_RUTA = "(sin ruta asignada)";
  public static final double DESCUENTO_ESTUDIANTE = 0.5;
  public static final double DESCUENTO_CIUDADANO_ORO = 1.0;

  private static int cantidadBuses;

  private String codigo;
  private String placa;
  private int capacidad;
  private double totalRecaudado;
  private int cantidadPersonasAtendidas;
  private Ruta miRuta;

  public Bus(String pPlaca, int pCapacidad) {
    cantidadBuses++;
    codigo = PREFIJO_CODIGO + cantidadBuses;
    placa = pPlaca;
    capacidad = pCapacidad;
    totalRecaudado = 0;
    cantidadPersonasAtendidas = 0;
    miRuta = null;
  }

  public void asignarRuta(Ruta pRuta) {
    miRuta = pRuta;
  }

  public void cobrarPasaje(Persona pPersona) {
    if (miRuta != null && pPersona != null) {
      totalRecaudado += calcularMonto(pPersona);
      cantidadPersonasAtendidas++;
    }
  }

  public String consultarNombreRuta() {
    if (miRuta == null) {
      return TEXTO_SIN_RUTA;
    }
    return miRuta.getNombre();
  }

  public String getCodigo() {
    return codigo;
  }

  public static int getCantidadBuses() {
    return cantidadBuses;
  }

  private double calcularMonto(Persona pPersona) {
    double tarifa = miRuta.getTarifa();
    String condicion = pPersona.getCondicion();

    if (Persona.CONDICION_ESTUDIANTE.equals(condicion)) {
      return tarifa - tarifa * DESCUENTO_ESTUDIANTE;
    }
    if (Persona.CONDICION_CIUDADANO_ORO.equals(condicion)) {
      return tarifa - tarifa * DESCUENTO_CIUDADANO_ORO;
    }
    return tarifa;
  }

  @Override
  public String toString() {
    String msg = "Bus\n";
    msg += "  Codigo: " + codigo + "\n";
    msg += "  Placa: " + placa + "\n";
    msg += "  Capacidad: " + capacidad + "\n";
    msg += "  Ruta asignada: " + consultarNombreRuta() + "\n";
    msg += "  Personas atendidas: " + cantidadPersonasAtendidas + "\n";
    msg += "  Total recaudado en colones: " + totalRecaudado;
    return msg;
  }
}
