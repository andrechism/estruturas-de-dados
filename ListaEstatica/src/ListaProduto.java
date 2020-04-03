
public class ListaProduto {
	
	private int tamanho;
	private int quantidadeProdutos = 0;
	private Produto dados[];
	
	public ListaProduto(int tamanho) {
		this.tamanho = tamanho;
		dados = new Produto[tamanho];
	}
	
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean isVazia() {
		return quantidadeProdutos == 0;
	}
	
	public boolean isCheia() {
		return quantidadeProdutos == tamanho;
	}
	
	public boolean adicionar(Produto produto) {
		if(isCheia()) {
			return false;
		}
		dados[quantidadeProdutos] = produto;
		quantidadeProdutos++;
		return true;
	}
	
	public boolean remover(int codigoProduto) {
		if(isVazia()) {
			return false;
		}
		int x = 0, y = 0;
		while(x < quantidadeProdutos 
				&& dados[x].getCodigo() != codigoProduto) {
			x++;
		}
		if(x == quantidadeProdutos) {
			return false;
		}
		for(y = x; y < quantidadeProdutos - 1; y++) {
			dados[y] = dados[y + 1];
		}
		quantidadeProdutos--;
		return true;
	}
	
	public Produto get(int i) {
		if(isVazia()) {
			return null;
		}
		return dados[i];
	}
	
	// adicionar
	// remover
	// buscar
	// consultar Tamanho
	// Verificar se está cheio
	// Verificar se está vazio
	
	
	

}
