public class Pilha <T> {

	private No topo;
	private int tamanho;
	
	public boolean isVazia() {
		if(tamanho == 0){
			return true;
		}
		return false;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(T t) {
		No no = new No();
		no.t = t;
		no.proximo = topo;
		topo = no;
		tamanho++;
	}
	
	public boolean remover() {
		if(isVazia()) {
			return false;
		}
		topo = topo.proximo;
		tamanho--;
		return true;
	}
	
	public T get() {
		if(isVazia()) {
			return null;
		}
		return topo.t;
	}
	
	private class No {
		No proximo;
		T t;
	}
	
}
