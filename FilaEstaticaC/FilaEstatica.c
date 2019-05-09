#include <stdlib.h>
#include "FilaEstatica.h"

struct filaProdutos {
	int inicio, final, quantidade;
	Produto produtos[MAX];
};

FilaProdutos* criar_fila_produtos(){
	FilaProdutos* fila = (FilaProdutos*) malloc(sizeof(FilaProdutos));
	if(fila != NULL){
		fila->inicio = 0;
		fila->final = 0;
		fila->quantidade = 0;
	}
	return fila;
}

void destruir_fila_produtos(FilaProdutos* fila){
	free(fila);
}

int tamanho_fila_produtos(FilaProdutos* fila){
	if(fila == NULL){
		return -1;
	}
	return fila->quantidade;
}

int fila_produto_cheia(FilaProdutos* fila){
	if(fila == NULL){
		return -1;
	}
	if(fila->quantidade == MAX){
		return 1;
	}
	return 0;
}

int fila_produto_vazia(FilaProdutos* fila){
	if(fila == NULL){
		return -1;
	}
	if(fila->quantidade == 0){
		return 1;
	}
	return 0;
}

int inserir_fila_produtos(FilaProdutos* fila, Produto produto){
	if(fila == NULL){
		return 0;
	}
	if(fila_produto_cheia(fila)){
		return 0;
	}
	fila->produtos[fila->final] = produto;
	fila->final = (fila->final+1) % MAX;
	fila->quantidade++;
	return 1;
}

int remover_fila_produtos(FilaProdutos* fila){
	if(fila == NULL){
		return 0;
	}
	if(fila_produto_vazia(fila)){
		return 0;
	}
	fila->inicio = (fila->inicio+1) % MAX;
	fila->quantidade--;
	return 1;
}


int consultar_fila_produtos(FilaProdutos* fila, Produto* produto){
	if(fila == NULL){
		return 0;
	}
	if(fila_produto_vazia(fila)){
		return 0;
	}
	*produto = fila->produtos[fila->inicio];
	return 1;
}
