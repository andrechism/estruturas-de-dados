@SuppressWarnings("unchecked")
public class FilaEstatica <T> {
	
	private int inicio = 0;
	private int fim = 0;
	private int tamanho = 0;
	private Object dados[];
	
	public FilaEstatica(int tamanhoFila) {
		dados = new Object[tamanhoFila];
	}
	
	public boolean isCheia() {
		if(tamanho == dados.length) {
			return true;
		}
		return false;
	}
	
	public boolean isVazia() {
		if(tamanho == 0) {
			return true;
		}
		return false;
	}
	
	public boolean inserir(T t) {
		if(isCheia()) {
			return false;
		}
		dados[fim] = t;
		fim = (fim + 1) % dados.length;
		tamanho++;
		return true;
	}
	
	public T remover() {
		if(isVazia()) {
			return null;
		}
		T t = (T) dados[inicio];
		inicio = (inicio + 1) % dados.length;
		tamanho--;
		return t;
	}
	
	public T get() {
		if(isVazia()) {
			return null;
		}
		T t = (T) dados[inicio];
		return t;
	}
	
}
