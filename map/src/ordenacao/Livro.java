package ordenacao;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Livro {
	private String titulo;
	private String autor;
	private double preco;
	
	public Livro(String titulo, String autor, double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", preco=" + preco + "]";
	}
}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>>{

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		// TODO Auto-generated method stub
		double preco1 = l1.getValue().getPreco();
		double preco2 = l2.getValue().getPreco();
		
		return Double.compare(preco1, preco2);
	}
	
}

class ComparatorPorAutor implements Comparator<Map.Entry<String, Livro>>{

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		// TODO Auto-generated method stub
		String autor1 = l1.getValue().getAutor();
		String autor2 = l2.getValue().getAutor();
		return autor1.compareToIgnoreCase(autor2);
	}
	
}
