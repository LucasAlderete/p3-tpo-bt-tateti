package tpo;

import java.util.Scanner;

public class Main {

	private static final int POSICION_INICIO_MAQUINA = 0;

	public static void main(String[] args) {

		

		TurnoJugador maquina = seleccionarNumeroDeJugador();
		TatetiTDA tateti = new Tateti();
		
		tateti.Inicializar();
		tateti.Turno(maquina);
		

		int position;

		if (TurnoJugador.PRIMERO.equals(maquina)) {
			position = POSICION_INICIO_MAQUINA;
		} else {

			position = realizarJugada();
		}

		while (!tateti.Jugar(position)) {
			position = realizarJugada();
			
		}

	}

	private static int realizarJugada() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese posicion:");
		
		try {
			int valor = Integer.parseInt(scanner.nextLine());
			if (valor <= 0 || valor > 9) {
				printMensaje("Posicion invalida, vuelva a intentar.");
				return realizarJugada();
			}
			return valor;

		} catch (Exception e) {

			printMensaje("Jugada invalida, vuelva a intentar.");
			return realizarJugada();
		}
	}
	
	private static void printMensaje(String msj) {
		System.out.println("");
		System.out.println(msj);
		System.out.println("");
	}
	
	private static TurnoJugador seleccionarNumeroDeJugador() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione numero de jugador (1 o 2):");
		

		try {
			int nroJugador = Integer.parseInt(scanner.nextLine());
			
			if (nroJugador < 1 || nroJugador > 2 ) {
				printMensaje("Numero invalido, vuelva a intentar");
				return seleccionarNumeroDeJugador();
			}
			return nroJugador == 1 ? TurnoJugador.SEGUNDO : TurnoJugador.PRIMERO;

		} catch (Exception e) {

			printMensaje("Seleccion invalida, vuelva a intentar.");
			return seleccionarNumeroDeJugador();
		}
		
	}

}
