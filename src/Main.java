
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//MAZO
		
			String mazoPath = "./src/superheroes.json";
			Mazo mazo = new Mazo();
			mazo.importarMazo(mazoPath);
			
		//JUGADORES
			
			Jugador primerJugador = new Jugador("Juan");
			Jugador segundoJugador = new Jugador("María");
	     
			
		//JUEGO
			
			int maximoRondas = 300;
			Juego juego = new Juego(primerJugador, segundoJugador, mazo, maximoRondas);
			
			juego.jugar();
			
			System.out.println(juego.getRegistroPartidas());
	     
	}

}
