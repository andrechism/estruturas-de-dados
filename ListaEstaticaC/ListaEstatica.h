#define MAX 100

typedef struct lista Lista;

struct aluno {
	int matricula;
	char nome[80];
	float nota1, nota2;
};

typedef struct aluno Aluno;

Lista* criar_lista();

void destruir_lista(Lista* plista);

int tamanho_lista(Lista* plista);

int lista_cheia(Lista* plista);

int lista_vazia(Lista* plista);

int inserir_final_lista(Lista* plista, Aluno a);

int inserir_inicio_lista(Lista* plista, Aluno a);

int inserir_ordenadamente_lista(Lista* plista, Aluno a);

int remover_final_lista(Lista* plista);

int remover_inicio_lista(Lista* plista);

int remover_elemento_lista(Lista* plista, int matricula);

int consultar_posicao_lista(Lista* plista, int posicao, Aluno *a);

int consultar_matricula_lista(Lista* plista, int matricula, Aluno *a);
