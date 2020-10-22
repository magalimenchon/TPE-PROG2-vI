public class Jugador {
	//ATRIBUTOS
	private String nombre;
	private Mazo cartas;
	
	//CONSTRUCTOR
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new Mazo();
	}
	
	//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	
	
	//FUNCIONALIDADES
	//pone la carta al final del mazo
	public void moverAlFinalDelMazo(Carta carta){
		cartas.quitarCarta(carta);
			cartas.addCarta(carta);
	}
	
	//Agregar una carta a su mazo
	public void addCarta(Carta nuevaCarta){
		cartas.addCarta(nuevaCarta);
	}
	
	//Quita la carta del mazo
	public void quitarCarta(Carta carta){
			cartas.quitarCarta(carta);	//-----Son iguales?
	}
	
	//Retorna cantidad de cartas del jugador
	public int getTotalCartas(){	//-----Son iguales?
		return cartas.getTamañoMazo();
	}
	//Elije atributo aleatorio
	public String elegirAtributo(Carta carta){//----ver
		return carta.getAtributoAletorio();
	}
	//Tomar primera carta
	public Carta tomarCarta(){
		return cartas.getPrimeraCarta();
	}
	
	
	//OVERRIDES	
	@Override
	public String toString() {
		return nombre;
	}


	
}
