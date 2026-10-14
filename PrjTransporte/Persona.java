
public class Persona {
  public static final String CONDICION_REGULAR = "regular";
  public static final String CONDICION_ESTUDIANTE = "estudiante";
  public static final String CONDICION_CIUDADANO_ORO = "ciudadano de oro";

  private String nombre;
  private String condicion;

  public Persona(String pNombre, String pCondicion) {
    nombre = pNombre;
    condicion = pCondicion;
  }

  
  public Persona(String pNombre) {
    this(pNombre, CONDICION_REGULAR);
  }

  public String getNombre() {
    return nombre;
  }

  public String getCondicion() {
    return condicion;
  }

  @Override
  public String toString() {
    String msg = "Persona\n";
    msg += "  Nombre: " + nombre + "\n";
    msg += "  Condicion: " + condicion;
    return msg;
  }
}
