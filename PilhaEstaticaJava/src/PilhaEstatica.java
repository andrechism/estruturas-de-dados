@SuppressWarnings("unchecked")
public class PilhaEstatica <T> {
	
	private int quantidade = 0;
	private Object dados[];
	
	public PilhaEstatica(int tamanhoPilha) {
		dados = new Object[tamanhoPilha];
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public boolean isCheia() {
		return quantidade == dados.length;
	}
	
	public boolean isVazia() {
		return quantidade == 0;
	}
	
	public boolean inserir(T t) {
		if(isCheia()) {
			return false;
		}
		dados[quantidade] = t;
		quantidade++;
		return true;
	}
	
	public T remover() {
		if(isVazia()) {
			return null;
		}
		quantidade--;
		T t = (T) dados[quantidade];
		return t;
	}
	
	public T consultar() {
		if(isVazia()) {
			return null;
		}
		T t = (T) dados[quantidade-1];
		return t;
	}

}
