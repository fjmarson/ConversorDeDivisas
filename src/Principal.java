import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String apiKey = "5d6b8a7f56eb3bb870c70814";
        String monedaBase = "USD";

        // Crear el controlador de la API
        ControladorApi controladorApi = new ControladorApi(apiKey);

        // Crear el conversor de monedas
        ConversorDeMoneda conversorDeMoneda = new ConversorDeMoneda(controladorApi, monedaBase);

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            // Mostrar el menú de opciones
            opcion = mostrarMenu(scanner);

            // Si el usuario selecciona "Salir", salimos del bucle
            if (opcion == 9) {
                System.out.println("Saliendo...");
                break;
            }
            // Solicitar la cantidad a convertir
            System.out.print("Ingrese la cantidad que desea convertir: ");
            double cantidad = scanner.nextDouble();

            // Realizar la conversión y mostrar el resultado
            conversorDeMoneda.convertir(opcion, cantidad);
        } while (true);

        // Cerrar el escáner
        scanner.close();
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("Bienvenido/a al Conversor de Moneda");
        System.out.println("****************************");
        System.out.println("Seleccione una opción:");
        System.out.println("1 - Dólar => Peso Argentino");
        System.out.println("2 - Peso Argentino => Dólar");
        System.out.println("3 - Dólar => Real Brasileño");
        System.out.println("4 - Real Brasileño => Dólar");
        System.out.println("5 - Dólar => Euro");
        System.out.println("6 - Euro => Dólar");
        System.out.println("9 - Salir");
        System.out.println("****************************");

        // Leer la opción seleccionada por el usuario
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
}


