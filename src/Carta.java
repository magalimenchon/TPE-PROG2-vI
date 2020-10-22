import java.util.ArrayList;


public class Carta {
	//ATRIBUTOS
	private String nombre;
	private ArrayList<Atributo> atributos;
	
	//CONSTRUCTOR
	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<Atributo>();
	}
	
	//GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Atributo> getAtributos() { 	//------------REVISAR
		return new ArrayList<>(this.atributos);
	}


	//FUNCIONALIDADES
	
	//Agregar un atributo al conjunto de atributos de la carta
	public void addAtributo(Atributo nuevoAtributo){ //------------------ADD O AGREGAR?
		if(!this.contieneAtributo(nuevoAtributo))
				atributos.add(nuevoAtributo);
	}
	
	//Retorna cuantos atributos tiene la carta
	public int getCantidadAtributos() {
		return atributos.size();	//-------------es necesario o uso directamente el size?
	}
	
	//Selecciona un atributo aleatorio, dentro de la cantidad de atributos que tiene la carta
	public String getAtributoAletorio() {	//----------------DEVUELVO ATRIBUTO O STRING DEL NOMBRE?
		
		int pos = (int) Math.floor((Math.random()* atributos.size()));
		//casting porque random retorna double y la posición debe ser int
		
		return atributos.get(pos).getNombre();
	}
	
	//Retorna si la carta contiene un atributo
	public boolean contieneAtributo(Atributo atributoBuscado) {
		return atributos.contains(atributoBuscado);	//--------------ver si este metodo es necesario
	}
	
	//Busca un atributo por nombre en el conjunto de atributos
	public Atributo getAtributoPorNombre(String nombreBuscado) {//---ver si es necesario
		
		for (int i = 0; i < atributos.size(); i++) {
			Atributo atributoActual = atributos.get(i);
			if(atributoActual.getNombre().equals(nombreBuscado)) {
				return atributoActual;
			}
		}
		return null;
	}
	
	
	//son cartas iguales si tienen la misma cantidad y tipos de atributos
	public boolean cartasIguales(Carta cartaAComparar){		//----VER NOMBRE, NO SON IDENTICAS
		if (this.getCantidadAtributos() == cartaAComparar.getCantidadAtributos()) {
			//si tienen la misma cantidad de atributos
			if (atributos.containsAll(cartaAComparar.getAtributos()))
				//si la carta tiene todos los atributos de la otra
				      return true;
		}
	    return false;
	}
	
	//OVERRIDES
	@Override
	public String toString(){
		return this.nombre;
	}
	@Override	//porque en mazo uso contains en método contieneCarta
	public boolean equals(Object objeto) {
		Carta otroCarta =(Carta) objeto;
		try {
			return this.getNombre().equals(otroCarta.getNombre());
		}
		catch(Exception e){
			return false;
		}
	}
	
	
}
