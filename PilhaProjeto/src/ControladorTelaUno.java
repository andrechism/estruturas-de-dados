import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class ControladorTelaUno {
	
	private TelaUno tela;
	// Você utilizar uma Pilha genérica
	//private Pilha<Carta> pilha = new Pilha<>();
	
	// Ou pode utilizar uma Pilha específica de cartas
	private PilhaCarta pilha = new PilhaCarta();
	
	public ControladorTelaUno(TelaUno telaUno) {
		tela = telaUno;
		tela.getBtProximaCarta().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pilha.getTamanho() == 0) {
					tela.exibirAlerta("Sem cartas no baralho.");
				}else {					
					pilha.remover();
					atualizarTelaUno();
				}
			}
		});
		tela.getBtIniciar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				embaralhar();
			}
		});
	}
	
	public void embaralhar() {
		if(pilha.getTamanho() == 0) {			
			List<Carta> cartas = new ArrayList<>();
			cartas.add(new Carta("Amarelo - Bloqueio", "amarelo_bloqueio.jpg"));
			cartas.add(new Carta("Amarelo - Dois", "amarelo_dois.jpg"));
			cartas.add(new Carta("Amarelo - Seis", "amarelo_seis.jpg"));
			cartas.add(new Carta("Azul - Inverter", "azul_inverte.jpg"));
			cartas.add(new Carta("Azul - Sete", "azul_sete.jpg"));
			cartas.add(new Carta("Azul - Três", "azul_tres.jpg"));
			cartas.add(new Carta("Azul - Zero", "azul_zero.jpg"));
			cartas.add(new Carta("Coringa - +4", "coringa_maisquatro.jpg"));
			cartas.add(new Carta("Coringa - Troca de Cor", "coringa_trocacor.jpg"));
			cartas.add(new Carta("Verde - +2", "verde_maisdois.jpg"));
			cartas.add(new Carta("Verde - Oito", "verde_oito.jpg"));
			cartas.add(new Carta("Verde - Quatro", "verde_quatro.jpg"));
			cartas.add(new Carta("Vermelho - Cinco", "vermelho_cinco.jpg"));
			cartas.add(new Carta("Vermelho - Nove", "vermelho_nove.jpg"));
			cartas.add(new Carta("Vermelho - Um", "vermelho_um.jpg"));
			
			Collections.shuffle(cartas);
			
			for(Carta carta : cartas) {
				pilha.inserir(carta);
			}
			atualizarTelaUno();
		}else {
			tela.exibirAlerta("Já existe cartas no baralho.");
		}
	}
	
	public void atualizarTelaUno() {
		tela.getLbTamanho().setText("Quantidade de Cartas: " + pilha.getTamanho());
		if(pilha.getTamanho() > 0) {			
			tela.getLbCarta().setText(pilha.get().getNome());
			tela.getLbCarta().setIcon(new ImageIcon(pilha.get().getImagem()));
		}else {
			tela.getLbCarta().setText("Sem Cartas");
			tela.getLbCarta().setIcon(new ImageIcon("verso.jpg"));
		}
	}

}
