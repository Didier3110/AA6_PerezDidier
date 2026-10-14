public class CasetaPeaje {

    public static final String TIPO_PARTICULAR = "particular";
    public static final String TIPO_CARGA_LIVIANA = "carga liviana";
    public static final String TIPO_CARGA = "carga";
    public static final String TIPO_MOTO = "moto";

    public static final double MONTO_PARTICULAR = 100;
    public static final double MONTO_CARGA_LIVIANA = 200;
    public static final double MONTO_CARGA = 500;
    public static final double MONTO_MOTO = 75;

    private int numeroCaseta;
    private String nombreAutopista;
    private double totalCobrado;

    private static int cantidadCasetas;

    public CasetaPeaje(String pNombreAutopista) {
        cantidadCasetas++;
        numeroCaseta = cantidadCasetas;
        nombreAutopista = pNombreAutopista;
    }

    public void cobrarPeaje(Vehiculo obj) {
        totalCobrado += obtenerMonto(obj.getTipo());
    }

    private double obtenerMonto(String pTipo) {
        switch (pTipo.toLowerCase()) {
            case TIPO_PARTICULAR:
                return MONTO_PARTICULAR;
            case TIPO_CARGA_LIVIANA:
                return MONTO_CARGA_LIVIANA;
            case TIPO_CARGA:
                return MONTO_CARGA;
            case TIPO_MOTO:
                return MONTO_MOTO;
            default:
                return 0;
        }
    }

    public double getTotalCobrado() {
        return totalCobrado;
    }

    public static int getCantidadDeCasetasPeaje() {
        return cantidadCasetas;
    }

    public String toString() {
        return "Caseta de Peaje número: " + numeroCaseta + "\n" +
               "Autopista= " + nombreAutopista + "\n" +
               "Total Cobrado= " + totalCobrado + "\n";
    }
}