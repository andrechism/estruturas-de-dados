
public class Programa {
	
	public static void main(String[] args) {
		TelaFila tela = new TelaFila();
		tela.setVisible(true);
		new ControladorTelaFila(tela);
	}

}
