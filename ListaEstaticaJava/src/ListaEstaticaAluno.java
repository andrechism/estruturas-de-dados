
public class ListaEstaticaAluno {
	
	private final int MAX = 100;
	private int quantidade;
	private Aluno dados[];

	public ListaEstaticaAluno() {
		quantidade = 0;
		dados = new Aluno[MAX];
	}
	
	public int getTamanho() {
		return quantidade;
	}
	
	public boolean isCheia() {
		return quantidade == MAX;
	}
	
	public boolean isVazia() {
		return quantidade == 0;
	}
	
	public boolean inserirFinal(Aluno aluno) {
		if(isCheia()) {
			return false;
		}
		dados[quantidade] = aluno;
		quantidade++;
		return true;
	}
	
	public boolean inserirInicio(Aluno aluno) {
		if(isCheia()) {
			return false;
		}
		for(int i = quantidade; i >= 0; i--){
			dados[i+1] = dados[i];
		}
		dados[0] = aluno;
		quantidade++;
		return true;
	}
	
	public boolean inserirOrdenadamente(Aluno aluno) {
		if(isCheia()) {
			return false;
		}
		int k, i = 0;
		while(i < quantidade && dados[i].getMatricula() < aluno.getMatricula()){
			i++;
		}
		for(k = quantidade - 1; k >= i; k--){
			dados[k + 1] = dados[k];
		}
		dados[i] = aluno;
		quantidade++;
		return true;
	}
	
	public boolean removerFinal() {
		if(isVazia()) {
			return false;
		}
		quantidade--;
		return true;
	}
	
	public boolean removerInicio() {
		if(isVazia()) {
			return false;
		}
		for(int k = 0; k < quantidade-1; k++){
			dados[k] = dados[k+1];
		}
		quantidade--;
		return true;
	}
	
	public boolean removerElemento(Aluno aluno) {
		if(isVazia()) {
			return false;
		}
		int k, i = 0;
		while(i < quantidade && dados[i].getMatricula() != aluno.getMatricula()){
			i++;
		}
		if(i == quantidade){
			return false;
		}
		for(k = i; k < quantidade-1; k++){
			dados[k] = dados[k+1];
		}
		quantidade--;
		return true;
	}
	
	public Aluno get(int posicao) {
		if(posicao <= 0 || posicao > quantidade) {
			return null;
		}
		return dados[posicao - 1];
	}
	
	public Aluno getPorMatricula(int matricula) {
		int i = 0;
		while(i < quantidade && dados[i].getMatricula() != matricula){
			i++;
		}
		if(i == quantidade){
			return null;
		}
		return dados[i];
	}
	
}
