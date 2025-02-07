package practica5;

public class Personaje{

	protected String nombre;
	protected int coste;
	protected int jugador;
	protected int ataqueMax;
	protected int defMax;
	protected int vidaInicial;
	protected int radioAtaque; 
	protected int vidaActual;
	protected String color;




	Personaje (int jugador){
		this.jugador=jugador;
		setColor(jugador);
	}


	public String pjEnTablero() {
		String vida = String.format("%02d", vidaActual);
		return getColor() + nombre.charAt(0)+"("+vida+")" + Equipo.ANSI_RESET;
	}

	public void infoPj() {
		System.out.println(nombre + ": " + "\nCoste: " + coste + "\nAtaque Máximo: " + ataqueMax +
				"\nDefensa Máxima: " + defMax + "\nVida Inicial: " + vidaInicial + "\nRadio de Ataque: " + radioAtaque +
				"\n----------------------------------------------------------------");
	}

	public int agredir() {
		return 0;
	}

	public int defensa(){
		return 0;
	}

	public String getColor() {
		return color;
	}


	public void setColor(int jugador) {
		if (jugador==1)
			color=Equipo.ANSI_RED;
		else
			color=Equipo.ANSI_BLUE;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public int getAtaqueMax() {
		return ataqueMax;
	}

	public void setAtaqueMax(int ataqueMax) {
		this.ataqueMax = ataqueMax;
	}

	public int getDefMax() {
		return defMax;
	}

	public void setDefMax(int defMax) {
		this.defMax = defMax;
	}

	public int getVidaInicial() {
		return vidaInicial;
	}

	public void setVidaInicial(int vidaInicial) {
		this.vidaInicial = vidaInicial;
	}

	public int getRadioAtaque() {
		return radioAtaque;
	}

	public void setRadioAtaque(int radioAtaque) {
		this.radioAtaque = radioAtaque;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}	
}
