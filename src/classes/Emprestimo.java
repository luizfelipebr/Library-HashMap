package classes;

import java.util.List;

import org.joda.time.DateTime;

import bancosdedados.Bd_Exemplares;

public class Emprestimo {
	private List<Exemplar> exemplares;
	private Cliente cliente;
	private DateTime dtEmprestimo;
	private DateTime dtDevolucao;
	private Bd_Exemplares bd_Exemplares;
	
	public Emprestimo(Bd_Exemplares bd_Exemplares){
		this.bd_Exemplares = bd_Exemplares;
	}
	
	public List<Exemplar> getExemplares() {
		return exemplares;
	}
	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public DateTime getDtEmprestimo() {
		return dtEmprestimo;
	}
	public void setDtEmprestimo(DateTime dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}
	public DateTime getDtDevolucao() {
		return dtDevolucao;
	}
	public void setDtDevolucao(DateTime dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}
	public void adicionarExemplar(Exemplar exemplar) throws Exception{
		if(bd_Exemplares.exemplarDisponivelEmprestimo(exemplar) > 0){
			exemplares.add(exemplar);
		}else throw new Exception("Não há exemplares desse tipo em estoque");
	}
	public void removerExemplar(Exemplar exemplar){
		exemplares.remove(exemplar);
	}
	public void confirmarDevolucao(){
		Bd_Exemplares bd_Exemplares = new Bd_Exemplares();
		for (Exemplar exemplar : exemplares){
			bd_Exemplares.realizarDevolucao(exemplar);
		}
		dtDevolucao = DateTime.now();
	}
	public void confirmarEmprestimo() throws Exception{
		for (Exemplar exemplar : exemplares){
			if(!bd_Exemplares.realizarEmprestimo(exemplar)){
				throw new Exception("O empréstimo não pôde ser realizado. Exemplar: "+exemplar.getNome());
			}
		}
		dtEmprestimo = DateTime.now();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((dtEmprestimo == null) ? 0 : dtEmprestimo.hashCode());
		result = prime * result
				+ ((exemplares == null) ? 0 : exemplares.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dtEmprestimo == null) {
			if (other.dtEmprestimo != null)
				return false;
		} else if (!dtEmprestimo.equals(other.dtEmprestimo))
			return false;
		if (exemplares == null) {
			if (other.exemplares != null)
				return false;
		} else if (!exemplares.equals(other.exemplares))
			return false;
		return true;
	}
	
}
