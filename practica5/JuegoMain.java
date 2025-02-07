package practica5;

import java.util.Scanner;

public class JuegoMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Tablero tablero=new Tablero();
		Soldado s=new Soldado(0);
		Caballero c=new Caballero(0);
		Arquero a=new Arquero(0);
		Lancero l=new Lancero(0);
		int turno=1;

		System.out.println("Inicio Juego");
		System.out.println(Equipo.ANSI_RED + "Jugador 1: Rojo" + Equipo.ANSI_RESET);
		Equipo e1 = new Equipo(); 
		System.out.println(Equipo.ANSI_BLUE + "Jugador 2: Azul" + Equipo.ANSI_RESET);
		Equipo e2 = new Equipo();
		System.out.println("----------------------------------------------------------------");
		System.out.println(Equipo.ANSI_RED + "Jugador 1 " +  Equipo.ANSI_RESET + "-- Creación de Ejercito");
		System.out.println("----------------------------------------------------------------");

		do {
			if(e1.getSaldo() == 0 )
				turno=2;

			if (turno==2 && e2.getSaldo()==50) {
				System.out.println(Equipo.ANSI_BLUE +"Jugador 2" +  Equipo.ANSI_RESET + " -- Creación de Ejercito");
				System.out.println("----------------------------------------------------------------");
			}
			System.out.print("1 --> ");
			s.infoPj();
			System.out.print("2 --> ");
			c.infoPj();
			System.out.print("3 --> ");
			a.infoPj();
			System.out.print("4 --> ");
			l.infoPj();
			System.out.println();
			System.out.println("¿Que personaje quieres añadir?: ");
			int opcion = sc.nextInt();
			int fila;
			int columna;
			sc.nextLine();	

			switch (opcion) {
			case 1: 

				if((turno==1 && !comprobarSaldoParaPj(e1, s)) || ((turno==2 && !comprobarSaldoParaPj(e2, s)))) 
					System.out.println(Equipo.ANSI_RED +"No tienes saldo suficiente para el soldado"+  Equipo.ANSI_RESET);

				else {

					do {
						do {
							pedirFilas();
							fila = sc.nextInt();
							if(turno==1)
								pedirColumnasPj1();
							else
								pedirColumnasPj2();
							columna = sc.nextInt();				
						}while((turno==1 && !comprobarPosInicialPj1(fila, columna)) || (turno==2 && !comprobarPosInicialPj2(fila, columna)));

						if (!tablero.huecoLibre(fila, columna))
							System.out.println(Equipo.ANSI_RED +"Esa posición ya esta ocupada, elija otra"+  Equipo.ANSI_RESET);					
					}while(!tablero.huecoLibre(fila, columna));

					Soldado soldado=new Soldado(turno);
					if(turno==1) {
						e1.insertarPjEjercito(soldado);
						tablero.insertarPj(fila, columna, soldado);
						tablero.imprimirTablero();
						e1.setSaldo(e1.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e1.getSaldo());
						System.out.println();
					}
					else {
						e2.insertarPjEjercito(soldado);
						tablero.insertarPj(fila, columna, soldado);
						tablero.imprimirTablero();
						e2.setSaldo(e2.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e2.getSaldo());
						System.out.println();
					}

				}

				break;

			case 2: 

				if((turno==1 && !comprobarSaldoParaPj(e1, c)) || ((turno==2 && !comprobarSaldoParaPj(e2, c)))) 
					System.out.println(Equipo.ANSI_RED +"No tienes saldo suficiente para el caballero"+  Equipo.ANSI_RESET);

				else {

					do {
						do {
							pedirFilas();
							fila = sc.nextInt();
							if(turno==1)
								pedirColumnasPj1();
							else
								pedirColumnasPj2();
							columna = sc.nextInt();				
						}while((turno==1 && !comprobarPosInicialPj1(fila, columna)) || (turno==2 && !comprobarPosInicialPj2(fila, columna)));


						if (!tablero.huecoLibre(fila, columna))
							System.out.println(Equipo.ANSI_RED +"Esa posición ya esta ocupada, elija otra"+  Equipo.ANSI_RESET);					
					}while(!tablero.huecoLibre(fila, columna));

					Caballero caballero=new Caballero(turno);
					if(turno==1){
						e1.insertarPjEjercito(caballero);
						tablero.insertarPj(fila, columna, caballero);
						tablero.imprimirTablero();
						e1.setSaldo(e1.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e1.getSaldo());
						System.out.println();
					}
					else {
						e2.insertarPjEjercito(caballero);
						tablero.insertarPj(fila, columna, caballero);
						tablero.imprimirTablero();
						e2.setSaldo(e2.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e2.getSaldo());
						System.out.println();
					}

				}
				break;

			case 3: 	

				if((turno==1 && !comprobarSaldoParaPj(e1, a)) || ((turno==2 && !comprobarSaldoParaPj(e2, a))))
					System.out.println(Equipo.ANSI_RED +"No tienes saldo suficiente para el arquero"+  Equipo.ANSI_RESET);
				else {

					do {
						do {
							pedirFilas();
							fila = sc.nextInt();
							if(turno==1)
								pedirColumnasPj1();
							else
								pedirColumnasPj2();
							columna = sc.nextInt();				
						}while((turno==1 && !comprobarPosInicialPj1(fila, columna)) || (turno==2 && !comprobarPosInicialPj2(fila, columna)));

						if (!tablero.huecoLibre(fila, columna))
							System.out.println(Equipo.ANSI_RED +"Esa posición ya esta ocupada, elija otra"+  Equipo.ANSI_RESET);					
					}while(!tablero.huecoLibre(fila, columna));

					Arquero arquero=new Arquero(turno);
					if(turno==1){
						e1.insertarPjEjercito(arquero);
						tablero.insertarPj(fila, columna, arquero);
						tablero.imprimirTablero();
						e1.setSaldo(e1.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e1.getSaldo());
						System.out.println();
					}
					else {
						e2.insertarPjEjercito(arquero);
						tablero.insertarPj(fila, columna, arquero);
						tablero.imprimirTablero();
						e2.setSaldo(e2.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e2.getSaldo());
						System.out.println();
					}

				}
				break;

			case 4: 

				if((turno==1 && !comprobarSaldoParaPj(e1, l)) || ((turno==2 && !comprobarSaldoParaPj(e2, l))))
					System.out.println(Equipo.ANSI_RED +"No tienes saldo suficiente para el lancero"+  Equipo.ANSI_RESET);
				else {

					do {
						do {
							pedirFilas();
							fila = sc.nextInt();
							if(turno==1)
								pedirColumnasPj1();
							else
								pedirColumnasPj2();
							columna = sc.nextInt();				
						}while((turno==1 && !comprobarPosInicialPj1(fila, columna)) || (turno==2 && !comprobarPosInicialPj2(fila, columna)));

						if (!tablero.huecoLibre(fila, columna))
							System.out.println(Equipo.ANSI_RED +"Esa posición ya esta ocupada, elija otra"+  Equipo.ANSI_RESET);					
					}while(!tablero.huecoLibre(fila, columna));

					Lancero lancero=new Lancero(turno);
					if(turno==1) {
						e1.insertarPjEjercito(lancero);
						tablero.insertarPj(fila, columna, lancero);
						tablero.imprimirTablero();
						e1.setSaldo(e1.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e1.getSaldo());
						System.out.println();
					}
					else {
						e2.insertarPjEjercito(lancero);
						tablero.insertarPj(fila, columna, lancero);
						tablero.imprimirTablero();
						e2.setSaldo(e2.getSaldo()-tablero.getCostePj(fila, columna));
						System.out.println("Saldo restante: " + e2.getSaldo());
						System.out.println();
					}

				}
				break;

			default: 
				System.out.println(Equipo.ANSI_RED +"Solo se permiten opciones del 1-4"+  Equipo.ANSI_RESET);
				break;
			}	
			System.out.println(turno);
		} while (e1.getSaldo() > 0 || e2.getSaldo() > 0);

		System.out.println("--------------------------------------------------------------");
		System.out.println("Ejercitos creados");
		System.out.println("Cambio de fase");

		System.out.println(turno);

		do{
			Equipo e;
			if (turno==0) {
				System.out.println("Ejercito destruido");
				break;
			}
			else
				turno=1;
			int opcion;
			int fila;
			int columna;
			int fila2;
			int columna2;

			do {
				tablero.imprimirTablero();
				if(turno==1)
					System.out.println(Equipo.ANSI_RED +"Jugador 1:"+ Equipo.ANSI_RESET);
				else
					System.out.println(Equipo.ANSI_BLUE +"Jugador 2:"+ Equipo.ANSI_RESET);
				System.out.println("Que acción desea realizar: ");
				System.out.println("1- Mover");
				System.out.println("2- Atacar");
				System.out.println("3- Curar");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1: 
					do {
						System.out.println("Introduzca la fila del personaje a mover:");
						fila=sc.nextInt();
						System.out.println("Introduzca la columna del personaje a mover:");
						columna=sc.nextInt();
					}while(!tablero.comprobarPjPropio(fila, columna, turno));

					do {
						System.out.println("Introduzca la nueva fila del personaje");
						fila2=sc.nextInt();
						System.out.println("Introduzca la nueva columna del personaje:");
						columna2=sc.nextInt();
					}while(!tablero.moverPj(fila, columna, fila2, columna2, turno));
					turno=cambioTurno(turno);
					break;

				case 2: 
					do {
						System.out.println("Introduzca la fila del personaje con el que atacar:");
						fila=sc.nextInt();
						System.out.println("Introduzca la columna del personaje a mover:");
						columna=sc.nextInt();
					}while(!tablero.comprobarPjPropio(fila, columna, turno));

					do {
						System.out.println("Introduzca la fila del personaje al que quiere agredir:");
						fila2=sc.nextInt();
						System.out.println("Introduzca la columna del personaje al que quiere agredir:");
						columna2=sc.nextInt();	
					}while(!tablero.comprobarEnemigo(fila2, columna2, turno));

					e = (turno==1) ? e2 : e1;

					tablero.atacar(fila, columna, fila2, columna2, e);

					System.out.println(e.getLenght());
					System.out.println("------------------");
					//e2.infoEjercito();

					if(e.ejercitoVacio())
						turno=0;
					else

						turno=cambioTurno(turno);
					break;

				case 3: 
					if ((turno == 1 && !e1.vidaPochaEjercito()) || (turno == 2 && !e2.vidaPochaEjercito())) {
						System.out.println(Equipo.ANSI_GREEN+"Tus tropas están joya, no se pueden curar"+Equipo.ANSI_RESET);
						break;
					}
					else {	
						System.out.println("Tus tropas se toman un respiro para recuperar fuerzas");

						e = (turno==1) ? e1 : e2;

						e.curar();

						System.out.println("Tus tropas se sienten mejor");

						turno=cambioTurno(turno);
					}
					break;

				default: 
					System.out.println(Equipo.ANSI_RED +"Solo se permiten opciones del 1-3"+ Equipo.ANSI_RESET);
					break;
				}

			} while(turno!=0);

		} while(true);

		System.out.println("Fin de la partida");
	}

	static int cambioTurno(int turno) {
		if(turno==1)
			return 2;
		else
			return 1;
	}

	static int cambioTurnoEjercito(int turno) {
		if(turno==1)
			return 2;
		else
			return 0;
	}

	static void pedirFilas() {
		System.out.println("¿En que fila desea colocar al soldado?: ");
		System.out.println("Fila: (0-7)");
	}

	static void pedirColumnasPj1(){
		System.out.println("¿En que columna desea colocar al soldado?: ");
		System.out.println("Columna: (0-1)");
	}

	static void pedirColumnasPj2(){
		System.out.println("¿En que columna desea colocar al soldado?: ");
		System.out.println("Columna: (6-7)");
	}

	static boolean comprobarPosInicialPj1(int fila, int columna) {
		if ((fila<0 || fila>7) || (columna<0 || columna>1)) {
			System.out.println(Equipo.ANSI_RED +"Tiene que ser una posición válida"+ Equipo.ANSI_RESET);
			return false;
		}
		return true;	 
	}

	static boolean comprobarPosInicialPj2(int fila, int columna) {
		if ((fila<0 || fila>7) || (columna<6 || columna>7)) {
			System.out.println(Equipo.ANSI_RED +"Tiene que ser una posición válida"+ Equipo.ANSI_RESET);
			return false;
		}
		return true;	 
	}

	static boolean comprobarSaldoParaPj(Equipo e, Personaje p) {
		if (!e.saldoSuficiente(p)) {
			return false;
		}
		return true;
	}

}