package Views.FluxoCheckin;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaConfirmacaoCheckin extends JFrame implements Serializable {

	private static final long serialVersionUID = 8333899366496520507L;
	//private JFrame frame;

	/**
	 * Create the application.
	 */
	public TelaConfirmacaoCheckin() {
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
		
		JLabel lblNewLabel = new JLabel("CHECK-IN REALIZADO COM SUCESSO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(83, 107, 288, 20);
		this.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.setBounds(157, 154, 103, 21);
		this.getContentPane().add(btnNewButton);
	}

}
