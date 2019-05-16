#include <stdlib.h>
#include "PilhaEstatica.h"

struct pilhaProdutos {
	int quantidade;
	Produto produtos[MAX];
};

PilhaProdutos* criar_pilha_produtos(){
	PilhaProdutos* pilha = (PilhaProdutos*) malloc(sizeof(PilhaProdutos));
	if(pilha != NULL){
		pilha->quantidade = 0;
	}
	return pilha;
}

void destruir_pilha_produtos(PilhaProdutos* pilha){
	free(pilha);
}

int tamanho_pilha_produtos(PilhaProdutos* pilha){
	if(pilha == NULL){
		return -1;
	}
	return pilha->quantidade;
}

int pilha_produtos_cheia(PilhaProdutos* pilha){
	if(pilha == NULL){
		return -1;
	}
	if(pilha->quantidade == MAX){
		return 1;
	}
	return 0;
}

int pilha_produtos_vazia(PilhaProdutos* pilha){
	if(pilha == NULL){
		return -1;
	}
	if(pilha->quantidade == 0){
		return 1;
	}
	return 0;
}

int inserir_pilha_produtos(PilhaProdutos* pilha, Produto produto){
	if(pilha == NULL){
		return 0;
	}
	if(pilha_produtos_cheia(pilha)){
		return 0;
	}
	pilha->produtos[pilha->quantidade] = produto;
	pilha->quantidade++;
	return 1;
}

int remover_pilha_produtos(PilhaProdutos* pilha){
	if(pilha == NULL){
		return 0;
	}
	if(pilha_produtos_vazia(pilha)){
		return 0;
	}
	pilha->quantidade--;
	return 1;
}

int consultar_pilha_produtos(PilhaProdutos* pilha, Produto* produto){
	if(pilha == NULL){
		return 0;
	}
	if(pilha_produtos_vazia(pilha)){
		return 0;
	}
	*produto = pilha->produtos[pilha->quantidade-1];
	return 1;
}
