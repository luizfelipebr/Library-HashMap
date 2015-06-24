package bancosdedados;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import classes.Exemplar;

public class Bd_Exemplares {
	private HashMap<Character, Set<Exemplar>> indiceExemplaresLetra;
	private HashMap<Exemplar, Integer> armazenamentoExemplares;

	public Bd_Exemplares(HashMap<Exemplar, Integer> armazenamentoExemplares) {
		super();
		this.armazenamentoExemplares = armazenamentoExemplares;
		Set<Exemplar> exemplares = armazenamentoExemplares.keySet();
		for (Exemplar exemplar : exemplares) {
			inserirExemplarIndice(exemplar);
		}
	}

	public Bd_Exemplares() {
		this.indiceExemplaresLetra = new HashMap<Character, Set<Exemplar>>();
		this.armazenamentoExemplares = new HashMap<Exemplar, Integer>();
	}

	public Exemplar getExemplar(int id) throws NullPointerException {
		Exemplar exem = null;
		for (Exemplar exemplar : armazenamentoExemplares.keySet()) {
			if (exemplar.getCodigo() == id)
				exem = exemplar;
		}
		if (exem == null)
			throw new NullPointerException();
		return exem;
	}

	public HashMap<Character, Set<Exemplar>> getIndiceExemplaresLetra() {
		return indiceExemplaresLetra;
	}

	public void setIndiceExemplaresLetra(
			HashMap<Character, Set<Exemplar>> indiceExemplaresLetra) {
		this.indiceExemplaresLetra = indiceExemplaresLetra;
	}

	public HashMap<Exemplar, Integer> getArmazenamentoExemplares() {
		return armazenamentoExemplares;
	}

	public void setArmazenamentoExemplares(
			HashMap<Exemplar, Integer> armazenamentoExemplares) {
		this.armazenamentoExemplares = armazenamentoExemplares;
	}

	public void inserirExemplarIndice(Exemplar exemplar) {
		buscarListaExemplares(
				exemplar.getNome().replace(" ", "").toUpperCase().charAt(0))
				.add(exemplar);
	}

	public void inserirExemplarArmazenamento(Exemplar exemplar) {
		if (!exemplarJaEstaIndexado(exemplar)) {
			inserirExemplarIndice(exemplar);
			armazenamentoExemplares.put(exemplar, 1);
		} else {
			int qntdade = armazenamentoExemplares.get(exemplar);
			qntdade++;
			armazenamentoExemplares.put(exemplar, qntdade);
		}

	}

	public boolean exemplarJaEstaIndexado(Exemplar exemplar) {
		return indiceExemplaresLetra.containsKey(exemplar.getNome()
				.replace(" ", "").toUpperCase().charAt(0));
	}

	public Set<Exemplar> buscarListaExemplares(char letra) {
		if (indiceExemplaresLetra.get(letra) == null){
			indiceExemplaresLetra.put(letra, new HashSet<Exemplar>());
		}
		return indiceExemplaresLetra.get(letra);
	}

	public int exemplarDisponivelEmprestimo(Exemplar exemplar) {
		return armazenamentoExemplares.get(exemplar);
	}

	public boolean realizarEmprestimo(Exemplar exemplar) {
		if (exemplarDisponivelEmprestimo(exemplar) > 0) {
			int qntdade = armazenamentoExemplares.get(exemplar);
			qntdade--;
			armazenamentoExemplares.put(exemplar, qntdade);
			return true;
		} else
			return false;
	}

	public void realizarDevolucao(Exemplar exemplar) {
		inserirExemplarArmazenamento(exemplar);
	}

	public void removerExemplar(Exemplar exemplar) {
		buscarListaExemplares(exemplar.getNome().replace(" ", "").charAt(0))
				.remove(exemplar);
		armazenamentoExemplares.remove(exemplar);
	}

}
