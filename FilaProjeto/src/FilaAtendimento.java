public class FilaAtendimento {
	
	private No primeiro;
	private No ultimo;
	private int tamanho;
	
	public boolean isVazia() {
		return tamanho == 0;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(Atendimento atendimento) {
		No no = new No();
		no.atendimento = atendimento;
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
	
	public Atendimento get() {
		if(isVazia()) {
			return null;
		}
		return primeiro.atendimento;
	}
	
	private class No {
		No proximo;
		Atendimento atendimento;
	}

}
