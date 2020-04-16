public class ListaDuplamenteEncadeada <T> {
	
	private No primeiro = null;
	
	public int getTamanho() {
		int tamanho = 0;
		No aux = primeiro;
		while(aux != null) {
			tamanho++;
			aux = aux.proximo;
		}
		return tamanho;
	}
	
	public boolean isVazia() {
		return getTamanho() == 0;
	}
	
	public void inserir(T t) {
		No no = new No();
		no.elemento = t;
		no.anterior = null;
		no.proximo = null;
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
	}
	
	public boolean remover(T t) {
		if(isVazia()) {
			return false;
		}
		No aux = primeiro;
		while(aux != null && aux.elemento != t) {
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
	
	public T consultar(int posicao) {
		if(posicao < 0 || posicao >= getTamanho()) {
			return null;
		}
		int i = 0;
		No aux = primeiro;
		while(aux != null && i < posicao) {
			aux = aux.proximo;
			i++;
		}
		if(aux == null) {
			return null;
		}
		return aux.elemento;
	}
	
	private class No {
		T elemento;
		No anterior;
		No proximo;
	}

}
