package practica5;

public class Arquero extends Personaje {

	public Arquero(int jugador) {
		super(jugador);
		nombre="Arquero";
		coste=15;
		ataqueMax=10;
		defMax=5;
		vidaInicial=10;
		radioAtaque=3;
		vidaActual=10;
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
