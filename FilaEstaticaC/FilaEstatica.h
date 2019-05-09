#define MAX 15
struct produto {
	int codigo;
	char nome[60];
	float preco;
};

typedef struct produto Produto;

typedef struct filaProdutos FilaProdutos;

FilaProdutos* criar_fila_produtos();

void destruir_fila_produtos(FilaProdutos* fila);

int tamanho_fila_produtos(FilaProdutos* fila);

int fila_produto_cheia(FilaProdutos* fila);

int fila_produto_vazia(FilaProdutos* fila);

int inserir_fila_produtos(FilaProdutos* fila, Produto produto);

int remover_fila_produtos(FilaProdutos* fila);

int consultar_fila_produtos(FilaProdutos* fila, Produto* produto);
