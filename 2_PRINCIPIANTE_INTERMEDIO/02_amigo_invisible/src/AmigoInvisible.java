import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AmigoInvisible {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in); // Lee la entrada del usuario por teclado
		ArrayList<String> nombres = new ArrayList<String>(); // Lista que almacena los participantes
		
		String nombre;
		int opcion = 0; // Opción elegida en el menú
		int numPart = 0; // Contador de participantes inscritos
		
		// Bucle principal: se repite hasta que el usuario elija la opción 0 (finalizar)
		do {
			// Muestra el menú principal con el número de participantes actual
			System.out.println("=== SORTEO DE AMIGO INVISIBLE ===");
			System.out.println("Número de participantes: " + numPart);
			System.out.println("[1] - Insertar nuevo participante.");
			System.out.println("[0] - Finalizar.");
			
			// Captura la opción del usuario con control de errores
			try {
				System.out.print("Seleccione una opción: ");
				opcion = teclado.nextInt();
			} catch (Exception e) {
				// Si el usuario introduce algo que no es un número, muestra un aviso
				System.err.println("Introduzca un nombre.");
			}
			
			teclado.nextLine(); // Limpia el buffer del teclado tras leer el entero
			
			switch (opcion) {
			case 1:
				// Solicita e introduce el nombre del nuevo participante en la lista
				System.out.print("Inserte su nombre: ");
				nombre = teclado.nextLine();
				numPart++; //Suma cada participante
				nombres.add(nombre); //guarda cada nombre en la ArrayList 'nombres'.
			break;
			case 0:
				System.out.println("Se han inscrito: " + numPart + " participantes.");
				// Comprueba que hay suficientes participantes para realizar el sorteo
				if (nombres.size() < 3) { //'size' nos devuelve el tamaño de la lista
					System.out.println("Se necesitan al menos 2 personas para el sorteo.");
				} else {
					Collections.shuffle(nombres); //collections.shuffle() mezcla los nombres
					
					// Recorre la lista asignando a cada participante la persona siguiente como receptor
					System.out.println("\n=== RESULTADOS DEL SORTEO ===");
					for (int i = 0; i < nombres.size(); i++) { 
						String regalador = nombres.get(i); //coge esa mezcla anterior y se la asigna a la siguiente persona
						String receptor;
						
						// El último participante le regala al primero, cerrando el ciclo
						if (i == nombres.size() - 1) {
							receptor = nombres.get(0);
						} else {
							receptor = nombres.get(i + 1);
						}
						
						System.out.println(regalador + " le regala a -> " + receptor);
					}
				}
			break;
			// Cualquier opción distinta de 0 o 1 se considera inválida
			default:
				System.err.println("Opción no válida.");
			}
			
		} while (opcion != 0); // Continúa el bucle mientras el usuario no elija salir
		
		teclado.close(); // Libera el recurso Scanner al terminar el programa
	}

}