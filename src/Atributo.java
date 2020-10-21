
public class Atributo implements Comparable<Atributo>{

	//ATRIBUTOS
	
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
	
	//FUNCIONALIDADES


	//OVERRIDES
	@Override
	public String toString(){
		return this.nombre + this.valorNumerico;
	}
	
	@Override	//compara los valores de un atributo con otro
	public int compareTo(Atributo otroAtributo) {
		return this.getValorNumerico() - otroAtributo.getValorNumerico();
	}
	
	@Override	//porque en carta uso contains en método contieneAtributo
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
