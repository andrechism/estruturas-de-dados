
public class FilaDinamica <T> {

	private No primeiro;
	private No ultimo;
	private int tamanho;
	
	public boolean isVazia() {
		return tamanho == 0;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(T t) {
		No no = new No();
		no.t = t;
		no.proximo = null;
		if(isVazia()){
			primeiro = no;
			ultimo = no;
		}else{
			ultimo.proximo = no;
			ultimo = no;
		}
		tamanho++;
	}
	
	public boolean remover() {
		if(isVazia()) {
			return false;
		}
		if(tamanho == 1){
			primeiro = null;
			ultimo = null;
		}else{
			primeiro = primeiro.proximo;
		}
		tamanho--;
		return true;
	}
	
	public T get() {
		if(isVazia()) {
			return null;
		}
		return primeiro.t;
	}
	
	private class No {
		No proximo;
		T t;
	}
	
}
