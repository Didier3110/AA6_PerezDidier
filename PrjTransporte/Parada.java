/** Representa una parada que puede pertenecer a varias rutas. */
public class Parada {
  private String codigo;
  private String nombre;

  public Parada(String pCodigo, String pNombre) {
    codigo = pCodigo;
    nombre = pNombre;
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    String msg = "Parada\n";
    msg += "  Codigo: " + codigo + "\n";
    msg += "  Nombre: " + nombre;
    return msg;
  }
}
