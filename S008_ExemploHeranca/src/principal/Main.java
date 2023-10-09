package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scN = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);
		
		ArrayList<Moto> motos = new ArrayList<>();
		ArrayList<Carro> carros = new ArrayList<>();
		ArrayList<Caminhao> caminhoes = new ArrayList<>();
		
		GerenciaMotos gm = new GerenciaMotos(motos);
		GerenciaCarros gc = new GerenciaCarros(carros);
		GerenciaCaminhoes gca = new GerenciaCaminhoes(caminhoes);
		
		int op, opMoto, opCarro, opCami;
		
		do {
			System.out.println("---===[Cadatro de Veículos]===---");
			System.out.println("1 - Moto");
			System.out.println("2 - Carro");
			System.out.println("3 - Caminhão");
			System.out.println("4 - sair");
			System.out.println("Opção: ");
			op = scN.nextInt();
			
			switch(op) {
				case 1:
					do {
						System.out.println("-=[Motos]=-");
						System.out.println("1 - Incluir");
						System.out.println("2 - Excluir");
						System.out.println("3 - Alterar");
						System.out.println("4 - Consultar");
						System.out.println("5 - Relatório");
						System.out.println("6 - voltar ao menu anterior");
						System.out.println("Opção: ");
						opMoto = scN.nextInt();
						
						switch(opMoto) {
							case 1:
								gm.incluir();
								break;
							case 2:
								gm.excluir();
								break;
							case 3:
								gm.alterar();
								break;
							case 4:
								gm.consultar();
								break;
							case 5:
								gm.relatorio();
								break;
						}
						
					}while(opMoto != 6);
					break;
				case 2:
					do {
						System.out.println("-=[Carros]=-");
						System.out.println("1 - Incluir");
						System.out.println("2 - Excluir");
						System.out.println("3 - Alterar");
						System.out.println("4 - Consultar");
						System.out.println("5 - Relatório");
						System.out.println("6 - voltar ao menu anterior");
						System.out.println("Opção: ");
						opCarro = scN.nextInt();
						
						switch(opCarro) {
							case 1:
								gc.incluir();
								break;
							case 2:
								gc.excluir();
								break;
							case 3:
								gc.alterar();
								break;
							case 4:
								gc.consultar();
								break;
							case 5:
								gc.relatorio();
								break;
						}
						
					}while(opCarro != 6);
					break;
				case 3:
					do {
						System.out.println("-=[Caminhão]=-");
						System.out.println("1 - Incluir");
						System.out.println("2 - Excluir");
						System.out.println("3 - Alterar");
						System.out.println("4 - Consultar");
						System.out.println("5 - Relatório");
						System.out.println("6 - voltar ao menu anterior");
						System.out.println("Opção: ");
						opCami = scN.nextInt();
						
						switch(opCami) {
							case 1:
								gca.incluir();
								break;
							case 2:
								gca.excluir();
								break;
							case 3:
								gca.alterar();
								break;
							case 4:
								gca.consultar();
								break;
							case 5:
								gca.relatorio();
								break;
						}
						
					}while(opCami != 6);
			}
		}while(op != 4);
		
		scN.close();
		scS.close();
	}

}
