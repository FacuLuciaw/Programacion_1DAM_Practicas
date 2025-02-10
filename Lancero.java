package practica5;

public class Lancero extends Personaje {

	public Lancero(int jugador) {
		super(jugador);
		nombre="Lancero";
		coste=5;
		ataqueMax=10;
		defMax=5;
		vidaInicial=10;
		radioAtaque=2;
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
