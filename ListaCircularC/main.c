#include <stdio.h>
#include <stdlib.h>
#include "ListaCircular.h"

ListaAluno* lista;

void cadastrar_aluno(){
	Aluno aluno;
	printf("\nInforme a matricula do aluno: ");
	scanf("%d", &aluno.matricula);
	fflush(stdin);
	printf("Informe o nome do aluno: ");
	gets(aluno.nome);
	fflush(stdin);
	printf("Informe a nota 1 do aluno: ");
	scanf("%f", &aluno.nota1);
	fflush(stdin);
	printf("Informe a nota 2 do aluno: ");
	scanf("%f", &aluno.nota2);
	fflush(stdin);
	inserir_lista_alunos(lista, aluno);
	printf("Aluno salvo.\n\n");
}

void listar_alunos(){
	int tamanho = tamanho_lista_alunos(lista);
	if(tamanho == 0){
		printf("\nNao existe alunos cadastrados.");
	}else{
		int i;
		printf("\nLista de alunos:");
		Aluno aluno;
		for(i = 0; i < tamanho; i++){
			consultar_lista_alunos(lista, &aluno, i);
			printf("\nMatricula: %d | Nome: %s", aluno.matricula, aluno.nome);
		}
	}
	printf("\n\n");
}

void remover_aluno(){
	int matricula;
	printf("\nInforme a matricula do aluno que deseja remover: ");
	scanf("%d", &matricula);
	if(remover_lista_alunos(lista, matricula)){
		printf("Aluno removido.");
	}else{
		printf("Aluno nao encontrado.");
	}
	printf("\n\n");
}

main() {
	lista = criar_lista_alunos();
	int menu = 0;
	
	do{
		printf("Escolha uma opcao: ");
		printf("\n\n1 - Inserir novo aluno.");
		printf("\n2 - Listar alunos.");
		printf("\n3 - Remover aluno.");
		printf("\n0 - Sair.");
		printf("\nEscolha: ");
		scanf("%d", &menu);
		switch(menu){
			case 0:
				printf("\n\nFim do programa...");
				break;
			case 1:
				cadastrar_aluno();
				break;
			case 2:
				listar_alunos();
				break;
			case 3:
				remover_aluno();
				break;
			default:
				printf("Opcao invalida\n\n");
		}
	}while(menu != 0);
	destruir_lista_alunos(lista);
}
