package practica5;

public class Caballero extends Personaje {

	public Caballero(int jugador) {
		super(jugador);
		nombre="Caballero";
		coste=50;
		ataqueMax=15;
		defMax=0;
		vidaInicial=20;
		radioAtaque=2;
		vidaActual=1;
	}
	
	@Override
	public void infoPj() {
		super.infoPj();
	}
	
	@Override
	public int agredir() {
		return (int) (Math.random() * (ataqueMax + 1));
	}
	
	@Override
	public int defensa(){
		return (int) (Math.random() * (defMax + 1));
	}
	
}
