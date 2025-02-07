package practica5;

import java.util.Arrays;

public class Tablero {

	Personaje tablero[][];

	Tablero(){
		tablero=new Personaje [8][8];
	}

	public boolean huecoLibre(int fila, int columna) {
		if (tablero[fila][columna]!=null)
			return false;

		else
			return true;
	}

	public boolean huecoExiste(int fila, int columna) {
		if ((fila<0 || columna<0) || (fila>7 || columna>7))
			return false;
		return true;
	}

	public void insertarPj(int fila, int columna, Personaje pj) {
		tablero[fila][columna]=pj;
	}

	public int getCostePj(int fila, int columna) {
		return tablero[fila][columna].getCoste();
	}

	public boolean comprobarPjPropio(int fila, int columna, int equipo) {
		if(!huecoExiste(fila, columna)) {
			System.out.println(Equipo.ANSI_RED +"Tiene que ser una posicion válida"+ Equipo.ANSI_RESET);
			return false;
		}
		else if(huecoLibre(fila, columna)) {
			System.out.println(Equipo.ANSI_RED +"La posición está vacía"+ Equipo.ANSI_RESET);
			return false;
		}
		else if (tablero[fila][columna].jugador != equipo) {
			System.out.println(Equipo.ANSI_RED +"Tienes que elegir un personaje de tu ejercito"+ Equipo.ANSI_RESET);
			return false;
		}

		return true;
	}

	public boolean comprobarEnemigo(int fila, int columna, int equipo) {
		if(!huecoExiste(fila, columna)) {
			System.out.println(Equipo.ANSI_RED +"Tiene que ser una posicion válida"+ Equipo.ANSI_RESET);
			return false;
		}
		else if(huecoLibre(fila, columna)) {
			System.out.println(Equipo.ANSI_RED +"La posición está vacía"+ Equipo.ANSI_RESET);
			return false;
		}
		else if (tablero[fila][columna].jugador == equipo) {
			System.out.println(Equipo.ANSI_RED +"Tienes que elegir un personaje enemigo"+ Equipo.ANSI_RESET);
			return false;
		} 
		return true;
	}

	public boolean moverPj(int fila, int columna, int fila2, int columna2, int equipo) {

		if(!huecoExiste(fila2, columna2)) {
			System.out.println(Equipo.ANSI_RED +"Tiene que ser una posicion válida"+ Equipo.ANSI_RESET);
			return false;
		}
		else if(!huecoLibre(fila2, columna2)) {
			System.out.println(Equipo.ANSI_RED +"La posición ya está ocupada"+ Equipo.ANSI_RESET);
			return false;
		}

		else {
			tablero[fila2][columna2]=tablero[fila][columna];
			tablero[fila][columna]=null;
			return true;
		}

	}

	public void atacar(int fila, int columna, int fila2, int columna2, Equipo e) {

		int fp = fila - tablero[fila][columna].getRadioAtaque();
		if((fila2<fila - tablero[fila][columna].getRadioAtaque() && fila2>fila + tablero[fila][columna].getRadioAtaque())
				|| (columna2<columna - tablero[fila][columna].getRadioAtaque() && columna2>columna + tablero[fila][columna].getRadioAtaque()))
			System.out.println("El personaje seleccionado no está en el radio de ataque");

		else {
			int ataquefinal=tablero[fila][columna].agredir()-tablero[fila2][columna2].defensa();

			if(ataquefinal<=0) 
				System.out.println(Equipo.ANSI_GREEN+"Ataque bloqueado"+Equipo.ANSI_RESET);

			else if(tablero[fila2][columna2].getVidaActual()>ataquefinal)
				tablero[fila2][columna2].setVidaActual(tablero[fila2][columna2].getVidaActual()-ataquefinal);

			else {
				for(int i=0; i<e.ejercito.length;i++) {
					if(tablero[fila2][columna2].equals(e.ejercito[i])) { 

						System.arraycopy(e.ejercito, i+1, e.ejercito, i, e.ejercito.length-i-1);
						e.ejercito = Arrays.copyOf(e.ejercito, e.ejercito.length-1);
					}
				}
				tablero[fila2][columna2]=null;
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		Personaje p = (Personaje)obj;
		for(int i=0; i<8;i++) {
			for(int j=0; i<8;i++) {
				if(tablero[i][j].equals(obj))
					return true;
			}
		}
		return false;
	}



	public void imprimirTablero(){
		System.out.print(" ");
		for (int j = 0; j < tablero[0].length; j++) 
			System.out.printf("%-1s%5d", "", j);

		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			System.out.printf("%-3d", i);
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == null) 
					System.out.printf("|%-5s", " ");
				else 
					System.out.printf("|%-5s", tablero[i][j].pjEnTablero());

			}
			System.out.println("|");
		}
	}
}

