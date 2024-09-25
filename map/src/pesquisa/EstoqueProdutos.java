package pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
	private Map<Long, Produto> estoqueProdutosMap;

	public EstoqueProdutos() {
		this.estoqueProdutosMap = new HashMap<>();
	}
	
	public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
		estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
	}
	
	public void exibirProdutos() {
		System.out.println(estoqueProdutosMap);
	}
	
	public double calcularValorTotalEstoque() {
		double valorTotalEstoque = 0;
		
		if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p : estoqueProdutosMap.values()) {
				valorTotalEstoque += p.getQuantidade()*p.getPreco();
			}
		}
		return valorTotalEstoque;
	}
	
	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		
		if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p : estoqueProdutosMap.values()) {
				if(p.getPreco() > maiorPreco) {
					produtoMaisCaro = p;
					maiorPreco = p.getPreco();
				}
			}
		}
		return produtoMaisCaro;
	}
	
	public Produto obterProdutoMaisBarato() {
		Produto produtoMaisBarato = null;
		double menorPreco = Double.MAX_VALUE;
		
		if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p : estoqueProdutosMap.values()) {
				if(p.getPreco() < menorPreco) {
					produtoMaisBarato = p;
					menorPreco = p.getPreco();
				}
			}
		}
		return produtoMaisBarato;
	}
	
	public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
		Produto produtoValorTotal = null;
		double valorTotal = Double.MIN_VALUE;
		
		if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p : estoqueProdutosMap.values()) {
				if((p.getPreco()*p.getQuantidade()) > valorTotal) {
					produtoValorTotal = p;
					valorTotal = p.getPreco()*p.getQuantidade();
				}
			}
		}
		return produtoValorTotal;
	}
	
	public static void main(String[] args) {
		EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
		
		estoqueProdutos.exibirProdutos();
		
		estoqueProdutos.adicionarProduto(100L, "Banana", 5, 4);
		estoqueProdutos.adicionarProduto(101L, "Maçã", 1, 2);
		estoqueProdutos.adicionarProduto(102L, "Abacaxi", 2, 3);
		estoqueProdutos.adicionarProduto(103L, "Melão", 1, 15);
		estoqueProdutos.adicionarProduto(104L, "Goiaba", 10, 6);
		estoqueProdutos.adicionarProduto(105L, "Caju", 10, 10);
		
		estoqueProdutos.exibirProdutos();
		
		System.out.println("Valor total do estoque: R$" + estoqueProdutos.calcularValorTotalEstoque());
		System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
		System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
		System.out.println("Produto com maior quantidade em valor no estoque: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
	}
}
