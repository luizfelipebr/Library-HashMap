package classes;

public class Cliente {
	private int codigo;
	private String nome;
	private int idade;
	private String telefone;
	private String matricula;
	private int maxDeExemplares;
	
	public Cliente(){
		if(this.getClass().getName() == Professor.class.getName()){
			this.maxDeExemplares = 6;
		}else{
			this.maxDeExemplares = 3;
		}
	}
	
	public int getMaxDeExemplares() {
		return maxDeExemplares;
	}
	public void setMaxDeExemplares(int maxDeExemplares) {
		this.maxDeExemplares = maxDeExemplares;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
