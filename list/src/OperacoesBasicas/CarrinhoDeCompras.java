package OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	private List<Item> itemList;

	public CarrinhoDeCompras() {
		this.itemList = new ArrayList<>();
	}
	
	public void adicionarItem(String nome, double preco, int quantidade) {
		itemList.add(new Item(nome, preco, quantidade));
	}
	
	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList<>();
		
		for(Item i:itemList){
			if(i.getNome().equalsIgnoreCase(nome)) {
				itensParaRemover.add(i);
			}
		}
		itemList.removeAll(itensParaRemover);
	}
	
	public double calcularValorTotal() {
		double valorTotal=0;
		
		for(Item i:itemList) {
			valorTotal += i.getPreco()*i.getQuantidade();
		}
		return valorTotal;
	}
	
	public void exibirItens() {
		System.out.println(itemList);
	}
	
	public static void main (String[] args) {
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		System.out.println("Os itens do carrinho são: ");
		carrinhoDeCompras.exibirItens();
		
		carrinhoDeCompras.adicionarItem("maçã", 1.45, 2);
		carrinhoDeCompras.adicionarItem("goiaba", 2.00, 5);		
		System.out.println("Os itens do carrinho são: ");
		carrinhoDeCompras.exibirItens();
		System.out.println("O valor total do carrinho é: R$" + carrinhoDeCompras.calcularValorTotal());

		
		carrinhoDeCompras.removerItem("maçã");
		System.out.println("Os itens do carrinho são: ");
		carrinhoDeCompras.exibirItens();
		System.out.println("O valor total do carrinho é: R$" + carrinhoDeCompras.calcularValorTotal());
		
	}
}
