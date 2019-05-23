
public class ListaCircular <T> {
	
	private Elemento inicio = null;
	private Elemento fim = null;
	private int tamanho = 0;
	
	public boolean isVazia() {
		return tamanho == 0;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(T t) {
		Elemento no = new Elemento();
		no.t = t;
		if(isVazia()){
			inicio = no;
			fim = no;
			no.proximo = no;
		}else{
			fim.proximo = no;
			fim = no;
			no.proximo = inicio;
		}
		tamanho++;
	}
	
	public T consultar(int index) {
		if(index < 0 || index >= tamanho){
			return null;
		}
		Elemento no = inicio;
		int i = 0;
		while(i < index){
			no = no.proximo;
			i++;
		}
		return no.t;
	}
	
	public boolean remover(T t) {
		if(isVazia()){
			return false;
		}
		Elemento no = inicio, noAnterior = fim;
		while(no != fim && !no.t.equals(t)){
			noAnterior = no;
			no = no.proximo;
		}
		if(!no.t.equals(t)){
			return false;
		}
		if(no == inicio && no == fim){
			inicio = null;
			fim = null;
		}else{
			if(no == inicio){
				inicio = no.proximo;
			}else if(no == fim){
				fim = noAnterior;
			}
			noAnterior.proximo = no.proximo;
		}
		tamanho--;
		return true;
	}
	
	private class Elemento {
		Elemento proximo;
		T t;
	}

}
