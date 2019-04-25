
public class Programa {
	
	public static void main(String[] args) {
		
		ListaEncadeada<Aluno> lista = new ListaEncadeada<>();
		
		Aluno aluno1 = new Aluno(1001, "José");
		Aluno aluno2 = new Aluno(1002, "Joana");
		
		lista.inserir(aluno1);
		lista.inserir(aluno2);
		
		for(int i = 0; i < lista.getTamanho(); i++) {
			Aluno a = lista.consultar(i);
			System.out.println(a.getNome());
		}
		
		
	}

}
