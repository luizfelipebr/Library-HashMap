package classes;

public class Livro extends Exemplar{

	public Livro(int codigo) {
		super(codigo);
		// TODO Auto-generated constructor stub
	}
	private String autor;
	private String editora;
	private int edicao;
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
		
}
