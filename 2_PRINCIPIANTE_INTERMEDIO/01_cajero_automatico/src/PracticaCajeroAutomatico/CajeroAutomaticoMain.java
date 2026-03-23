package PracticaCajeroAutomatico;

/**
 * Clase principal que arranca la aplicación.
 * 
 * IMPORTANTE:
 * - Solo se encarga de iniciar el flujo
 * - No debe contener lógica de negocio
 */
public class CajeroAutomaticoMain extends MenuOpciones {
	
	public static void main(String[] args) {
		MenuOpciones opciones = new MenuOpciones();
		opciones.getAcceso();
	}
}