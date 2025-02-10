package practica5;

public class Soldado extends Personaje {

	public Soldado(int jugador) {
		super(jugador);
		nombre="Soldado";
		coste=10;
		ataqueMax=10;
		defMax=10;
		vidaInicial=10;
		radioAtaque=1;
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
