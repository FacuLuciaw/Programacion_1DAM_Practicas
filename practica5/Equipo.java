package practica5;

import java.util.Arrays;

public class Equipo {

	private int saldo = 50;
	Personaje ejercito[]=new Personaje[0];

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	

	public boolean saldoSuficiente(Personaje p) {
		if(getSaldo()>=p.getCoste())
			return true;
		else
			return false;
	}

	public boolean vidaPochaEjercito() {
		for(int i=0; i<ejercito.length;i++) {
			if(ejercito[i].getVidaActual() != ejercito[i].getVidaInicial()) 
				return true;	
		}
		return false;
	}

	public void curar() {
		int num;
		for(int i=0; i<ejercito.length;i++) {
			if(ejercito[i].getVidaActual() != ejercito[i].getVidaInicial()) {
				num=(int) (Math.random() * (ejercito[i].getVidaInicial() + 1));
				
				if (ejercito[i].getVidaActual()+num>=ejercito[i].vidaInicial) 
					ejercito[i].setVidaActual(ejercito[i].getVidaInicial());
				
				else 
					ejercito[i].setVidaActual(ejercito[i].getVidaActual()+num);
				
			}
			else
				continue;
		}
	}

	public void insertarPjEjercito(Personaje p) {
		if (saldoSuficiente(p)) {
			ejercito=Arrays.copyOf(ejercito, ejercito.length+1);
			ejercito[ejercito.length-1]=p;
		}

	}

	public void infoEjercito() {
		for(int i=0; i<ejercito.length; i++) 
			System.out.println(ejercito[i].nombre);
	}
	
	public int getLenght() {
		return ejercito.length;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public boolean ejercitoVacio() {
		return ejercito.length==0;
	}

}
