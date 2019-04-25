#include <stdlib.h>
#include "ListaEncadeada.h"

struct elemento {
	Aluno aluno;
	struct elemento *proximo;
};

typedef struct elemento ElementoLista;

ListaAluno* criar_lista_aluno(){
	ListaAluno* lista = (ListaAluno*) malloc(sizeof(ListaAluno));
	if(lista != NULL){
		*lista = NULL;
	}
	return lista;
}

void destruir_lista_aluno(ListaAluno* lista){
	if(lista != NULL){
		ElementoLista *no;
		while((*lista) != NULL){
			no = *lista;
			*lista = (*lista)->proximo;
			free(no);
		}
		free(lista);
	}
}

int tamanho_lista_aluno(ListaAluno* lista){
	if(lista == NULL){
		return 0;
	}
	int tamanho = 0;
	ElementoLista *no = *lista;
	while(no != NULL){
		tamanho++;
		no = no->proximo;
	}
	return tamanho;
}

int lista_aluno_vazia(ListaAluno* lista){
	if(lista == NULL){
		return 1;
	}
	if(*lista == NULL){
		return 1;
	}
	return 0;
}

int inserir_aluno_lista(ListaAluno* lista, Aluno aluno){
	if(lista == NULL){
		return 0;
	}
	ElementoLista* no = (ElementoLista*) malloc(sizeof(ElementoLista));
	if(no == NULL){
		return 0;
	}
	no->aluno = aluno;
	no->proximo = NULL;
	if((*lista) == NULL){
		*lista = no;
	}else{
		ElementoLista* aux = *lista;
		while(aux->proximo != NULL){
			aux = aux->proximo;
		}
		aux->proximo = no;
	}
	return 1;
}

int remover_aluno_lista(ListaAluno* lista, int matricula){
	if(lista == NULL){
		return 0;
	}
	ElementoLista *no_anterior, *no = *lista;
	while(no != NULL && no->aluno.matricula != matricula){
		no_anterior = no;
		no = no->proximo;
	}
	if(no == NULL){
		return 0;
	}
	if(no == *lista){
		*lista = no->proximo;
	}else{
		no_anterior->proximo = no->proximo;
	}
	free(no);
	return 1;
}

int consultar_aluno_lista(ListaAluno* lista, int indice, Aluno* aluno){
	if(lista == NULL || indice < 0){
		return 0;
	}
	ElementoLista* no = *lista;
	int i = 0;
	while(no != NULL && i < indice){
		no = no->proximo;
		i++;
	}
	if(no == NULL){
		return 0;
	}
	*aluno = no->aluno;
	return 1;
}
