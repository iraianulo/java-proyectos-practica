package PracticaCajeroAutomatico;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Clase que representa la lógica de una cuenta bancaria.
 * 
 * RESPONSABILIDAD:
 * - Guardar datos (cliente, pin, saldos)
 * - Realizar operaciones (ingresar/retirar)
 * 
 * IMPORTANTE:
 * - Aquí está la lógica, NO la interfaz (aunque hay mezcla en este ejercicio)
 */
public class Cuenta {
	
	private int numCliente;
	private int pin;
	private double saldoPrincipal;
	private double saldoAhorro;
	
	Scanner teclado = new Scanner(System.in);
	DecimalFormat formatoDinero = new DecimalFormat("###.##0,00'€'");
	
	// GETTERS Y SETTERS → encapsulación
	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}
	
	public int getNumCliente() {
		return numCliente;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public int getPin() {
		return pin;
	}
	
	public double getSaldoPrincipal() {
		return saldoPrincipal;
	}
	
	public double getSaldoAhorro() {
		return saldoAhorro;
	}
	
	/**
	 * Métodos internos de cálculo (lógica pura).
	 * 
	 * IMPORTANTE:
	 * - Separar cálculo de entrada de datos es buena práctica
	 */
	public void calcularRetirarPrincipal (double cantidad) {
		saldoPrincipal -= cantidad;
	}
	
	public void calcularRetirarAhorro (double cantidad) {
		saldoAhorro -= cantidad;
	}
	
	public void calcularIngresarPrincipal (double cantidad) {
		saldoPrincipal += cantidad;
	}
	
	public void calcularIngresarAhorro (double cantidad) {
		saldoAhorro += cantidad;
	}
	
	
	/**
	 * Métodos que interactúan con el usuario (entrada por teclado)
	 * 
	 * VALIDACIONES:
	 * - No permitir números negativos
	 * - No permitir retirar más de lo disponible
	 */
	public void getTecladoRetirarPrincipal() {
		System.out.println("Saldo de la cuenta principal: " + formatoDinero.format(saldoPrincipal));
		System.out.print("Cantidad que deasea retirar de la cuenta principal: ");
		double cantidad = teclado.nextDouble();
		
		if (cantidad <= 0) {
			System.err.println("Cantidad inválida. Por favor, introduzca un número positivo.");
		} else if (saldoPrincipal - cantidad >= 0) {
			calcularRetirarPrincipal(cantidad);
			System.out.println("Nuevo saldo de la cuenta principal: " + formatoDinero.format(saldoPrincipal));
		} else {
			System.out.println("No hay fondos suficientes.");
		}
	}
	
	public void getTecladoRetirarAhorro() {
		System.out.println("Saldo de la cuenta de ahorros: " + formatoDinero.format(saldoAhorro));
		System.out.print("Cantidad que desea retirar de la cuenta de ahorros: ");
		double cantidad = teclado.nextDouble();
		
		if (cantidad <= 0) {
			System.err.println("Cantidad inválida. Por favor, introduzca un número positivo.");
		} else if (saldoAhorro - cantidad >= 0) {
			calcularRetirarAhorro(cantidad);
			System.out.println("Nuevo saldo de la cuenta principal: " + formatoDinero.format(saldoAhorro));
		} else {
			System.out.println("No hay fondos suficientes.");
		}
	}
	
	public void getTecladoIngresarPrincipal() {
		System.out.println("Saldo de la cuenta principal: " + formatoDinero.format(saldoPrincipal));
		System.out.print("Cantidad que desea ingresar en la cuenta principal: ");
		double cantidad = teclado.nextDouble();
		
		if (cantidad <= 0) {
			System.err.println("Cantidad inválida. Por favor, introduzca un número positivo.");
		} else {
			calcularIngresarPrincipal(cantidad);
			System.out.println("Nuevo saldo de la cuenta principal: " + formatoDinero.format(saldoPrincipal));
		}
	}
	
	public void getTecladoIngresarAhorro() {
		System.out.println("Saldo de la cuenta de ahorros: " + formatoDinero.format(saldoAhorro));
		System.out.print("Cantidad que desea ingresar en la cuenta de ahorros: ");
		double cantidad = teclado.nextDouble();
		
		if (cantidad <= 0) {
			System.err.println("Cantidad inválida. Por favor, introduzca un número positivo.");
		} else {
			calcularIngresarAhorro(cantidad);
			System.out.println("Nuevo saldo de la cuenta de ahorros: " + formatoDinero.format(saldoAhorro));
		}
	}

}