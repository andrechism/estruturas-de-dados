
public class BurbbleSort {

	public void ordenar(int[] v) {
		int i = 0, aux = 0, continua = 0, fim = v.length - 1;
		do {
			for(i = 0; i < fim; i++) {
				if(v[i] > v[i+1]) {
					aux = v[i];
					v[i] = v[i+1];
					v[i+1] = aux;
				}
				continua = i;
			}
			fim--;
		}while(continua != 0);
	}
	
}
