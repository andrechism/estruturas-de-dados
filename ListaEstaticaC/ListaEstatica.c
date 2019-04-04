#include <stdlib.h>
#include "ListaEstatica.h"

struct lista {
	int quantidade;
	Aluno dados[MAX];
};

Lista* criar_lista(){
	Lista *plista = (Lista*) malloc(sizeof(Lista));
	if(plista != NULL){
		plista->quantidade = 0;
	}
	return plista;
}

void destruir_lista(Lista* plista){
	free(plista);
}

int tamanho_lista(Lista* plista){
	if(plista == NULL){
		return -1;
	}
	return plista->quantidade;
}

int lista_cheia(Lista* plista){
	if(plista == NULL){
		return -1;
	}
	return (plista->quantidade == MAX);
}

int lista_vazia(Lista* plista){
	if(plista == NULL){
		return -1;
	}
	return (plista->quantidade == 0);
}

int inserir_final_lista(Lista* plista, Aluno a){
	if(plista == NULL){
		return 0;
	}
	if(lista_cheia(plista)){
		return 0;
	}
	plista->dados[plista->quantidade] = a;
	plista->quantidade++;
	return 1;
}

int inserir_inicio_lista(Lista* plista, Aluno a){
	if(plista == NULL){
		return 0;
	}
	if(lista_cheia(plista)){
		return 0;
	}
	int i;
	for(i = plista->quantidade-1; i >= 0; i--){
		plista->dados[i+1] = plista->dados[i];
	}
	plista->dados[0] = a;
	plista->quantidade++;
	return 1;
}

int inserir_ordenadamente_lista(Lista* plista, Aluno a){
	if(plista == NULL){
		return 0;
	}
	if(lista_cheia(plista)){
		return 0;
	}
	int k, i = 0;
	while(i < plista->quantidade && plista->dados[i].matricula < a.matricula){
		i++;
	}
	for(k = plista->quantidade - 1; k >= i; k--){
		plista->dados[k + 1] = plista->dados[k];
	}
	plista->dados[i] = a;
	plista->quantidade++;
	return 1;
}

int remover_final_lista(Lista* plista){
	if(plista == NULL){
		return 0;
	}
	if(lista_vazia(plista)){
		return 0;
	}
	plista->quantidade--;
	return 1;
}

int remover_inicio_lista(Lista* plista){
	if(plista == NULL){
		return 0;
	}
	if(lista_vazia(plista)){
		return 0;
	}
	int k = 0;
	for(k = 0; k < plista->quantidade-1; k++){
		plista->dados[k] = plista->dados[k+1];
	}
	plista->quantidade--;
	return 1;
}

int remover_elemento_lista(Lista* plista, int matricula){
	if(plista == NULL){
		return 0;
	}
	if(lista_vazia(plista)){
		return 0;
	}
	int k, i = 0;
	while(i < plista->quantidade && plista->dados[i].matricula != matricula){
		i++;
	}
	if(i == plista->quantidade){
		return 0;
	}
	for(k = i; k < plista->quantidade-1; k++){
		plista->dados[k] = plista->dados[k+1];
	}
	plista->quantidade--;
	return 1;
}

int consultar_posicao_lista(Lista* plista, int posicao, Aluno *a){
	if(plista == NULL || posicao <= 0 || posicao > plista->quantidade){
		return 0;
	}
	*a = plista->dados[posicao-1];
	return 1;
}

int consultar_matricula_lista(Lista* plista, int matricula, Aluno *a){
	if(plista == NULL){
		return 0;
	}
	int i = 0;
	while(i < plista->quantidade && plista->dados[i].matricula != matricula){
		i++;
	}
	if(i == plista->quantidade){
		return 0;
	}
	*a = plista->dados[i];
	return 1;
}
