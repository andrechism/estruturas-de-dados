
public class Programa {
	
	public static void main(String[] args) {
		
		FilaDinamica<Pessoa> fila = new FilaDinamica<Pessoa>();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Wolney");
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Henrique");
		
		Pessoa p3 = new Pessoa();
		p3.setNome("Clara");
		
		fila.inserir(p1);
		fila.inserir(p2);
		fila.inserir(p3);
		
		System.out.println("Tamanho da fila: " + fila.getTamanho());
		System.out.println("Primeira pessoa de fila: " + fila.get());
		fila.remover();
		System.out.println("Tamanho da fila: " + fila.getTamanho());
		System.out.println("Primeira pessoa de fila: " + fila.get());
		fila.remover();
		System.out.println("Tamanho da fila: " + fila.getTamanho());
		System.out.println("Primeira pessoa de fila: " + fila.get());
		
	}

}
