struct produto {
	int codigo;
	char descricao[80];
	float preco;
};

typedef struct produto Produto;

typedef struct pilhaProduto PilhaProduto;

PilhaProduto* criar_pilha_produtos();

void destruir_pilha_produtos(PilhaProduto* pilha);

int pilha_produtos_vazia(PilhaProduto* pilha);

int tamanho_pilha_produtos(PilhaProduto* pilha);

int inserir_pilha_produtos(PilhaProduto* pilha, Produto produto);

int remover_pilha_produtos(PilhaProduto* pilha);

int consultar_pilha_produtos(PilhaProduto* pilha, Produto* produto);

