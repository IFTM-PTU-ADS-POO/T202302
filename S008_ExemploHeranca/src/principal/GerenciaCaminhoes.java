package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCaminhoes {
	private Scanner scS, scN;
	private ArrayList<Caminhao> caminhoes;
	
	public GerenciaCaminhoes(ArrayList<Caminhao> caminhoes) {
		this.scS = new Scanner(System.in);
		this.scN = new Scanner(System.in);
		this.caminhoes = caminhoes;
	}
	
	public void incluir() {
		System.out.println("--=[Incluir Caminhão]=--");
		Caminhao caminhao = new Caminhao();
		
		System.out.println("Digite os dados a seguir: ");
		System.out.println("- Marca: ");
		caminhao.setMarca(scS.nextLine());
		System.out.println("- Modelo: ");
		caminhao.setModelo(scS.nextLine());
		System.out.println("- Ano fabricação: ");
		caminhao.setAnoFabricacao(scN.nextInt());
		System.out.println("- Ano modelo: ");
		caminhao.setAnoModelo(scN.nextInt());
		System.out.println("- Capac. Porta-malas: ");
		caminhao.setCapacidadeDeCarga(scN.nextFloat());
		System.out.println("- Preço R$");
		caminhao.setPreco(scN.nextFloat());
		
		caminhoes.add(caminhao);
		
		System.out.println("Caminhão inserido com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--=[Excluir Caminhão]=--");
		
		if(caminhoes.isEmpty())
			System.out.println("Não existem caminhão cadastrados.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja excluir: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < caminhoes.size())) {
				System.out.println("-[Dados do Caminhão]-");
				imprime(caminhoes.get(pos));
				System.out.println("Confirma a exclusão? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					caminhoes.remove(pos);
					
					System.out.println("Caminhão excluído com sucesso.");
				}
				else
					System.out.println("Caminhão não excluído.");
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void alterar() {
		System.out.println("--=[Alterar Caminhão]=--");
		
		if(caminhoes.isEmpty())
			System.out.println("Não existem caminhões cadastrados.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja alterar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < caminhoes.size())) {
				System.out.println("-[Dados do Caminhão]-");
				imprime(caminhoes.get(pos));
				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("Digite os novos dados para: ");
					Caminhao caminhao = caminhoes.get(pos);
					
					System.out.println("- Marca: ");
					caminhao.setMarca(scS.nextLine());
					System.out.println("- Modelo: ");
					caminhao.setModelo(scS.nextLine());
					System.out.println("- Ano fabricação: ");
					caminhao.setAnoFabricacao(scN.nextInt());
					System.out.println("- Ano modelo: ");
					caminhao.setAnoModelo(scN.nextInt());
					System.out.println("- Capac. Porta-malas: ");
					caminhao.setCapacidadeDeCarga(scN.nextFloat());
					System.out.println("- Preço R$");
					caminhao.setPreco(scN.nextFloat());
					
					System.out.println("Caminhão alterado com sucesso.");
				}
				else
					System.out.println("Caminhão não alterado.");
			}
			else
				System.out.println("Posição inválida!");
		}
		
	}
	
	public void consultar() {
		System.out.println("--=[Consultar Caminhão]=--");
		
		if(caminhoes.isEmpty())
			System.out.println("Não existem caminhões cadastrados.");
		else {
			int pos;
			
			System.out.println("Digite a posição que deseja consultar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < caminhoes.size())) {
				System.out.println("-[Dados do Caminhão]-");
				imprime(caminhoes.get(pos));
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void relatorio(){
		System.out.println("--=[Relatório de Carros]=--");
		
		if(caminhoes.isEmpty())
			System.out.println("Não existem carros cadastrados.");
		else {
			for(Caminhao m : caminhoes) {
				imprime(m);
				System.out.println("----------");
			}
		}
		
	}
	
	private void imprime(Caminhao m) {
		System.out.println("- Marca              : " + m.getMarca());
		System.out.println("- Modelo             : " + m.getModelo());
		System.out.println("- Ano fabricação     : " + m.getAnoFabricacao());
		System.out.println("- Ano modelo         : " + m.getAnoModelo());
		System.out.println("- Capacidade de carga: " + m.getCapacidadeDeCarga());
		System.out.println("- Preço              : " + m.getPreco());
	}
}
