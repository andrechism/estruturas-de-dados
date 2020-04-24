
public class ListaProdutoCircular implements ILista {
	
	private No primeiro = null;

	@Override
	public int getQuantidadeProdutos() {
		if(isVazia()) {
			return 0;
		}
		int quantidadeDeProdutos = 1;
		No aux = primeiro;
		while(aux.proximo != primeiro) {
			quantidadeDeProdutos++;
			aux = aux.proximo;
		}
		return quantidadeDeProdutos;
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
		if(primeiro == null) {
			no.proximo = no;
			primeiro = no;
		}else {
			No aux = primeiro;
			while(aux.proximo != primeiro) {
				aux = aux.proximo;
			}
			aux.proximo = no;
			no.proximo = primeiro;
		}
		return true;
	}

	@Override
	public boolean remover(int codigoProduto) {
		if(isVazia()) {
			return false;
		}
		No aux = primeiro;
		if(aux.produto.getCodigo() == codigoProduto) {
			if(aux.proximo == primeiro) {
				primeiro = null;
			}else {
				No ultimo = primeiro;
				while(ultimo.proximo != primeiro) {
					ultimo = ultimo.proximo;
				}
				ultimo.proximo = primeiro.proximo;
				primeiro = primeiro.proximo;
			}
			return true;
		}
		//
		No anterior = aux;
		aux = aux.proximo;
		while(aux != primeiro 
				&& 
				aux.produto.getCodigo() != codigoProduto) {
			anterior = aux;
			aux = aux.proximo;
		}
		if(aux == primeiro) {
			return false;
		}
		anterior.proximo = aux.proximo;
		return true;
	}

	@Override
	public Produto get(int i) {
		if(i < 0 || isVazia()) {
			return null;
		}
		No aux = primeiro;
		int indice = 0;
		while(aux.proximo != primeiro
				&& indice < i) {
			indice++;
			aux = aux.proximo;
		}
		if(i != indice) {
			return null;
		}
		return aux.produto;
	}

	@Override
	public Produto get(String descricaoProduto) {
		return null;
	}

	@Override
	public Produto getCodigo(int codigo) {
		return null;
	}
	
	private class No {
		Produto produto;
		No proximo;
	}

}
