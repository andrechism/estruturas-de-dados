#include <stdlib.h>
#include "PilhaDinamica.h"

struct elemento {
	struct elemento* proximo;
	Produto produto;
};

typedef struct elemento ElementoPilha;

struct pilhaProduto {
	ElementoPilha* topo;
	int tamanho;
};

PilhaProduto* criar_pilha_produtos(){
	PilhaProduto* pilha = (PilhaProduto*) malloc(sizeof(PilhaProduto));
	if(pilha != NULL){
		pilha->topo = NULL;
		pilha->tamanho = 0;
	}
	return pilha;
}

void destruir_pilha_produtos(PilhaProduto* pilha){
	if(pilha != NULL){
		if(pilha->tamanho > 0){
			ElementoPilha *no = pilha->topo, *aux = NULL;
			while(no != NULL){
				aux = no;
				no = no->proximo;
				free(aux);
			}
		}
		free(pilha);
	}
}

int pilha_produtos_vazia(PilhaProduto* pilha){
	if(pilha == NULL){
		return -1;
	}
	if(pilha->tamanho == 0){
		return 1;
	}
	return 0;
}

int tamanho_pilha_produtos(PilhaProduto* pilha){
	if(pilha == NULL){
		return -1;
	}
	return pilha->tamanho;
}

int inserir_pilha_produtos(PilhaProduto* pilha, Produto produto){
	if(pilha == NULL){
		return 0;
	}
	ElementoPilha* no = (ElementoPilha*) malloc(sizeof(ElementoPilha));
	if(no == NULL){
		return 0;
	}
	no->produto = produto;
	no->proximo = pilha->topo;
	pilha->topo = no;
	pilha->tamanho++;
	return 1;
}

int remover_pilha_produtos(PilhaProduto* pilha){
	if(pilha == NULL){
		return 0;
	}
	if(pilha_produtos_vazia(pilha)){
		return 0;
	}
	ElementoPilha* no = pilha->topo;
	pilha->topo = pilha->topo->proximo;
	free(no);
	pilha->tamanho--;
	return 1;
}

int consultar_pilha_produtos(PilhaProduto* pilha, Produto* produto){
	if(pilha == NULL){
		return 0;
	}
	if(pilha_produtos_vazia(pilha)){
		return 0;
	}
	*produto = pilha->topo->produto;
	return 1;
}
