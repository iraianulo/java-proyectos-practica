import java.awt.*; //gráficos básicos (colores, layouts...)
import java.awt.event.*; //eventos (clics)
import java.util.*;
import javax.swing.*; //interfaz gráfica (botones, ventanas...)

public class TresEnRaya implements ActionListener { //representa todo el juego. ActionListener permite detectar clics
	
	Random aleatorio = new Random(); //Para elegir quién empieza
	JFrame recuadro = new JFrame(); //ventana principal
	JPanel titulo_panel = new JPanel(); //panel para el título
	JPanel boton_panel = new JPanel(); //panel para el tablero
	JLabel texto = new JLabel(); //texto superior
	JButton[] botones = new JButton[9]; //Array de 9 botones (tablero 3x3)
	boolean turnoJ1; //Control de turno. Como se trata de un juego de dos jugadores, no hace falta tener un boolean para jugador 2 (j2) porque si el turno de j1 es false, significa que es el turno del j2.
	
	
	TresEnRaya(){ //Constructor
		recuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el programa al cerrar la ventana
		recuadro.setSize(800, 800); //Tamaño de la ventana
		recuadro.getContentPane().setBackground(new Color(50, 50, 50)); //Color de fondo (RGB)
		recuadro.setLayout(new BorderLayout()); //Layout principal
		recuadro.setVisible(true); //Hacer visible la ventana
		
		texto.setBackground(new Color(25, 25, 25)); //Color del fondo de texto
		texto.setForeground(new Color(25, 255, 0)); // Color del texto
		texto.setFont(new Font("Ink Free", Font.BOLD,75)); //Fuente, estilo y tamaño
		texto.setHorizontalAlignment(JLabel.CENTER); // Centrado
		texto.setText("Tres En Raya"); //Texto que se muestra
		texto.setOpaque(true); //Permite que el fondo se vea
		texto.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 0)); //Espacio interno
		
		//Configurar panel superior (texto)
		titulo_panel.setLayout(new BorderLayout());
		titulo_panel.setBounds(0,0,600,100);
		
		//Configurar tablero (3x3)
		boton_panel.setLayout(new GridLayout(3,3));
		boton_panel.setBackground(new Color(150, 150, 150));
		
		//Creamos los botnes
		for (int i = 0; i < 9; i++) { //recorre los 9 espacios
			botones[i] = new JButton(); //Crea botón
			boton_panel .add(botones[i]); //Lo añade al panel
			botones[i].setFont(new Font("MV Boli", Font.BOLD,120)); //Fuente grande
			botones[i].setFocusable(false); //Quita borde de foco
			botones[i].addActionListener(this); //Este botón usará 'ActionPerformed'
		}
		
		//Añadir todo a la ventana
		titulo_panel.add(texto);
		recuadro.add(titulo_panel, BorderLayout.NORTH);
		recuadro.add(boton_panel);
		
		//Iniciar turno
		primerTurno();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //Se ejecuta cuando haces clic en un botón
		
		for (int i = 0; i < 9; i++) { //Busca qué botón ha sido pulsado
			if (e.getSource()==botones[i]) { //Comprueba cuál es
				if (turnoJ1) {
					if (botones[i].getText().equals("")) { //Solamente si el botón está vacío...
						botones[i].setForeground(new Color(255, 0, 0)); //Pone la X de color de rojo
						botones[i].setText("X"); //...pone una X
						turnoJ1 = false; //Cambia el turno
						texto.setText("Turno de O");
						validar();
					}
				} else {
					if (botones[i].getText().equals("")) {
						botones[i].setForeground(new Color(0, 0, 255)); //Pone la O de color azul
						botones[i].setText("O");
						turnoJ1 = true;
						texto.setText("Turno de X");
						validar();
					}
				}
			}
		}
		
	}
	
	public void primerTurno() {
		
		try {
			Thread.sleep(2000); //espera 2 segundos a anunciar el turno
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (aleatorio.nextInt(2) == 0) { //50% de probabilidad de que toque el primer turno a X o a O
			turnoJ1 = true;
			texto.setText("turno de X");
		} else {
			turnoJ1 = false;
			texto.setText("turno de O");
		}
		
	}
	
	public void validar() { //Comprueba todas las combinaciones posibles para ganar
		//Comprobar si gana X
		if(
				(botones[0].getText().equals("X")) &&
				(botones[1].getText().equals("X")) &&
				(botones[2].getText().equals("X"))
				) {
			xGana(0,1,2); //Llama al método xGana si hay una X en las posiciones 0, 1 y 2 (línea superior).
		}
		if(
				(botones[3].getText().equals("X")) &&
				(botones[4].getText().equals("X")) &&
				(botones[5].getText().equals("X"))
				) {
			xGana(3,4,5);
		}
		if(
				(botones[6].getText().equals("X")) &&
				(botones[7].getText().equals("X")) &&
				(botones[8].getText().equals("X"))
				) {
			xGana(6,7,8);
		}
		if(
				(botones[0].getText().equals("X")) &&
				(botones[3].getText().equals("X")) &&
				(botones[6].getText().equals("X"))
				) {
			xGana(0,3,6);
		}
		if(
				(botones[1].getText().equals("X")) &&
				(botones[4].getText().equals("X")) &&
				(botones[7].getText().equals("X"))
				) {
			xGana(1,4,7);
		}
		if(
				(botones[2].getText().equals("X")) &&
				(botones[5].getText().equals("X")) &&
				(botones[8].getText().equals("X"))
				) {
			xGana(2,5,8);
		}
		if(
				(botones[0].getText().equals("X")) &&
				(botones[4].getText().equals("X")) &&
				(botones[8].getText().equals("X"))
				) {
			xGana(0,4,8);
		}
		if(
				(botones[2].getText().equals("X")) &&
				(botones[4].getText().equals("X")) &&
				(botones[6].getText().equals("X"))
				) {
			xGana(2,4,6);
		}
		//Comprobar si gana O
		// Puedes copiar y pegar lo anterior y cambiar las "X" por "O", y el 'xGana' por 'oGana'
		if(
				(botones[0].getText().equals("O")) &&
				(botones[1].getText().equals("O")) &&
				(botones[2].getText().equals("O"))
				) {
			oGana(0,1,2);
		}
		if(
				(botones[3].getText().equals("O")) &&
				(botones[4].getText().equals("O")) &&
				(botones[5].getText().equals("O"))
				) {
			oGana(3,4,5);
		}
		if(
				(botones[6].getText().equals("O")) &&
				(botones[7].getText().equals("O")) &&
				(botones[8].getText().equals("O"))
				) {
			oGana(6,7,8);
		}
		if(
				(botones[0].getText().equals("O")) &&
				(botones[3].getText().equals("O")) &&
				(botones[6].getText().equals("O"))
				) {
			oGana(0,3,6);
		}
		if(
				(botones[1].getText().equals("O")) &&
				(botones[4].getText().equals("O")) &&
				(botones[7].getText().equals("O"))
				) {
			oGana(1,4,7);
		}
		if(
				(botones[2].getText().equals("O")) &&
				(botones[5].getText().equals("O")) &&
				(botones[8].getText().equals("O"))
				) {
			oGana(2,5,8);
		}
		if(
				(botones[0].getText().equals("O")) &&
				(botones[4].getText().equals("O")) &&
				(botones[8].getText().equals("O"))
				) {
			oGana(0,4,8);
		}
		if(
				(botones[2].getText().equals("O")) &&
				(botones[4].getText().equals("O")) &&
				(botones[6].getText().equals("O"))
				) {
			oGana(2,4,6);
		}
	}
	
	public void xGana(int a, int b, int c) {
		botones[a].setBackground(Color.GREEN); //Marca la línea ganadora de verde.
		botones[b].setBackground(Color.GREEN);
		botones[c].setBackground(Color.GREEN);
		
		for (int i = 0; i < 9; i++) {
			botones[i].setEnabled(false); //Bloquea el tablero
		}
		texto.setText("¡X gana!");
	}
	
	public void oGana(int a, int b, int c) {
		botones[a].setBackground(Color.GREEN);
		botones[b].setBackground(Color.GREEN);
		botones[c].setBackground(Color.GREEN);
		
		for (int i = 0; i < 9; i++) {
			botones[i].setEnabled(false);
		}
		texto.setText("¡O gana!");
	}
}
