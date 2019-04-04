
public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno(1002, "Magno", 7, 10);
		Aluno aluno2 = new Aluno(1001, "Rebeca", 10, 8);
		
		ListaEstaticaAluno lista = new ListaEstaticaAluno();
		lista.inserirOrdenadamente(aluno1);
		lista.inserirOrdenadamente(aluno2);
		
		int tamanho = lista.getTamanho();
		for(int i = 1; i <= tamanho; i++) {
			Aluno aluno = lista.get(i);
			System.out.println("Aluno: " + aluno.getNome());
		}
		
		lista.removerElemento(aluno1);
		
		tamanho = lista.getTamanho();
		for(int i = 1; i <= tamanho; i++) {
			Aluno aluno = lista.get(i);
			System.out.println("Aluno: " + aluno.getNome());
		}
	}

}
