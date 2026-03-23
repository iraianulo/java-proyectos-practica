package PracticaCajeroAutomatico;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Clase encargada de gestionar toda la interacción con el usuario:
 * login, selección de cuenta y operaciones disponibles.
 * 
 * Hereda de Cuenta para poder usar directamente los métodos de saldo.
 */
public class MenuOpciones extends Cuenta {
	
	//Scanner para leer datos por consola
	Scanner menu = new Scanner(System.in);
	
	//Formato para mostrar dinero con € y dos decimales.
	DecimalFormat formatoDinero = new DecimalFormat("###.##0,00'€'");
	
	//Simulación de base de datos: cliente -> PIN
	HashMap<Integer, Integer> datos = new HashMap<>();
	
	
	/**
	 * Método de acceso al sistema (login).
	 * 
	 * Flujo:
	 * 1. Pide número de cliente
	 * 2. Pide PIN
	 * 3. Comprueba si existen en el HashMap
	 * 4. Si es correcto -> entra al menú de cuentas
	 * 
	 * IMPORTANTE:
	 * - Aquí se simula una BD con HashMap (en proyectos reales sería una BD real)
	 * - Controla errores si el usuario mete letras en vez de números
	 */
	public void getAcceso() {
		int x = 1;
		do {
			try {
				datos.put(9876543, 9876);
				datos.put(8989898, 1890);
				
				System.out.println("Bienvenido a TuBanco");
				System.out.println("Inserte su código de cliente:");
				setNumCliente(menu.nextInt());
				
				System.out.println("Inserte su número PIN:");
				setPin(menu.nextInt());
			}
			catch(Exception e) {
				System.err.println("\nTipo de caracteres inválidos. Solamente se permiten números\n" + e);
				x = 2;
			}
			
			int nc = getNumCliente();
			int p = getPin();
			
			if (datos.containsKey(nc) && datos.get(nc) == p) {
				getTipoCuenta();
			} else {
				System.err.println("\nCódigo de cliente erróneo o PIN erróneo\n\n");
			}
		} while (x == 1);
	}
	
	
	/**
	 * Menú para elegir tipo de cuenta.
	 * 
	 * IMPORTANTE:
	 * - Este método actúa como "hub" del sistema
	 * - Después de cada operación se vuelve aquí.
	 */
	public void getTipoCuenta() {
		System.out.println("Selecciona el tipo de cuenta al que le gustaría acceder: ");
		System.out.println("[1] - Cuenta principal.");
		System.out.println("[2] - Cuenta de ahorros.");
		System.out.println("[0] - Cuenta salir.");
		System.out.print("Seleccione una opción: ");
		
		int opcion = menu.nextInt();
		
		switch (opcion) {
		case 1:
			getPrincipal();
		break;
		case 2:
			getAhorro();
		break;
		case 0:
			System.out.println("Gracias por usar TuBanco. ¡Adiós!\n");
		break;
		default:
			System.err.println("\n Opción inválida \n");
		}
	}
	
	
	/**
	 * Menú de operaciones para la cuenta principal.
	 * 
	 * IMPORTANTE:
	 * - Después de cada acción vuelve al menú principal (getTipoCuenta)
	 */
	public void getPrincipal() {
		System.out.println("--- CUENTA PRINCIPAL ---");
		System.out.println("[1] - Consultar saldo.");
		System.out.println("[2] - Retirar dinero.");
		System.out.println("[3] - Ingresar dinero.");
		System.out.println("[0] - Salir.");
		System.out.print("Seleccione una opción: ");
		
		int opcion = menu.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Saldo de la cuenta principal: " + formatoDinero.format(getSaldoPrincipal()));
			getTipoCuenta();
		break;
		case 2:
			getTecladoRetirarPrincipal();
			getTipoCuenta();
		break;
		case 3:
			getTecladoIngresarPrincipal();
			getTipoCuenta();
		break;
		case 4:
			System.out.println("Gracias por usar TuBanco. ¡Adiós!");
		break;
		default:
			System.err.println("\n Opción inválida \n");
			getPrincipal();
		}
	}
	
	
	/**
	 * Menú de operaciones para la cuenta de ahorros.
	 */
	public void getAhorro() {
		System.out.println("--- CUENTA DE AHORROS ---");
		System.out.println("[1] - Consultar saldo.");
		System.out.println("[2] - Retirar dinero.");
		System.out.println("[3] - Ingresar dinero.");
		System.out.println("[0] - Salir.");
		System.out.print("Seleccione una opción: ");
		
		int opcion = menu.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Saldo de la cuenta de ahorros: " + formatoDinero.format(getSaldoAhorro()));
			getTipoCuenta();
		break;
		case 2:
			getTecladoRetirarAhorro();
			getTipoCuenta();
		break;
		case 3:
			getTecladoIngresarAhorro();
			getTipoCuenta();
		break;
		case 0:
			System.out.println("Gracias por usar TuBanco. ¡Adiós!");
		break;
		default:
			System.err.println("\n Opción inválida. \n");
			getAhorro();
		}
	}
}