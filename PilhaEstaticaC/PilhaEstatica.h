#define MAX 15
struct produto {
	int codigo;
	char nome[60];
	float preco;
};

typedef struct produto Produto;

typedef struct pilhaProdutos PilhaProdutos;

PilhaProdutos* criar_pilha_produtos();

void destruir_pilha_produtos(PilhaProdutos* pilha);

int tamanho_pilha_produtos(PilhaProdutos* pilha);

int pilha_produtos_cheia(PilhaProdutos* pilha);

int pilha_produtos_vazia(PilhaProdutos* pilha);

int inserir_pilha_produtos(PilhaProdutos* pilha, Produto produto);

int remover_pilha_produtos(PilhaProdutos* pilha);

int consultar_pilha_produtos(PilhaProdutos* pilha, Produto* produto);
