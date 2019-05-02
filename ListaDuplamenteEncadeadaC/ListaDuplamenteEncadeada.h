struct aluno {
	int matricula;
	char nome[60];
	float nota1, nota2;
};

typedef struct aluno Aluno;

typedef struct elemento* ListaAluno;

ListaAluno* criar_lista_aluno();

void destruir_lista_aluno(ListaAluno* lista);

int tamanho_lista_aluno(ListaAluno* lista);

int lista_aluno_vazia(ListaAluno* lista);

int inserir_aluno_lista(ListaAluno* lista, Aluno aluno);

int remover_aluno_lista(ListaAluno* lista, int indice);

int consultar_aluno_lista(ListaAluno* lista, int indice, Aluno* aluno);
