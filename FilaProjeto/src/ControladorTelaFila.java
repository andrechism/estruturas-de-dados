import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTelaFila {
	
	private TelaFila tela;
	private int numeroAtendimento = 0;

	// Você utilizar uma Fila genérica
	//private Fila<Atendimento> fila = new Fila<>();
	
	// Ou pode utilizar uma Pilha específica de atendimentos
	private FilaAtendimento fila = new FilaAtendimento();
	
	public ControladorTelaFila(TelaFila telaFila) {
		tela = telaFila;
		tela.getBtCadastrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = tela.getTfNome().getText();
				if(nome.trim().equals("")) {
					tela.exibirAlerta("Informe o nome da pessoa");
				}else {
					numeroAtendimento++;
					Atendimento atendimento = new Atendimento();
					atendimento.setNumero(numeroAtendimento);
					atendimento.setNome(nome);
					fila.inserir(atendimento);
					atualizarTelaAtendimento();
					tela.limparCampos();
				}
			}
		});
		tela.getBtProximo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fila.getTamanho() == 0) {
					tela.exibirAlerta("A fila está vazia.");
				}else {
					fila.remover();					
					atualizarTelaAtendimento();
				}
			}
		});
	}
	
	public void atualizarTelaAtendimento() {
		tela.getLbTamanho().setText("Tamanho da Fila: " + fila.getTamanho());
		if(fila.getTamanho() > 0) {			
			tela.getLbAtendimento().setText(fila.get().toString());
		}else {
			tela.getLbAtendimento().setText("Fila vazia");
		}
	}

}
