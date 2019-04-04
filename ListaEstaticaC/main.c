#include <stdio.h>
#include <stdlib.h>
#include "ListaEstatica.h"

Lista *lista;

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
	inserir_ordenadamente_lista(lista, aluno);
	printf("Aluno salvo.\n\n");
}

void listar_alunos(){
	int tamanho = tamanho_lista(lista);
	if(tamanho == 0){
		printf("\nNao existe alunos cadastrados.");
	}else{
		int i;
		printf("\nLista de alunos:");
		Aluno aluno;
		for(i = 1; i <= tamanho; i++){
			consultar_posicao_lista(lista, i, &aluno);
			printf("\nMatricula: %d | Nome: %s", aluno.matricula, aluno.nome);
		}
	}
	printf("\n\n");
}

void consultar_aluno(){
	int matricula;
	printf("\nInforme a matricula do aluno: ");
	scanf("%d", &matricula);
	Aluno aluno;
	if(consultar_matricula_lista(lista, matricula, &aluno)){
		printf("Aluno: ");
		printf("\nMatricula: %d", aluno.matricula);
		printf("\nNome: %s", aluno.nome);
		printf("\nNota 1: %f", aluno.nota1);
		printf("\nNota 2: %f", aluno.nota2);
	}else{
		printf("Aluno nao encontrado.");
	}
	printf("\n\n");
}

void remover_aluno(){
	int matricula;
	printf("\nInforme a matricula do aluno que deseja remover: ");
	scanf("%d", &matricula);
	if(remover_elemento_lista(lista, matricula)){
		printf("Aluno removido.");
	}else{
		printf("Aluno nao encontrado.");
	}
	printf("\n\n");
}

main() {
	lista = criar_lista();
	int menu = 0;
	
	do{
		printf("Escolha uma opcao: ");
		printf("\n\n1 - Inserir novo aluno.");
		printf("\n2 - Listar alunos.");
		printf("\n3 - Consultar aluno.");
		printf("\n4 - Remover aluno.");
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
				consultar_aluno();
				break;
			case 4:
				remover_aluno();
				break;
			default:
				printf("Opcao invalida\n\n");
		}
	}while(menu != 0);	
}
