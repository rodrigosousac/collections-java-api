package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LivrariaOnline {
	Map<String, Livro> livrosMap;

	public LivrariaOnline() {
		this.livrosMap = new HashMap<>();
	}
	
	public void adicionarLivro(String link, String titulo, String autor, double preco) {
		Livro livro = new Livro(titulo, autor, preco);
		livrosMap.put(link, livro);
	}
	
	public void removerLivro(String titulo) {
		List<String> livroParaRemover = new ArrayList<>();
	    for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
	      if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
	    	  livroParaRemover.add(entry.getKey());
	      }
	    }
	    for (String livro : livroParaRemover) {
	      livrosMap.remove(livro);
	    }
	}
	
	public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());
		
		Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
		Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
		
		for(Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
			livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
		}
		return livrosOrdenadosPorPreco;
	}
	
	public Map<String, Livro> exibirLivrosOrdenadosPorAutor(){
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrosMap.entrySet());
		
		Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());
		Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();
		
		for(Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
			livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
		}
		return livrosOrdenadosPorAutor;
	}
	
	public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
		Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
		
		for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
			Livro livro = entry.getValue();
			
			if(livro.getAutor().equals(autor)) {
				livrosPorAutor.put(entry.getKey(), livro);
			}
		}
		return livrosPorAutor;
	}
	
	public List<Livro> obterLivroMaisCaro(){
		List<Livro> livroMaisCaro = new ArrayList<>();
		double precoMaisAlto = Double.MIN_VALUE;
		
		if(!livrosMap.isEmpty()) {
			for(Livro livro : livrosMap.values()) {
				if(livro.getPreco() > precoMaisAlto) {
					precoMaisAlto = livro.getPreco();
				}
			}
		}
		
		for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
			if(entry.getValue().getPreco() == precoMaisAlto) {
				Livro livroComPrecoMaisAlto = livrosMap.get(entry.getKey());
				livroMaisCaro.add(livroComPrecoMaisAlto);
			}
		}
		return livroMaisCaro;
	}	
		
	public List<Livro> obterLivroMaisBarato(){
		List<Livro> livroMaisBarato = new ArrayList<>();
		double precoMaisBaixo = Double.MAX_VALUE;
		
		if(!livrosMap.isEmpty()) {
			for(Livro livro : livrosMap.values()) {
				if(livro.getPreco() < precoMaisBaixo) {
					precoMaisBaixo = livro.getPreco();
				}
			}
		}
		
		for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
			if(entry.getValue().getPreco() == precoMaisBaixo) {
				Livro livroComPrecoMaisBaixo = livrosMap.get(entry.getKey());
				livroMaisBarato.add(livroComPrecoMaisBaixo);
			}
		}
		return livroMaisBarato;
	}
	
	public static void main(String[] args) {
		LivrariaOnline livrariaOnline = new LivrariaOnline();
		
		livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50);
	    livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05);
	    livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99);
	    livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5);
	    livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50);
	    livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5);
	    
	    System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());
	    
	    System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());
	    
	    System.out.println("Livros do autor Josh Malerman: \n" + livrariaOnline.pesquisarLivrosPorAutor("Josh Malerman")); 
	
	    System.out.println("Livro mais caro: \n" + livrariaOnline.obterLivroMaisCaro());
	    
	    System.out.println("Livro mais barato: \n" + livrariaOnline.obterLivroMaisBarato());
	
	    livrariaOnline.removerLivro("1984");
	    System.out.println(livrariaOnline.livrosMap);
	}
}
