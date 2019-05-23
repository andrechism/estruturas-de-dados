#include <stdlib.h>
#include "ListaCircular.h"

struct elemento {
	struct elemento *proximo;
	Aluno aluno;
};

typedef struct elemento ElementoLista;

struct listaAluno {
	ElementoLista* inicio;
	ElementoLista* fim;
	int tamanho;	
};

ListaAluno* criar_lista_alunos(){
	ListaAluno* lista = (ListaAluno*) malloc(sizeof(ListaAluno));
	if(lista != NULL){
		lista->inicio = NULL;
		lista->fim = NULL;
		lista->tamanho = 0;
	}
	return lista;
}

void destruir_lista_alunos(ListaAluno* lista){
	if(lista != NULL){
		if(lista->tamanho > 0){
			ElementoLista *no = lista->inicio, *aux = NULL;
			while(no != lista->fim){
				aux = no;
				no = no->proximo;
				free(aux);
			}
			free(no);
		}
		free(lista);
	}
}

int lista_alunos_vazia(ListaAluno* lista){
	if(lista == NULL){
		return -1;
	}
	if(lista->tamanho == 0){
		return 1;
	}
	return 0;
}

int tamanho_lista_alunos(ListaAluno* lista){
	if(lista == NULL){
		return -1;
	}
	return lista->tamanho;
}

int inserir_lista_alunos(ListaAluno* lista, Aluno aluno){
	if(lista == NULL){
		return 0;
	}
	ElementoLista* no = (ElementoLista*) malloc(sizeof(ElementoLista));
	if(no == NULL){
		return 0;
	}
	no->aluno = aluno;
	if(lista_alunos_vazia(lista)){
		lista->inicio = no;
		lista->fim = no;
		no->proximo = no;
	}else{
		lista->fim->proximo = no;
		lista->fim = no;
		no->proximo = lista->inicio;
	}
	lista->tamanho++;
	return 1;
}

int consultar_lista_alunos(ListaAluno* lista, Aluno* aluno, int index){
	if(lista == NULL){
		return 0;
	}
	if(index < 0 || index >= lista->tamanho){
		return 0;
	}
	ElementoLista* no = lista->inicio;
	int i = 0;
	while(i < index){
		no = no->proximo;
		i++;
	}
	*aluno = no->aluno;
	return 1;
}

int remover_lista_alunos(ListaAluno* lista, int matricula_aluno){
	if(lista == NULL){
		return 0;
	}
	if(lista_alunos_vazia(lista)){
		return 0;
	}
	ElementoLista *no = lista->inicio, *no_anterior = lista->fim;
	while(no != lista->fim && no->aluno.matricula != matricula_aluno){
		no_anterior = no;
		no = no->proximo;
	}
	if(no->aluno.matricula != matricula_aluno){
		return 0;
	}
	if(no == lista->inicio && no == lista->fim){
		lista->inicio = NULL;
		lista->fim = NULL;
	}else{
		if(no == lista->inicio){
			lista->inicio = no->proximo;
		}else if(no == lista->fim){
			lista->fim = no_anterior;
		}
		no_anterior->proximo = no->proximo;
	}
	free(no);
	lista->tamanho--;
	return 1;
}
