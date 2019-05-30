typedef struct NO* ArvoreBinaria;

ArvoreBinaria* criar_arvore_binaria();

void destruir_arvore_binaria(ArvoreBinaria* raiz);

int arvore_binaria_vazia(ArvoreBinaria* raiz);

int altura_arvore_binaria(ArvoreBinaria* raiz);

int total_nos_arvore_binaria(ArvoreBinaria* raiz);

void imprimir_preordem_arvore_binaria(ArvoreBinaria* raiz);

void imprimir_ordem_arvore_binaria(ArvoreBinaria* raiz);

void imprimir_posordem_arvore_binaria(ArvoreBinaria* raiz);

int inserir_arvore_binaria(ArvoreBinaria* raiz, int valor);

int remover_arvore_binaria(ArvoreBinaria* raiz, int valor);

int consulta_arvore_binaria(ArvoreBinaria* raiz, int valor);
