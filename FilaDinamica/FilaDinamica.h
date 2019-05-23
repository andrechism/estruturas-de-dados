struct produto {
	int codigo;
	char descricao[80];
	float preco;
};

typedef struct produto Produto;

typedef struct filaProduto FilaProduto;

FilaProduto* criar_fila_produtos();

void destruir_fila_produtos(FilaProduto* fila);

int fila_produtos_vazia(FilaProduto* fila);

int tamanho_fila_produtos(FilaProduto* fila);

int inserir_fila_produtos(FilaProduto* fila, Produto produto);

int remover_fila_produtos(FilaProduto* fila);

int consultar_fila_produtos(FilaProduto* fila, Produto* produto);
