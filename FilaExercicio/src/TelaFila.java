import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaFila extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbTamanho;
	private JLabel lbProximo;
	private JLabel lbAtendimento;
	private JButton btCadastrar;
	private JButton btProximo;

	public TelaFila() {
		this.setTitle("Fila de Atendimento");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.lbNome = new JLabel("Nome");
		this.lbNome.setBounds(20, 20, 150, 20);
		this.tfNome = new JTextField("");
		this.tfNome.setBounds(20, 50, 350, 25);
		this.btCadastrar = new JButton("Incluir na Fila");
		this.btCadastrar.setBounds(20, 85, 200, 25);
		this.lbTamanho = new JLabel("Tamanho da Fila: " + 0);
		this.lbTamanho.setBounds(20, 170, 200, 20);
		this.lbTamanho.setFont(new Font("Times new Roman", Font.BOLD, 20));
		this.lbProximo = new JLabel("Atendimento da Vez: ");
		this.lbProximo.setBounds(20, 240, 200, 20);
		this.lbProximo.setFont(new Font("Times new Roman", Font.BOLD, 20));
		this.lbAtendimento = new JLabel("Fila vazia");
		this.lbAtendimento.setFont(new Font("Times new Roman", Font.BOLD, 30));
		this.lbAtendimento.setBounds(20, 250, 600, 80);
		this.lbAtendimento.setForeground(Color.GRAY);
		this.btProximo = new JButton("Chamar Próximo");
		this.btProximo.setBounds(20, 330, 200, 25);

		this.add(btCadastrar);
		this.add(lbNome);
		this.add(tfNome);
		this.add(lbTamanho);
		this.add(lbProximo);
		this.add(lbAtendimento);
		this.add(btProximo);

		setVisible(true);
	}

	public void limparCampos() {
		tfNome.setText("");
	}

	public void exibirAlerta(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
	}

	public JLabel getLbNome() {
		return lbNome;
	}

	public void setLbNome(JLabel lbNome) {
		this.lbNome = lbNome;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JLabel getLbTamanho() {
		return lbTamanho;
	}

	public void setLbTamanho(JLabel lbTamanho) {
		this.lbTamanho = lbTamanho;
	}

	public JLabel getLbProximo() {
		return lbProximo;
	}

	public void setLbProximo(JLabel lbProximo) {
		this.lbProximo = lbProximo;
	}

	public JLabel getLbAtendimento() {
		return lbAtendimento;
	}

	public void setLbAtendimento(JLabel lbAtendimento) {
		this.lbAtendimento = lbAtendimento;
	}

	public JButton getBtCadastrar() {
		return btCadastrar;
	}

	public void setBtCadastrar(JButton btCadastrar) {
		this.btCadastrar = btCadastrar;
	}

	public JButton getBtProximo() {
		return btProximo;
	}

	public void setBtProximo(JButton btProximo) {
		this.btProximo = btProximo;
	}

}