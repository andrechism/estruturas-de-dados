
public class Main {
	
	public static void main(String[] args) {
		
		FilaEstatica<Produto> fila = new FilaEstatica<Produto>(15);
		
		Produto produto = new Produto();
		produto.setCodigo(1001);
		produto.setNome("Queijo");
		produto.setPreco(4.99f);
		
		fila.inserir(produto);
		
		System.out.println(fila.get());
		
		Produto produto2 = new Produto();
		produto2.setCodigo(1002);
		produto2.setNome("Feijão");
		produto2.setPreco(9.78f);
		
		fila.inserir(produto2);
		
		System.out.println(fila.get());
		
		fila.remover();
		
		System.out.println(fila.get());
		
		fila.remover();
		
		System.out.println(fila.get());
		
	}

}
