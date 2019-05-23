#include <stdlib.h>
#include "FilaDinamica.h"

struct elemento {
	struct elemento* proximo;
	Produto produto;
};

typedef struct elemento ElementoFila;

struct filaProduto {
	ElementoFila* primeiro;
	ElementoFila* ultimo;
	int tamanho;
};

FilaProduto* criar_fila_produtos(){
	FilaProduto* fila = (FilaProduto*) malloc(sizeof(FilaProduto));
	if(fila != NULL){
		fila->primeiro = NULL;
		fila->ultimo = NULL;
		fila->tamanho = 0;
	}
	return fila;
}

void destruir_fila_produtos(FilaProduto* fila){
	if(fila != NULL){
		if(fila->tamanho > 0){
			ElementoFila *no = fila->primeiro, *aux = NULL;
			while(no != NULL){
				aux = no;
				no = no->proximo;
				free(aux);
			}
		}
		free(fila);
	}
}

int fila_produtos_vazia(FilaProduto* fila){
	if(fila == NULL){
		return -1;
	}
	if(fila->tamanho == 0){
		return 1;
	}
	return 0;
}

int tamanho_fila_produtos(FilaProduto* fila){
	if(fila == NULL){
		return -1;
	}
	return fila->tamanho;
}

int inserir_fila_produtos(FilaProduto* fila, Produto produto){
	if(fila == NULL){
		return 0;
	}
	ElementoFila* no = (ElementoFila*) malloc(sizeof(ElementoFila));
	if(no == NULL){
		return 0;
	}
	no->produto = produto;
	no->proximo = NULL;
	if(fila_produtos_vazia(fila)){
		fila->primeiro = no;
		fila->ultimo = no;
	}else{
		fila->ultimo->proximo = no;
	}
	fila->tamanho++;
	return 1;
}

int remover_fila_produtos(FilaProduto* fila){
	if(fila == NULL){
		return 0;
	}
	if(fila_produtos_vazia(fila)){
		return 0;
	}
	ElementoFila *no = fila->primeiro;
	if(fila->tamanho == 1){
		fila->primeiro = NULL;
		fila->ultimo = NULL;
	}else{
		fila->primeiro = no->proximo;
	}
	free(no);
	return 1;
}

int consultar_fila_produtos(FilaProduto* fila, Produto* produto){
	if(fila == NULL){
		return 0;
	}
	if(fila_produtos_vazia(fila)){
		return 0;
	}
	*produto = fila->primeiro->produto;
	return 1;
}
