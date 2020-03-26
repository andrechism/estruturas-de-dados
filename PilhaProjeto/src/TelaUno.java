import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaUno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbTamanho;
	private JLabel lbCarta;
	private JButton btProximaCarta;
	private JButton btIniciar;

	public TelaUno() {
		this.setTitle("Uno");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.lbTamanho = new JLabel("Quantidade de Cartas: " + 0);
		this.lbTamanho.setBounds(20, 20, 400, 20);
		this.lbTamanho.setFont(new Font("Times new Roman", Font.BOLD, 20));
		this.lbCarta = new JLabel("Sem Cartas");
		this.lbCarta.setFont(new Font("Serif", Font.BOLD, 25));
		this.lbCarta.setBounds(20, 40, 450, 300);
		this.lbCarta.setIcon(new ImageIcon("verso.jpg"));
		this.btProximaCarta = new JButton("Próxima Carta");
		this.btProximaCarta.setBounds(20, 350, 200, 25);
		this.btIniciar = new JButton("Iniciar");
		this.btIniciar.setBounds(250, 350, 200, 25);

		this.add(lbTamanho);
		this.add(lbCarta);
		this.add(btProximaCarta);
		this.add(btIniciar);
		this.setVisible(true);
	}

	public void exibirAlerta(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
	}

	public JLabel getLbTamanho() {
		return lbTamanho;
	}

	public void setLbTamanho(JLabel lbTamanho) {
		this.lbTamanho = lbTamanho;
	}

	public JLabel getLbCarta() {
		return lbCarta;
	}

	public void setLbCarta(JLabel lbCarta) {
		this.lbCarta = lbCarta;
	}

	public JButton getBtProximaCarta() {
		return btProximaCarta;
	}

	public void setBtProximaCarta(JButton btProximaCarta) {
		this.btProximaCarta = btProximaCarta;
	}

	public JButton getBtIniciar() {
		return btIniciar;
	}

	public void setBtIniciar(JButton btIniciar) {
		this.btIniciar = btIniciar;
	}

}
