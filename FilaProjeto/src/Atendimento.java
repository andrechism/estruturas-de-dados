
public class Atendimento {

	private int numero;
	private String nome;

	public Atendimento() {

	}

	public Atendimento(int numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Atendimento [numero=" + numero + ", nome=" + nome + "]";
	}

}
