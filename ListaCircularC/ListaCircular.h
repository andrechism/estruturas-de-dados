#define MAX 15

struct aluno {
	int matricula;
	char nome[60];
	float nota1, nota2;
};

typedef struct aluno Aluno;

typedef struct listaAluno ListaAluno;

ListaAluno* criar_lista_alunos();

void destruir_lista_alunos(ListaAluno* lista);

int lista_alunos_vazia(ListaAluno* lista);

int tamanho_lista_alunos(ListaAluno* lista);

int inserir_lista_alunos(ListaAluno* lista, Aluno aluno);

int consultar_lista_alunos(ListaAluno* lista, Aluno* aluno, int index);

int remover_lista_alunos(ListaAluno* lista, int matricula_aluno);
