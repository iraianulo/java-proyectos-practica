import java.util.Scanner; //importamos Scanner para poder introducir datos por teclado

public class CalculadoraSimple {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in); //instanciamos la clase Scanner para que el programa pueda leer datos por teclado
		
		//Variables
		double num1;
		double num2;
		char operador;
		double resultado = 0; //lo declaramos en 0 para que no nos dé error de que no hemos inicializado ya que al contrario que los num, no le damos valor al principio a través de teclado.
		boolean esOperacionValida = true; // un boolean para comprobar que el operador que usamos sea válido.
		
		System.out.println("=== CALCULADORA ==="); //le damos título a nuestra calculadora
		
		System.out.print("Introduzca el primer número: "); //usamos print en vez de println para que el usuario escriba junto a la frase en la misma línea, en lugar de ser en la siguiente.
		num1 = teclado.nextDouble(); //pedimos la introducción de un primer número por teclado.
		
		System.out.print("Introduzca el operador (+, -, *, /, ^): ");
		operador = teclado.next().charAt(0); //para que en caso de que el usuario introduzca más de un caracter, solamente elija el primero.
		
		System.out.print("Introduzca el segundo número: ");
		num2 = teclado.nextDouble();
		
		switch (operador) { //un switch donde metemos todos los casos y se realizan las operaciones dependiendo del operador elegido.
		//Recuerda que los operadores son tipo char así que irán entre comillas simples, no dobles (¡las dobles son para Strings!).
		case '+':
			resultado = num1 + num2;
		break;
		case '-':
			resultado = num1 - num2;
		break;
		case '*':
			resultado = num1 * num2;
		break;
		case '/':
			if (num2 != 0) { //Matemáticamente es imposible dividir entre 0, así que añadiremos una regla con un 'if' para que solamente se proceda a la operación si num2 es distinto de 0.
				resultado = num1 / num2;
			} else {
				System.err.println("No es posible dividir un número entre 0.");
				esOperacionValida = false; //consecuentemente le decimos que la operación no es válida, con lo cual, no nos mostrará el resultado al final, pues no se ha podido realizar la divsión.
			}
		break;
		case '^':
			resultado = Math.pow(num1, num2); //Math.pow(base, exponente) -> eleva un número base a la potencia de otro número exponente.
		break;
		default:
			System.err.println("Ha introducido un operador no válido.");
			esOperacionValida = false; //si no se ha introducido un operador compatible con nuestra calculadora, muestra un mensaje de error y le dice a nuestro programa que no es un operador válido a través del boolean, así que no mostrará el resultado a final.
		}
		
		if (esOperacionValida) { //le decimos al programa que solamente muestre el resultado si se usa un operador válido.
			System.out.println(resultado);
		} //no necesitamos un else porque es cuestión de verdadero o falso. Si 'esOperacionValida == false', no imprimirá el resultado.
		
		
		
		teclado.close(); //Es buena práctica cerrar el Scanner al final de nuestro código.

	}

}
