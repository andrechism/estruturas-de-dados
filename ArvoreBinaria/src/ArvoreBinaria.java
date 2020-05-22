
public class ArvoreBinaria {
	
	private No raiz = null;
	
	public boolean isVazia() {
		return raiz == null;
	}
	
	public int getAltura() {
		if(isVazia()) {
			return 0;
		}
		return getAltura(raiz);
	}
	
	private int getAltura(No no) {
		if(no == null) {
			return 0;
		}
		int alturaEsquerda = getAltura(no.esquerda);
		int alturaDireita = getAltura(no.direita);
		if(alturaEsquerda > alturaDireita) {
			return alturaEsquerda + 1;
		}
		return alturaDireita + 1;
	}
	
	public int getQuantidadeElementos() {
		if(isVazia()) {
			return 0;
		}
		return getQuantidadeElementos(raiz);
	}
	
	private int getQuantidadeElementos(No no) {
		if(no == null) {
			return 0;
		}
		int quantidadeEsquerda = getQuantidadeElementos(no.esquerda);
		int quantidadeDireita = getQuantidadeElementos(no.direita);
		return quantidadeEsquerda + quantidadeDireita + 1;
	}
	
	public boolean inserir(int dado) {
		No no = new No();
		no.dado = dado;
		no.direita = null;
		no.esquerda = null;
		if(isVazia()) {
			raiz = no;
			return true;
		}
		No atual = raiz;
		No anterior = null;
		while(atual != null) {
			anterior = atual;
			if(no.dado == atual.dado) {
				return false;
			}
			if(no.dado > atual.dado) {
				atual = atual.direita;
			}else {
				atual = atual.esquerda;
			}
		}
		if(no.dado > anterior.dado) {
			anterior.direita = no;
		}else {
			anterior.esquerda = no;
		}
		return true;
	}
	
	public void imprimir() {
		if(isVazia()) {
			System.out.println("Vazia");
		}
		imprimir(raiz);
	}
	
	private void imprimir(No no) {
		if(no != null) {
			System.out.println(no.dado);
			imprimir(no.esquerda);
			imprimir(no.direita);
		}
	}
	
	private class No {
		int dado;
		No esquerda;
		No direita;
	}

}
