package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCarros {
	private Scanner scS, scN;
	private ArrayList<Carro> carros;
	
	public GerenciaCarros(ArrayList<Carro> carros) {
		this.scS = new Scanner(System.in);
		this.scN = new Scanner(System.in);
		this.carros = carros;
	}
	
	public void incluir() {
		System.out.println("--=[Incluir Carro]=--");
		Carro carro = new Carro();
		
		System.out.println("Digite os dados a seguir: ");
		System.out.println("- Marca: ");
		carro.setMarca(scS.nextLine());
		System.out.println("- Modelo: ");
		carro.setModelo(scS.nextLine());
		System.out.println("- Ano fabricação: ");
		carro.setAnoFabricacao(scN.nextInt());
		System.out.println("- Ano modelo: ");
		carro.setAnoModelo(scN.nextInt());
		System.out.println("- Capac. Porta-malas: ");
		carro.setCapPortaMalas(scN.nextInt());
		System.out.println("- Qtd. Portas: ");
		carro.setQtdPortas(scN.nextInt());
		System.out.println("- Qtd. Poltronas: ");
		carro.setQtdBancos(scN.nextInt());
		System.out.println("- Preço R$");
		carro.setPreco(scN.nextFloat());
		
		carros.add(carro);
		
		System.out.println("Carro inserido com sucesso.");
	}
	
	public void excluir() {
		System.out.println("--=[Excluir Carro]=--");
		
		if(carros.isEmpty())
			System.out.println("Não existem carros cadastrados.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja excluir: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < carros.size())) {
				System.out.println("-[Dados do Carro]-");
				imprime(carros.get(pos));
				System.out.println("Confirma a exclusão? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					carros.remove(pos);
					
					System.out.println("Carro excluído com sucesso.");
				}
				else
					System.out.println("Carro não excluído.");
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void alterar() {
		System.out.println("--=[Alterar Carro]=--");
		
		if(carros.isEmpty())
			System.out.println("Não existem carros cadastrados.");
		else {
			int pos, resp;
			
			System.out.println("Digite a posição que deseja alterar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < carros.size())) {
				System.out.println("-[Dados do Carro]-");
				imprime(carros.get(pos));
				System.out.println("Confirma a alteração? (1-sim/2-não)");
				resp = scN.nextInt();
				
				if(resp == 1) {
					System.out.println("Digite os novos dados para: ");
					Carro carro = carros.get(pos);
					
					System.out.println("- Marca: ");
					carro.setMarca(scS.nextLine());
					System.out.println("- Modelo: ");
					carro.setModelo(scS.nextLine());
					System.out.println("- Ano fabricação: ");
					carro.setAnoFabricacao(scN.nextInt());
					System.out.println("- Ano modelo: ");
					carro.setAnoModelo(scN.nextInt());
					System.out.println("- Capac. Porta-malas: ");
					carro.setCapPortaMalas(scN.nextInt());
					System.out.println("- Qtd. Portas: ");
					carro.setQtdPortas(scN.nextInt());
					System.out.println("- Qtd. Poltronas: ");
					carro.setQtdBancos(scN.nextInt());
					System.out.println("- Preço R$");
					carro.setPreco(scN.nextFloat());
					
					System.out.println("Carro alterado com sucesso.");
				}
				else
					System.out.println("Carro não alterado.");
			}
			else
				System.out.println("Posição inválida!");
		}
		
	}
	
	public void consultar() {
		System.out.println("--=[Consultar Carro]=--");
		
		if(carros.isEmpty())
			System.out.println("Não existem carros cadastrados.");
		else {
			int pos;
			
			System.out.println("Digite a posição que deseja consultar: ");
			pos = scN.nextInt();
			
			if((pos >= 0) && (pos < carros.size())) {
				System.out.println("-[Dados do Carro]-");
				imprime(carros.get(pos));
			}
			else
				System.out.println("Posição inválida!");
		}
	}
	
	public void relatorio(){
		System.out.println("--=[Relatório de Carros]=--");
		
		if(carros.isEmpty())
			System.out.println("Não existem carros cadastrados.");
		else {
			for(Carro m : carros) {
				imprime(m);
				System.out.println("----------");
			}
		}
		
	}
	
	private void imprime(Carro m) {
		System.out.println("- Marca                   : " + m.getMarca());
		System.out.println("- Modelo                  : " + m.getModelo());
		System.out.println("- Ano fabricação          : " + m.getAnoFabricacao());
		System.out.println("- Ano modelo              : " + m.getAnoModelo());
		System.out.println("- Capac. carga porta-malas: " + m.getCapPortaMalas());
		System.out.println("- Qtdade Portas           : " + m.getQtdPortas());
		System.out.println("- Qtdade Poltronas        : " + m.getQtdBancos());
		System.out.println("- Preço                   : " + m.getPreco());
	}
}
