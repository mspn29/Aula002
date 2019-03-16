package listener;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Pedido;

public class PedidoListener {
	
	private static Scanner sc;
	
	static int codigoPedido = 0;
	
	static List<Pedido> pedidos = new ArrayList<Pedido>();

	public static void main(String[] args) {
		principal();
	}
	
	public static void principal(){
		System.out.println("--- MENU PRINCIPAL ---");
		System.out.println("1 - LISTAR PEDIDOS ---");
		System.out.println("2 - INCLUIR PEDIDOS --");
		System.out.println("3 - ALTERAR PEDIDOS --");
		System.out.println("4 - DELETAR PEDIDOS --");
		System.out.println("5 - SAIR -------------");
		System.out.println("----------------------");
		
		System.out.print("Digite a opção desejada: ");
		
		try{
			
			sc = new Scanner(System.in);
			
			int opcao = sc.nextInt();
			
			verificaOpcao(opcao);
			
		} catch (InputMismatchException e) {
			System.err.println("Digite um valor numérico! ");
			System.out.println("");
			principal();
		}
		
	}
	
	public static void verificaOpcao(int opcao){
		
		boolean opcaoValida = false;
		
		switch (opcao) {
		
			case 1:
				
				opcaoValida = true;
				listar();
				
				break;
				
			case 2:
				
				opcaoValida = true;
				incluir();
				
				break;
				
			case 3:
				
				opcaoValida = true;
				alterar();
				
				break;
				
			case 4:
				
				opcaoValida = true;
				excluir();
				
				break;
				
			case 5:
				
				opcaoValida = true;
				sair();
				
				break;
	
			default:
				break;
		}
		
		if(!opcaoValida){
			System.err.println("Digite uma opção válida! ");
			System.out.println("");
		}
		
		principal();
		
	}
	
	public static void incluir(){
		
		System.out.println("");
		
		System.out.print("Digite o nome do Pedido: ");
		
		sc = new Scanner(System.in);
		
		String nome = sc.next();
		
		Pedido p = new Pedido();
		codigoPedido = codigoPedido + 1;
		p.setNumeroPedido(codigoPedido);
		p.setNomePedido(nome);
		
		pedidos.add(p);
		
		System.out.println("Pedido incluído com Sucesso!");
		
		System.out.println("");
	}
	
	public static void alterar(){
		System.out.println("");
		System.out.println("Desenvolver função de alteração com base na Exclusão!");
		System.out.println("");
	}

	public static void excluir(){
		System.out.println("");
		
		if(pedidos.size() > 0){
		
			listar();
			
			System.out.print("Digite o número do Pedido que deseja excluir: ");
			
			sc = new Scanner(System.in);
			
			int opcao = sc.nextInt();
			
			boolean pedidoExiste = false;
		
		
			for(Pedido p : pedidos){
				if(p.getNumeroPedido() == opcao){
					pedidos.remove(p);
					pedidoExiste = true;
					break;
				}
			}
			
			if(!pedidoExiste){
				System.err.println("O Pedido digitado não existe! Voltando para o Menu principal...");
			} else {
				System.out.println("Pedido removido com Sucesso!");
			}
		} else {
			System.err.println("NÃO FORAM ENCONTRADOS PEDIDOS PARA EXCLUSÃO!");
		}
		
		System.out.println("");
	}
	
	public static void listar(){
		System.out.println("");
		
		System.out.println("-------------------- LISTA DE PEDIDOS CADASTRADOS -------------------- ");
		System.out.println("");
		
		if(pedidos.size() == 0){
			System.out.println("------------     NENHUM PEDIDO CADASTRADO NO MOMENTO -----------------");
		} else {
			for(Pedido p : pedidos){
				System.out.println("NÚMERO PEDIDO: "+p.getNumeroPedido());
				System.out.println("NOME: "+p.getNomePedido());
				System.out.println("");
			}
		}
		
		System.out.println("---------------------------------------------------------------------- ");
		
		System.out.println("");
	}
	
	public static void sair(){
		System.out.println("");
		System.out.println("Finalizando o Programa...");
		System.out.println("");
		
		sc.close();
		System.exit(0);
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		PedidoListener.sc = sc;
	}

}
