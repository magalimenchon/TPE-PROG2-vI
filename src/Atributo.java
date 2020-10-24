
public class Atributo implements Comparable<Atributo>{

	//ESTADO
	
	private String nombre;
	private int valorNumerico;
	
	//CONSTRUCTOR
	
	public Atributo(String nombre, int valorNumerico) {
		this.nombre = nombre;
		this.valorNumerico = valorNumerico;
	}
	
	//GETTERS & SETTERS
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValorNumerico() {
		return valorNumerico;
	}


	public void setValorNumerico(int valorNumerico) {
		this.valorNumerico = valorNumerico;
	}
	
	
	//COMPORTAMIENTO

	//OVERRIDES
	
	@Override	//Redefine el llamado al objeto.
	public String toString(){
		return this.getNombre() + " " + this.getValorNumerico();
	}
	
	@Override	//Compara los valores de un atributo con otro.
	public int compareTo(Atributo otroAtributo) {
		return this.getValorNumerico() - otroAtributo.getValorNumerico();
	}
	
	@Override	//Defino la noción de iguales porque en Carta uso contains en método contieneAtributo.
	public boolean equals(Object objeto) {
		Atributo otroAtributo =(Atributo) objeto;
		try {
			return this.getNombre().equals(otroAtributo.getNombre());
		}
		catch(Exception e){
			return false;
		}
	}
	
	
	
}
