import java.util.Map;

public class ConversorDeMoneda {
    private ControladorApi controladorApi;
    private String monedaBase;

    public ConversorDeMoneda(ControladorApi controladorApi, String monedaBase) {
        this.controladorApi = controladorApi;
        this.monedaBase = monedaBase;
    }

    public void convertir(int opcion, double cantidad) {
        try {
            // Obtener las tasas de cambio para la moneda base
            Map<String, Double> rates = controladorApi.getConversionRates(monedaBase);

            double resultado = 0.0;
            String monedaObjetivo = "";

            // Realizar la conversión basada en la opción seleccionada
            switch (opcion) {
                case 1:
                    monedaObjetivo = "ARS";
                    resultado = cantidad * rates.get(monedaObjetivo);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f USD => %.2f ARS\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                case 2:
                    monedaObjetivo = "USD";
                    resultado = cantidad / rates.get("ARS");
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f ARS => %.2f USD\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                case 3:
                    monedaObjetivo = "BRL";
                    resultado = cantidad * rates.get(monedaObjetivo);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f USD => %.2f BRL\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                case 4:
                    monedaObjetivo = "USD";
                    resultado = cantidad / rates.get("BRL");
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f BRL => %.2f USD\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                case 5:
                    monedaObjetivo = "EUR";
                    resultado = cantidad * rates.get(monedaObjetivo);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f USD => %.2f EUR\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                case 6:
                    monedaObjetivo = "USD";
                    resultado = cantidad / rates.get("EUR");
                    System.out.println("++++++++++++++++++++++++++++++++");
                    System.out.printf("%.2f EUR => %.2f USD\n", cantidad, resultado);
                    System.out.println("++++++++++++++++++++++++++++++++");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

