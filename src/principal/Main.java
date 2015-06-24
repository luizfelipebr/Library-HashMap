package principal;

import javax.swing.JOptionPane;

import bancosdedados.*;
import classes.*;

public class Main {
	private static BD_emprestimos bd_emprestimos = new BD_emprestimos();
	private static Bd_Exemplares bd_Exemplares = new Bd_Exemplares();
	private static Cliente cliente;

	public static void main(String[] args) {

		Exemplar exemplar1 = new Exemplar(1001);
		exemplar1.setNome("O Monge e o Executivo");
		exemplar1.setTipo("Auto Ajuda");
		bd_Exemplares.inserirExemplarArmazenamento(exemplar1);
		bd_Exemplares.inserirExemplarArmazenamento(exemplar1);
		bd_Exemplares.inserirExemplarArmazenamento(exemplar1);

		exemplar1 = new Exemplar(1002);
		exemplar1.setNome("A Arte da Guerra");
		exemplar1.setTipo("Auto Ajuda");
		bd_Exemplares.inserirExemplarArmazenamento(exemplar1);
		bd_Exemplares.inserirExemplarArmazenamento(exemplar1);

		cliente = new Aluno(2001);
		cliente.setIdade(25);
		cliente.setNome("Luiz Felipe");

		menu();

	}

	protected static void menu() {
		String menu = "Informe o n�mero da tarefa que deseja efetuar:\n\n"
				+ "1 � Consultar Disponibilidade de Exemplares\n"
				+ "2 � Consultar se o cliente pode fazer empr�stimo\n"
				+ "3 � Realizar Empr�stimo\n"
				+ "4 � Realizar Devolu��o\n"
				+ "5 � Consultar Exemplares por Nome\n"
				+ "6 � Consultar Exemplares por Letra Inicial\n"
				+ "7 � Consultar Empr�stimos n�o realizados na data\n"
				+ "8 � Consultar Empr�stimos a serem realizado na data de utiliza��o do programa\n"
				+ "9 � Consultar se Cliente tem empr�stimo em atraso\n"
				+ "10 � Sair\n";
		Integer option = Integer.valueOf(JOptionPane.showInputDialog(menu));
		String result;

		switch (option) {
		case 1:
			int idExemplar = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o c�digo do exemplar: "));
			try {
				Exemplar exemplar = bd_Exemplares.getExemplar(idExemplar);
				int qntdade = bd_Exemplares
						.exemplarDisponivelEmprestimo(exemplar);
				result = "C�digo: " + exemplar.getCodigo() + "\nNome: "
						+ exemplar.getNome() + "\nTipo: " + exemplar.getTipo()
						+ "\nQuantidade: " + qntdade;
				JOptionPane.showMessageDialog(null, result);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Exemplar inexistente!");
			}
			menu();
			break;
		case 2:
			int idCliente = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o c�digo do Cliente: "));
			try {
				Cliente cliente2 = new Aluno(idCliente);
				int total = bd_emprestimos
						.totalExemplaresPodemSerEmprestados(cliente2);
				result = "Total de empr�stimos poss�veis: "
						+ cliente.getMaxDeExemplares()
						+ "\nAinda podem ser emprestados: " + total;
				JOptionPane.showMessageDialog(null, result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			menu();
			break;
		case 3:
			int codCliente = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o c�digo do Cliente: "));
			int codExemplar = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o c�digo do exemplar: "));
			try {
				Emprestimo emprestimo = new Emprestimo(bd_Exemplares);
				emprestimo.setCliente(new Aluno(codCliente));
				emprestimo.adicionarExemplar(bd_Exemplares
						.getExemplar(codExemplar));
				int confirmacao = Integer.parseInt(JOptionPane
						.showInputDialog("Confirmar empr�stimo?"));
				if (confirmacao == 1) {
					emprestimo.confirmarEmprestimo();
					JOptionPane
							.showMessageDialog(null, "Emprestimo realizado!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			menu();
			break;
		case 10:
			break;
		default:
			menu();
			break;
		}
	}

}
