package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaConfirmacaoSolicitacao extends JFrame implements Serializable {

	private static final long serialVersionUID = -5834271566170065824L;
	//private JFrame frame;

	/**
	 * Create the application.
	 */
	public TelaConfirmacaoSolicitacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOLICITAÇÃO REALIZADA COM SUCESSO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(67, 107, 316, 20);
		this.getContentPane().add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.setBounds(158, 137, 111, 21);
		this.getContentPane().add(btnNewButton);
	}

}
