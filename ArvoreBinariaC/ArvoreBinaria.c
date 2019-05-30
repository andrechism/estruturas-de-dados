#include <stdio.h>
#include <stdlib.h>
#include "ArvoreBinaria.h"

struct NO {
	int dado;
	struct NO *esquerda;
	struct NO *direita;
};

ArvoreBinaria* criar_arvore_binaria(){
	ArvoreBinaria* raiz = (ArvoreBinaria*) malloc(sizeof(ArvoreBinaria));
	if(raiz != NULL){
		*raiz = NULL;
	}
	return raiz;
}

void destruir_no(struct NO* no){
	if(no == NULL){
		return;
	}
	destruir_no(no->esquerda);
	destruir_no(no->direita);
	free(no);
	no = NULL;
}

void destruir_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return;
	}
	destruir_no(*raiz);
	free(raiz);
}

int arvore_binaria_vazia(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return 1;
	}
	if(*raiz == NULL){
		return 1;
	}
	return 0;
}

int altura_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return 0;
	}
	if(*raiz == NULL){
		return 0;
	}
	int altura_esquerda = altura_arvore_binaria(&((*raiz)->esquerda));
	int altura_direita = altura_arvore_binaria(&((*raiz)->direita));
	if(altura_esquerda > altura_direita){
		return (altura_esquerda + 1);
	}
	return (altura_direita + 1);
}

int total_nos_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return 0;
	}
	if(*raiz == NULL){
		return 0;
	}
	int altura_esquerda = total_nos_arvore_binaria(&((*raiz)->esquerda));
	int altura_direita = total_nos_arvore_binaria(&((*raiz)->direita));
	return (altura_esquerda + altura_direita + 1);
}

void imprimir_preordem_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return;
	}
	if(*raiz != NULL){
		printf("%d\n", (*raiz)->dado);
		imprimir_preordem_arvore_binaria(&((*raiz)->esquerda));
		imprimir_preordem_arvore_binaria(&((*raiz)->direita));
	}
}

void imprimir_ordem_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return;
	}
	if(*raiz != NULL){
		imprimir_ordem_arvore_binaria(&((*raiz)->esquerda));
		printf("%d\n", (*raiz)->dado);
		imprimir_ordem_arvore_binaria(&((*raiz)->direita));
	}
}

void imprimir_posordem_arvore_binaria(ArvoreBinaria* raiz){
	if(raiz == NULL){
		return;
	}
	if(*raiz != NULL){
		imprimir_posordem_arvore_binaria(&((*raiz)->esquerda));
		imprimir_posordem_arvore_binaria(&((*raiz)->direita));
		printf("%d\n", (*raiz)->dado);
	}
}

int inserir_arvore_binaria(ArvoreBinaria* raiz, int valor){
	if(raiz == NULL){
		return 0;
	}
	struct NO* novo = (struct NO*) malloc(sizeof(struct NO));
	if(novo == NULL){
		return 0;
	}
	novo->dado = valor;
	novo->direita = NULL;
	novo->esquerda = NULL;
	if(*raiz == NULL){
		*raiz = novo;
	}else{
		struct NO* atual = *raiz;
		struct NO* anterior = NULL;
		while(atual != NULL){
			anterior = atual;
			if(valor == atual->dado){
				free(novo);
				return 0;
			}
			if(valor > atual->dado){
				atual = atual->direita;
			}else{
				atual = atual->esquerda;
			}
		}
		if(valor > anterior->dado){
			anterior->direita = novo;
		}else{
			anterior->esquerda = novo;
		}
	}
	return 1;
}

struct NO* remover_no_atual(struct NO* atual){
	struct NO *no1, *no2;
	if(atual->esquerda == NULL){
		no2 = atual->direita;
		free(atual);
		return no2;
	}
	no1 = atual;
	no2 = atual->esquerda;
	while(no2->direita != NULL){
		no1 = no2;
		no2 = no2->direita;
	}
	if(no1 != atual){
		no1->direita = no2->esquerda;
		no2->esquerda = atual->esquerda;
	}
	no2->direita = atual->direita;
	free(atual);
	return no2;
}

int remover_arvore_binaria(ArvoreBinaria* raiz, int valor){
	if(raiz == NULL){
		return 0;
	}
	struct NO* anterior = NULL;
	struct NO* atual = *raiz;
	while(atual != NULL){
		if(valor == atual->dado){
			if(atual == *raiz){
				*raiz = remover_no_atual(atual);
			}else{
				if(anterior->direita == atual){
					anterior->direita = remover_no_atual(atual);
				}else{
					anterior->esquerda = remover_no_atual(atual);
				}
			}
			return 1;
		}
		anterior = atual;
		if(valor > atual->dado){
			atual = atual->direita;
		}else{
			atual = atual->esquerda;
		}
	}
}

int consulta_arvore_binaria(ArvoreBinaria* raiz, int valor){
	if(raiz == NULL){
		return 0;
	}
	struct NO* atual = *raiz;
	while(atual != NULL){
		if(valor == atual->dado){
			return 1;
		}
		if(valor > atual->dado){
			atual = atual->direita;
		}else{
			atual = atual->esquerda;
		}
	}
	return 0;
}
