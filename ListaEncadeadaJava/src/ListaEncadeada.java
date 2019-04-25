
public class ListaEncadeada <T> {
	
	private ElementoLista primeiroElemento = null;
	
	public int getTamanho() {
		int quantidade = 0;
		ElementoLista no = primeiroElemento;
		while(no != null) {
			quantidade++;
			no = no.proximo;
		}
		return quantidade;
	}
	
	public boolean isVazia() {
		if(primeiroElemento == null) {
			return true;
		}
		return false;
	}
	
	public void inserir(T t) {
		ElementoLista no = new ElementoLista();
		no.t = t;
		no.proximo = null;
		if(primeiroElemento == null) {
			primeiroElemento = no;
		}else {
			ElementoLista aux = primeiroElemento;
			while(aux.proximo != null) {
				aux = aux.proximo;	
			}
			aux.proximo = no;
		}
	}
	
	public boolean remover(T t) {
		ElementoLista noAnterior, no = primeiroElemento;
		while(no != null && no.t != t) {
			noAnterior = no;
			no = no.proximo;
		}
		if(no == null) {
			return false;
		}
		if(no == primeiroElemento) {
			primeiroElemento = null;
		}else {
			noAnterior = no.proximo;
		}
		return true;
	}
	
	public T consultar(int indice) {
		if(indice < 0) {
			return null;
		}
		ElementoLista no = primeiroElemento;
		int i = 0;
		while(no != null && i < indice) {
			no = no.proximo;
			i++;
		}
		if(no == null) {
			return null;
		}
		return no.t;
	}
	
	private class ElementoLista {
		T t;
		ElementoLista proximo;
	}

}
