
public class Programa {
	
	public static void main(String[] args) {
		int vetor[] = {5, 2, 4, 6, 3, 1};
		System.out.println("Vetor Antes: ");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]);
		}
		
		new SelectionSort().ordenar(vetor);
		
		System.out.println("\n\nVetor Depois: ");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]);
		}
	}

}
