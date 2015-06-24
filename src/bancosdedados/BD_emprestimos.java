package bancosdedados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import classes.Cliente;
import classes.Emprestimo;

public class BD_emprestimos {

	private HashMap<Cliente, List<Emprestimo>> armazenamentoEmprestimos;

	public BD_emprestimos() {
		this.armazenamentoEmprestimos = new HashMap<Cliente, List<Emprestimo>>();
	}

	public BD_emprestimos(
			HashMap<Cliente, List<Emprestimo>> armazenamentoEmprestimos) {
		this.armazenamentoEmprestimos = armazenamentoEmprestimos;
	}

	public void adicionarEmprestimo(Emprestimo emprestimo) {
		if (buscarEmprestimos(emprestimo.getCliente()) != null) {
			buscarEmprestimos(emprestimo.getCliente()).add(emprestimo);
		}else{
			armazenamentoEmprestimos.put(emprestimo.getCliente(), new ArrayList<Emprestimo>());
			adicionarEmprestimo(emprestimo);
		}
		
	}

	public List<Emprestimo> buscarEmprestimos(Cliente cliente) {
		return armazenamentoEmprestimos.get(cliente);
	}

	public int totalExemplaresPodemSerEmprestados(Cliente cliente) {
		return cliente.getMaxDeExemplares();
	}

	public void devolverEmprestimo(Emprestimo emprestimo) {
		List<Emprestimo> clienteEmprestimos = buscarEmprestimos(emprestimo
				.getCliente());
		for (int i = 0; i < clienteEmprestimos.size(); i++) {
			if (clienteEmprestimos.get(i).equals(emprestimo)
					&& clienteEmprestimos.get(i).getDtDevolucao() == null) {
				clienteEmprestimos.remove(clienteEmprestimos.get(i));
			}
		}
	}

}
