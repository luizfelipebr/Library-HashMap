package principal;

import javax.swing.JOptionPane;

import bancosdedados.*;
import classes.*;

public class Main {

	public static void main(String[] args) {
		
		BD_emprestimos bd_emprestimos = new BD_emprestimos();
		Bd_Exemplares bd_Exemplares = new Bd_Exemplares();
		
		Exemplar exemplar1 = new Exemplar(1001);
		exemplar1.setNome("O Monge e o Executivo");
		exemplar1.setTipo("Auto Ajuda");
		for (int i = 0; i < 5; i++) {
			bd_Exemplares.inserirExemplarArmazenamento(exemplar1);
		}
		

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

		switch (option) {
		case 1:
			int idExemplar = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o c�digo do exemplar: "));
			try {
				Exemplar exemplar = bd_Exemplares.getExemplar(idExemplar);
				int qntdade = bd_Exemplares
						.exemplarDisponivelEmprestimo(exemplar);
				String result = "C�digo: " + exemplar.getCodigo() + " Nome: "
						+ exemplar.getNome() + " Tipo: " + exemplar.getTipo()
						+ "\nQuantidade: " + qntdade;
				JOptionPane.showMessageDialog(null, result);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Exemplar inexistente!");
			}

			break;
		case 2:
			bd_emprestimos.totalExemplaresPodemSerEmprestados(null);
			break;
		case 3:

			break;

		default:
			break;
		}


	}

}
