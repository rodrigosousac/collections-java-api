package pesquisa;

import java.util.Objects;

public class Tarefa {
	private String descricao;
	private boolean situacao = false;

	public Tarefa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isSituacao() {
		return situacao;
	}
	
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(descricao, other.descricao);
	}

	@Override
	public String toString() {
		return "Tarefa [nome=" + descricao + ", situacacao=" + situacao + "]";
	}
}
