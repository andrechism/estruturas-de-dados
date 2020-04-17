
public class ListaDuplamentoEncadeada implements ILista {
	
	private No primeiro = null;

	@Override
	public int getQuantidadeProdutos() {
		int tamanho = 0;
		No aux = primeiro;
		while(aux != null) {
			tamanho++;
			aux = aux.proximo;
		}
		return tamanho;
	}

	@Override
	public int getTamanho() {
		return getQuantidadeProdutos();
	}

	@Override
	public boolean isVazia() {
		return primeiro == null;
	}

	@Override
	public boolean isCheia() {
		return false;
	}

	@Override
	public boolean adicionar(Produto produto) {
		No no = new No();
		no.produto = produto;
		no.proximo = null;
		no.anterior = null;
		if(isVazia()) {
			primeiro = no;
		}else {
			No aux = primeiro;
			while(aux.proximo != null) {
				aux = aux.proximo;
			}
			aux.proximo = no;
			no.anterior = aux;
		}
		return true;
	}

	@Override
	public boolean remover(int codigoProduto) {
		if(isVazia()) {
			return false;
		}
		No aux = primeiro;
		while(aux != null 
				&& aux.produto.getCodigo() != codigoProduto) {
			aux = aux.proximo;
		}
		if(aux == null) {
			return false;
		}
		if(aux.anterior == null) {
			primeiro = aux.proximo;
		}else {
			aux.anterior.proximo = aux.proximo;
		}
		if(aux.proximo != null) {
			aux.proximo.anterior = aux.anterior;
		}
		return true;
	}

	@Override
	public Produto get(int i) {
		if(isVazia() && i < 0) {
			return null;
		}
		No aux = primeiro;
		int posicaoAtual = 0;
		while(aux != null && posicaoAtual < i) {
			aux = aux.proximo;
			posicaoAtual++;
		}
		if(aux == null) {
			return null;
		}
		return aux.produto;
	}
	
	private class No {
		Produto produto;
		No proximo;
		No anterior;
	}

	@Override
	public Produto get(String descricaoProduto) {
		return null;
	}

	@Override
	public Produto getCodigo(int codigo) {
		return null;
	}

}
