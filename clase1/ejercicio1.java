import java.util.Scanner;

public class ParOImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese un número entero: ");
            
            // Validar que la entrada sea un entero
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                return;
            }

            int numero = scanner.nextInt();

            // Determinar si es par o impar
            if (numero % 2 == 0) {
                System.out.println("El número " + numero + " es PAR.");
            } else {
                System.out.println("El número " + numero + " es IMPAR.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
