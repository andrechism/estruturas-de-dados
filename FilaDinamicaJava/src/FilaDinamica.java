
public class FilaDinamica <T> {

	private Elemento primeiro;
	private Elemento ultimo;
	private int tamanho;
	
	public boolean isVazia() {
		return tamanho == 0;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(T t) {
		Elemento no = new Elemento();
		no.t = t;
		no.proximo = null;
		if(isVazia()){
			primeiro = no;
			ultimo = no;
		}else{
			ultimo.proximo = no;
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
	
	private class Elemento {
		Elemento proximo;
		T t;
	}
	
}
