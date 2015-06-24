package classes;

public class Artigo extends Exemplar {

	public Artigo(int codigo) {
		super(codigo);
		// TODO Auto-generated constructor stub
	}

	private String autor;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}	
}
