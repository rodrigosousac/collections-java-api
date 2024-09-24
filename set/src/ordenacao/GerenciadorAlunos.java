package ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
	private Set<Aluno> alunoSet;

	public GerenciadorAlunos() {
		this.alunoSet = new HashSet<>();
	}
	
	public void adicionarAluno(String nome, Long matricula, double media) {
		alunoSet.add(new Aluno(nome, matricula, media));
	}
	
	public void removerAluno(long matricula) {
		Aluno alunoParaRemover = null;
		
		for(Aluno a : alunoSet) {
			if(a.getMatricula() == matricula) {
				alunoParaRemover = a;
				break;
			}
		}
		alunoSet.remove(alunoParaRemover);
	}
	
	public Set<Aluno> exibirAlunosPorNome(){
		Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
		return alunosPorNome;
	}
	
	public Set<Aluno> exibirAlunosPorNota(){
		Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
		
		alunosPorNota.addAll(alunoSet);
		
		return alunosPorNota;
	}
	
	public void exibirAlunos() {
		System.out.println(alunoSet);
	}
	
	public static void main(String[] args) {
		GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
		
		gerenciadorAlunos.exibirAlunos();
		
		gerenciadorAlunos.adicionarAluno("Alfredo", 123L, 8.5);
		gerenciadorAlunos.adicionarAluno("Bia", 123L, 7);
		gerenciadorAlunos.adicionarAluno("Caio", 456L, 8);
		gerenciadorAlunos.adicionarAluno("Maria", 234L, 9);
		gerenciadorAlunos.adicionarAluno("José", 89L, 6);
		
		gerenciadorAlunos.exibirAlunos();
		
		gerenciadorAlunos.removerAluno(89L);
		
		gerenciadorAlunos.exibirAlunos();
		
		System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
		System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
	}
}
