import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TelaProdutosControlador {
	
	private TelaProdutos telaProdutos;
	private int codigoProduto = 1;
	private ILista listaProdutos = new ListaProdutoDinamica();
	
	public TelaProdutosControlador(TelaProdutos tela) {
		this.telaProdutos = tela;
		
		this.telaProdutos.getBtCadastrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String descricao = telaProdutos.getTfDescricao().getText();
				String precoString = telaProdutos.getTfPreco().getText();
				if(descricao.trim().equals("")) {
					telaProdutos.exibirAlerta("Informe a descrição do produto.");
				}else {
					float preco = 0;
					try {
						preco = Float.parseFloat(precoString);
						Produto produto = new Produto();
						produto.setCodigo(codigoProduto);
						produto.setDescricao(descricao);
						produto.setPreco(preco);
						listaProdutos.adicionar(produto);
						telaProdutos.atualizarTabela(listaProdutos);
						codigoProduto++;
						telaProdutos.limparCampos();
					}catch(NumberFormatException err) {
						telaProdutos.exibirAlerta("Informe um preço válido.");
					}
				}
			}
		});
		this.telaProdutos.getBtRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = telaProdutos.getTabela().getSelectedRow();
				if(linhaSelecionada < 0) {
					telaProdutos.exibirAlerta("Selecione um produto para ser removido.");
				}else {
					Produto produto = listaProdutos.get(linhaSelecionada);
					int confirm = JOptionPane.showConfirmDialog(null, "Você deseja remover o produto " + produto + "?");
					if(confirm == 0) {
						listaProdutos.remover(produto.getCodigo());
						telaProdutos.atualizarTabela(listaProdutos);
					}
				}
			}
		});
	}
	
}
