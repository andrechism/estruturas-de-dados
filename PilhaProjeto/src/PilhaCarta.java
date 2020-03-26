public class PilhaCarta {

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
	
	public void inserir(Carta carta) {
		No no = new No();
		no.carta = carta;
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
	
	public Carta get() {
		if(isVazia()) {
			return null;
		}
		return topo.carta;
	}
	
	private class No {
		No proximo;
		Carta carta;
	}
	
}
