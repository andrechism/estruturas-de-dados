public class ListaProdutoDinamica implements ILista {
	
	private No primeiro = null;

	@Override
	public int getQuantidadeProdutos() {
		int quantidadeProdutos = 0;
		No aux = primeiro;
		while(aux != null) {
			quantidadeProdutos++;
			aux = aux.proximo;
		}
		return quantidadeProdutos;
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
		if(isVazia()) {
			primeiro = no;
		}else {
			No aux = primeiro;
			while(aux.proximo != null) {
				aux = aux.proximo;
			}
			aux.proximo = no;
		}
		return true;
	}

	@Override
	public boolean remover(int codigoProduto) {
		No aux = primeiro;
		No auxAnterior = null;
		while(aux != null && aux.produto.getCodigo() != codigoProduto) {
			auxAnterior = aux;
			aux = aux.proximo;
		}
		if(aux == null) {
			return false;
		}
		// Pequena alteração nessa linha em relação a aula.
		// Na condicional troquei o getQuantidadeProdutos() == 1 por aux == primeiro
		if(aux == primeiro) {
			primeiro = aux.proximo;
		}else {			
			auxAnterior.proximo = aux.proximo;
		}
		return true;
	}

	@Override
	public Produto get(int i) {
		if(i < 0 || i >= getQuantidadeProdutos()) {
			return null;
		}
		No aux = primeiro;
		int indice = 0;
		while(aux != null && indice < i ) {
			aux = aux.proximo;
			indice++;
		}
		return aux.produto;
	}
	
	private class No {
		Produto produto;
		No proximo;
	}

}
